package com.georgeraptis.messenger.controller;

import com.georgeraptis.messenger.entity.Message;
import com.georgeraptis.messenger.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class MessageRestController {

    private MessageService messageService;

    @Autowired
    public MessageRestController(MessageService theMessageService) {
        messageService = theMessageService;
    }

    @GetMapping("/getAllMessages")
    public List<Message> getAll() {
        return messageService.getAll();
    }

    @GetMapping("/inbox/{userId}")
    public List<Message> getReceiverMessages(@PathVariable Integer userId) {
        return messageService.getReceiverMessages(userId);
    }

    @GetMapping("/outbox/{userId}")
    public List<Message> getSenderMessages(@PathVariable Integer userId) {
        return messageService.getSenderMessages(userId);
    }

    @PostMapping("/messages/send")
    public Message sendMessage(@RequestBody Message message) {
        Date date = new Date();
        long time = date.getTime();
        Timestamp timestamp = new Timestamp(time);
        message.setTimeSent(timestamp);
        messageService.saveMessage(message);
        return  message;
    }

    @DeleteMapping("/messages/{messageId}")
    public void deleteMessageById(@PathVariable Integer messageId) {
        messageService.deleteById(messageId);
    }

}