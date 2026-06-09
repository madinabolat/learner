package com.example.learner.service;

import com.example.learner.dto.ChatRequestDto;

public interface ChatService {
    String respond(ChatRequestDto chatRequestDto);
}
