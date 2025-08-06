package com.example.cld;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> saveMessage(@RequestBody String content) {
        messageService.saveMessage(content);
        return new ResponseEntity<>("Message saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> getAllMessages() {
        return ResponseEntity.ok(messageService.getAllMessages());
    }
}
