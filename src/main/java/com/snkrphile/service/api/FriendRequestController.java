package com.snkrphile.service.api;

import com.snkrphile.service.entities.FriendRequest;
import com.snkrphile.service.entities.User;
import com.snkrphile.service.response.LongAndBooleanResponse;
import com.snkrphile.service.response.ResponseHandler;
import com.snkrphile.service.response.forms.FriendRequestForm;
import com.snkrphile.service.services.FriendRequestService;
import com.snkrphile.service.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class FriendRequestController {
    private final FriendRequestService friendRequestService;
    private final UserService userService;

    @PostMapping("/friend-request/response")
    String addFriendToUser(@RequestBody LongAndBooleanResponse response, Authentication auth) {
        User principal = userService.getUser(auth.getName());
        FriendRequest request = friendRequestService.findById(response.getId()).get();
        if(response.getAccept()) {
            userService.addFriendToUser(principal.getUsername(), request.getFromUser());
            friendRequestService.deleteRequest(request);
            return "Friend request from " + request.getFromUser() + " accepted.";
        } else {
            friendRequestService.deleteRequest(request);
            return "Friend request from " + request.getFromUser() + " declined.";
        }
    }

    @PostMapping("/friend-request/send")
    public ResponseEntity<Object> sendFriendRequest(@RequestBody FriendRequestForm requestForm, Authentication auth) {
        try {
            User principal = userService.getUser(auth.getName());
            User receiver = userService.getUser(requestForm.getSendTo());
            FriendRequest request = new FriendRequest(principal.getUsername(), receiver);
            friendRequestService.saveFriendRequest(request);
            //creat alert

            return ResponseHandler.generateResponse("Friend request sent to " + receiver.getUsername(), HttpStatus.OK, request);
        } catch(Exception e) {
            return ResponseHandler.generateResponse(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }
}
