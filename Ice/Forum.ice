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
