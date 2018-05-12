package br.com.wcf.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class UsersSession {

	private static Map<String, String> sessions = new HashMap<>();

	public void set(String key, String value) {
		sessions.put(key, value);
	}

	public String get(String key) {
		return sessions.get(key);
	}

	public Map<String, String> getAll() {
		return sessions;
	}
}
