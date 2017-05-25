package edu.aarav.jersey.messanger.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.aarav.jersey.messanger.domain.Profile;

public class ProfileService {
	private Map<String, Profile> profiles;

	public ProfileService() {
		// Initialize map of profile as Profile service started
		profiles = new HashMap<>();
		// Create some profiles
		Profile p1 = new Profile(1L, "avi.k2avi", "Avinash", "Kumar", new Date());
		Profile p2 = new Profile(2L, "aarav.avi", "Aarav", "Avi", new Date());
		Profile p3 = new Profile(3L, "admin", "Avi", "kr", new Date());
		// add all created profiles into the profile map
		profiles.put(p1.getProfileName(), p1);
		profiles.put(p2.getProfileName(), p2);
		profiles.put(p3.getProfileName(), p3);
	}

	/*
	 * Get all the profiles stored in map
	 */
	public List<Profile> getAllProfiles() {
		return new ArrayList<>(profiles.values());
	}

	/*
	 * Get a particular Profile matching profileName from map
	 */
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	/*
	 * Add a new profile to map
	 */
	public Profile addProfile(Profile profile) {
		if (profile == null)
			throw new IllegalArgumentException("Request cannot be processed.");
		// set profile id for new profile and store it to map
		profile.setId(profiles.size() + 1L);
		profile.setCreated(new Date());
		profiles.put(profile.getProfileName(), profile);
		return profiles.get(profile.getProfileName());
	}

	/*
	 * Add an existing profile
	 */
	public Profile updateProfile(Profile profile) throws IllegalAccessException {
		// if profileName is null or empty return null
		if (profile.getProfileName() == null || profile.getProfileName().isEmpty()) {
			return null;
		}
		// if no record is available with requested profileName throw an
		// exception
		if (!profiles.containsKey(profile.getProfileName())) {
			throw new IllegalAccessException("No record found for this profile");
		} else {
			profiles.put(profile.getProfileName(), profile);
		}
		return profiles.get(profile.getProfileName());
	}

	/*
	 * remove a particular profile from the map associated with this
	 * profileName. return previous Profile associated with this key otherwise
	 * null if no profile associated.
	 */
	public Profile deleteProfile(String profileName) {
		return profiles.remove(profileName);
	}
}