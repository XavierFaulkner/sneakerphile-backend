package com.snkrphile.service.api;

import com.snkrphile.service.entities.Closet;
import com.snkrphile.service.entities.Shoe;
import com.snkrphile.service.entities.TradeOffer;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.response.LongAndBooleanResponse;
import com.snkrphile.service.response.ResponseHandler;
import com.snkrphile.service.response.forms.TradeOfferForm;
import com.snkrphile.service.services.ClosetService;
import com.snkrphile.service.services.ShoeService;
import com.snkrphile.service.services.TradeOfferService;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class TradeController {
    private final UserService userService;
    private final TradeOfferService tradeOfferService;
    private final ShoeService shoeService;
    private final ClosetService closetService;

    @PostMapping("/trade/send-trade-offer")
    public ResponseEntity<Object> sendTradeOffer(@RequestBody TradeOfferForm offerForm, Authentication auth) {
        TradeOffer offer = new TradeOffer();
        User principal = userService.getUser(auth.getName());
        String principalUsername = principal.getUsername();
        offer.setFromUser(principalUsername);
        offer.setUser(userService.getUser(offerForm.getSendTo()));
        offer.setShoeOne(offerForm.getShoeOne());
        offer.setShoeTwo(offerForm.getShoeTwo());
        try {
            tradeOfferService.saveTradeOffer(offer);
            return ResponseHandler.generateResponse("Trade offer sent.", HttpStatus.OK, offer);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @PutMapping("/trade/respond-to-offer")
    public ResponseEntity<Object> respondToOffer(@RequestBody LongAndBooleanResponse response) {
        TradeOffer offer = tradeOfferService.findById(response.getId()).get();
        if(response.getAccept()) {
            //swap shoes
            Shoe shoeOne = shoeService.findById(offer.getShoeOne()).get();
            Shoe shoeTwo = shoeService.findById(offer.getShoeTwo()).get();
            Closet temp = shoeOne.getCloset();
            shoeOne.assignCloset(shoeTwo.getCloset());
            shoeTwo.assignCloset(temp);
            //delete trade offer
            tradeOfferService.deleteOffer(offer);
            return ResponseHandler.generateResponse("Trade accepted.", HttpStatus.OK, null);
        } else {
            tradeOfferService.deleteOffer(offer);
            return ResponseHandler.generateResponse("Trade Declined", HttpStatus.OK, null);
        }
    }
}
