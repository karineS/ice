package TP1;

import java.util.concurrent.ConcurrentHashMap;

import Ice.Current;

public class ForumI extends _ForumDisp {
	private String theme;
	private String moderator;
	private ConcurrentHashMap<String,Message> messages=new ConcurrentHashMap<String,Message>();

	public String getTheme(Current __current) {
		return theme;
	}

	public String getModerator(Current __current) {
		return moderator;
	}

	public boolean postMessage(Message m, Current __current) {
		return messages.putIfAbsent(m.title, m)!=null;
	}

	public Message getMessage(String title, Current __current) {
		return messages.get(title);
	}

	public boolean removeMessage(String title, Current __current) {
		return messages.remove(title)!=null;
	}
	

}
