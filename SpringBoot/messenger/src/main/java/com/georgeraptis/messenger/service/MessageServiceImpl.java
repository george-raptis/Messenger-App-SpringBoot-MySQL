package com.georgeraptis.messenger.service;

import com.georgeraptis.messenger.dao.MessageRepository;
import com.georgeraptis.messenger.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository theMessageRepository) {
        messageRepository = theMessageRepository;
    }

    @Override
    @Transactional(readOnly=true)
    public List<Message> getAll() {
        return messageRepository.findAll();
    }

    @Override
    public List<Message> getReceiverMessages(int id) {
        return messageRepository.findMessagesByReceiver(id);
    }

    @Override
    public List<Message> getSenderMessages(int id) {
        return messageRepository.findMessagesBySender(id);
    }

    @Override
    public void deleteById(int id) {
        messageRepository.deleteById(id);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }
}
