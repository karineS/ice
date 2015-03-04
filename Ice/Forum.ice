struct Message {
string title;
string author ;
string date;
string body;
};

interface Forum{
string theme;
string moderator;
boolean postMessage( Message m );
Message getMessage(  string title );
boolean removeMessage( string title );

};
