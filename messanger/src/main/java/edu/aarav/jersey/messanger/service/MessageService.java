package edu.aarav.jersey.messanger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import edu.aarav.jersey.messanger.db.MyDataBase;
import edu.aarav.jersey.messanger.domain.Message;
import edu.aarav.jersey.messanger.ext.DataNotFoundException;

public class MessageService {
	private Map<Long, Message> messages;

	@SuppressWarnings("deprecation")
	public MessageService() {
		messages = MyDataBase.getMessages();
		messages.put(1L, new Message(1L, "Hello World!", new Date(), "Avinash"));
		messages.put(2L, new Message(2L, "Hello Jersey!", new Date(), "Aarav"));
		messages.put(3L, new Message(3L, "Hello Rest", new Date(), "Avi"));
		messages.put(4L, new Message(4L, "Happy Mothers Day!", new Date(2016, 5, 14), "admin"));
		messages.put(5L, new Message(5L, "Happy BirthDay!", new Date(2016, 1, 19), "aarav"));
	}

	/*
	 * Return all messages
	 */
	public List<Message> getAllMessages() {
		return new ArrayList<>(messages.values());
	}
	
	/*
	 * Return all those messages posted in specified year
	 */
	public List<Message> getAllMessagesForYear(int year){
		ArrayList<Message> msgs = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for (Message message : messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year){
				msgs.add(message);
			}
		}
		return msgs;
	}
	
	/*
	 * Return all messages that comes under specified pages.
	 */
	public List<Message> getAllMessagesPaginated(int start, int size){
		ArrayList<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size())
			return new ArrayList<Message>();
		return list.subList(start, size);
	}
	

	public Message getMessage(Long id) {
		Message message = messages.get(id);
		if(message == null){
			// Throwing user defined exception.
			throw new DataNotFoundException("Message with id: "+id+" not found");
		}
		return message;
	}

	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		message.setCreated(new Date());
		messages.put(message.getId(), message);
		return message;
	}

	public Message updateMessage(Message message) {
		if (!messages.containsKey(message.getId())) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}

	public Message removeMessage(Long id) {
		return messages.remove(id);
	}

}
