package com.patrick.whatsappclone.chat;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ChatMapper {
    public ChatsResponse toChatResponse(Chat chat, String senderId) {
        return ChatsResponse.builder()
                .id(chat.getId())
                .name(chat.getChatName(senderId))
                .unreadCount(chat.getUnreadMessages(senderId))
                .lastMessage(chat.getLastMessage())
                .isRecipientOline(chat.getRecipient().isUserOnline())
                .senderId(chat.getSender().getId())
                .receiverId(chat.getRecipient().getId())
                .build();
    }

}
