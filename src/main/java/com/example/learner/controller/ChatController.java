package com.example.learner.controller;

import com.example.learner.dto.ChatRequestDto;
import com.example.learner.dto.ChatResponseDto;
import com.example.learner.service.ChatService;
import com.example.learner.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChatController {
    private ChatService chatService;

    public ChatController(ChatService chatService){
        this.chatService = chatService;
    }


    @PostMapping("/chat")
    public ResponseEntity chat(@Valid @RequestBody ChatRequestDto chatRequestDto){
        String response = chatService.respond(chatRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
