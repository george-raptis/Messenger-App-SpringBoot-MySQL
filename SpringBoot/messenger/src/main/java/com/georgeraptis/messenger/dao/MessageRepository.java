package com.georgeraptis.messenger.dao;

import com.georgeraptis.messenger.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    public List<Message> findMessagesByReceiver(int receiver);

    public List<Message> findMessagesBySender(int sender);
}
