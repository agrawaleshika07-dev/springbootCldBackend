package com.example.proj;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(String message) {
        messageRepository.save(new Message(message));
    }

    public List<String> getAllMessages() {
        return messageRepository.findAll().stream().map(Message::getContent).collect(Collectors.toList());
    }
}
