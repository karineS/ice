package TP1;

import java.util.concurrent.ConcurrentHashMap;

import Ice.Current;
import Ice.LongHolder;
import Ice.StringHolder;

public class ForumI extends _ForumDisp {
	private String theme;
	private String moderator;
	private ConcurrentHashMap<String,Message> messages;
	ForumI(String theme, String moderator) {
		this.moderator =moderator;
		this.theme=theme;
		messages=new ConcurrentHashMap<String,Message>();
			}
	public String getTheme(Current __current) {
		return theme;
	}

	public String getModerator(Current __current) {
		return moderator;
	}


	public Message[] getMessages(Current __current) {
		return messages.values().toArray(new Message[messages.size()]);
	}

	public void postMessage(Message m, Current __current) throws Reject {
		if(messages.putIfAbsent(m.title, m)!=null)
			throw new Reject("PostMessage :"+
					m.title + " already exists!");
		
	}

	public Message getMessage(String title, Current __current) throws Reject {
		Message m=messages.get(title);
		if(m==null)throw new Reject("GetMessage :"+
				m.title + " doesn't exist!");
		return m;
	}

	public void removeMessage(String title, Current __current) throws Reject {
		if(messages.remove(title)!=null)
			throw new Reject("RemoveMessage :"+
					title + " doesn't exist!");
		
	}

	public void getInfo(StringHolder theme, StringHolder moderator,
			LongHolder size, Current __current) {
		theme.value=this.theme;
		moderator.value=this.moderator;
		size.value=messages.size();	
		
	}
	

}
