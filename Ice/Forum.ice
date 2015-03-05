
module TP1 {
	struct Message {
	string title;
	string author;
	string date;
	string body;
	};
	sequence<Message> MessageSet;
	exception Reject {string message;};
	interface Forum {
	string getTheme();
	string getModerator();
	void postMessage(Message m) throws Reject;
	Message getMessage(  string title ) throws Reject;
	void removeMessage( string title ) throws Reject;
	MessageSet getMessages();
	void getInfo ( out string theme , out string moderator ,
out long size );
	
	};
};
