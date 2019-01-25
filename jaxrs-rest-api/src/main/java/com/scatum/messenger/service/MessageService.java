package com.scatum.messenger.service;

import com.scatum.messenger.exception.DataNotFoundException;
import com.scatum.messenger.model.Message;
import com.scatum.messenger.database.Database;

import java.util.*;

public class MessageService {

    private Map<Long, Message> messages = Database.getMessages();

    public MessageService() {
        messages.put(1L, new Message(1, "Hello World", "Aramazd"));
        messages.put(2L, new Message(2, "Refreshing..", "Aramazd"));
        messages.put(3L, new Message(3, "Woof woof..", "Computer"));
    }

    public List<Message> getAllMessages() {
        return new ArrayList<>(messages.values());
    }

    public List<Message> getAllMessagesForYear(int year) {
        List<Message> messagesForYear = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        for (Message message : messages.values()) {
            calendar.setTime(message.getCreated());
            if (calendar.get(Calendar.YEAR) == year) {
                messagesForYear.add(message);
            }
        }

        return messagesForYear;
    }

    public List<Message> getAllMessagesPaginated(int start, int size) {
        ArrayList<Message> list = new ArrayList<>(messages.values());
        if (start + size > list.size()) return new ArrayList<>();
        return list.subList(start, start + size);
    }

    public Message getMessage(long id) {
        Message message = messages.get(id);
        if (message == null) {
            throw new DataNotFoundException("Message with id " + id + " not found");
        }
        return message;
    }

    public Message addMessage(Message message) {
        Message newMessage = message;
        newMessage.setId(messages.size() + 1);
        messages.put(newMessage.getId(), newMessage);
        return newMessage;
    }

    public Message updateMessage(Message message) {
        if (message.getId() <= 0) {
            return null;
        }
        messages.put(message.getId(), message);
        return message;
    }

    public Message removeMessage(long id) {
        return messages.remove(id);
    }
}
