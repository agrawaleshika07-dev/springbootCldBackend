package com.example.cld;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public void saveMessage(String content) {
        messageRepository.save(new Message(content));
    }

    public List<String> getAllMessages() {
        return messageRepository.findAll().stream().map(Message::getContent).collect(Collectors.toList());
    }
}
