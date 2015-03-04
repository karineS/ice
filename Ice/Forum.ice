<<<<<<< HEAD
struct Message {
string title;
string author ;
string date;
string body;
};

interface Forum{
string theme;
string moderator;
bool postMessage( Message m );
Message getMessage(  string title );
bool removeMessage( string title );

};
=======
module TP1 {
	struct Message {
	string title;
	string author;
	string date;
	string body;
	};
	
	interface Forum {
	string theme;
	string moderator;
	bool postMessage(Message m);
	Message getMessage(  string title );
	bool removeMessage( string title );
	};
};
>>>>>>> b39089d335e53c6de099533e2dabf4b6f45fed38
