package com.georgeraptis.messenger.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="message")
    private String message;

    @Column(name="sender")
    private int sender;

    @Column(name="receiver")
    private int receiver;

    @Column(name="time_sent")
    private Timestamp timeSent;

    public Message() {
    }

    public Message(String message, int sender, int receiver, Timestamp timeSent) {
        this.message = message;
        this.sender = sender;
        this.receiver = receiver;
        this.timeSent = timeSent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public Timestamp getTimeSent() {
        return timeSent;
    }

    public void setTimeSent(Timestamp timeSent) {
        this.timeSent = timeSent;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", sender='" + sender + '\'' +
                ", receiver='" + receiver + '\'' +
                ", timeSent=" + timeSent +
                '}';
    }
}
