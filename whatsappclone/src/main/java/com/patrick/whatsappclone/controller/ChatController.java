package com.patrick.whatsappclone.controller;

import com.patrick.whatsappclone.chat.ChatService;
import com.patrick.whatsappclone.chat.ChatsResponse;
import com.patrick.whatsappclone.common.StringResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/chats")
@RequiredArgsConstructor
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ResponseEntity<StringResponse> createChat(
            @RequestParam(name = "sender-id") String senderId,
            @RequestParam(name = "receiver-id") String receiverId
    ){
        final String chatId = chatService.createChat(senderId, receiverId);
        StringResponse response = StringResponse.builder()
                .response(chatId)
                .build();
        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<List<ChatsResponse>> getChatsByReceiver(Authentication authentication){
        return ResponseEntity.ok(chatService.getChatsByReceiverId(authentication));
    }
}
