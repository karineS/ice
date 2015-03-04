
module TP1 {
	struct Message {
	string title;
	string author;
	string date;
	string body;
	};
	
	interface Forum {
	string getTheme();
	string getModerator();
	bool postMessage(Message m);
	Message getMessage(  string title );
	bool removeMessage( string title );
	};
};
