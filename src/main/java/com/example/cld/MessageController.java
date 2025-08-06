package com.example.cld;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }

    @PostMapping
    public String addMessage(@RequestBody String messageContent) {
        messageService.saveMessage(messageContent);
        return "Message added";
    }

    @GetMapping
    public List<String> getAllMessages() {
        return messageService.getAllMessages();
    }
}
