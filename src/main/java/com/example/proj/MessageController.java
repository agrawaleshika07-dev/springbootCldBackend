package com.example.proj;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping("/messages")
    public void addMessage(@RequestBody String message) {
        messageService.saveMessage(message);
    }

    @GetMapping("/messages")
    public List<String> getAllMessages() {
        return messageService.getAllMessages();
    }
}
