package com.example.learner.service;

import com.example.learner.dto.ChatRequestDto;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService{
    @Override
    public String respond(ChatRequestDto chatRequestDto) {
        return "This is a dummy response";
    }
}
