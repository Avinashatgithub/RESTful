package edu.aarav.jersey.messanger.db;

import java.util.HashMap;
import java.util.Map;

import edu.aarav.jersey.messanger.domain.Message;
import edu.aarav.jersey.messanger.domain.Profile;

public class MyDataBase {
	
	// this map represent mapping of a message with the message id
	private static Map<Long, Message> messages = new HashMap<>();
	
	// this map represent mapping of a profile with profileName
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	public static Map<String, Profile> getProfiles() {
		return profiles;
	}
}