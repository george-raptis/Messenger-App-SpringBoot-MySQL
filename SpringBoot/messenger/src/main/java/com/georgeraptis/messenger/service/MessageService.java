package com.georgeraptis.messenger.service;

import com.georgeraptis.messenger.entity.Message;

import java.util.List;

public interface MessageService {

    public List<Message> getAll();

    public List<Message> getReceiverMessages(int id);

    public List<Message> getSenderMessages(int id);

    public void deleteById(int id);

    public void saveMessage(Message message);
}
