package TP1;

public class Client {
	public static void main(String[] args) {
		int status = 0;
        Ice.Communicator ic = null;
        try {
            ic = Ice.Util.initialize(args);
            Ice.ObjectPrx base = ic.stringToProxy("Forum:default -p 10002");
            ForumPrx forum = ForumPrxHelper.checkedCast(base);
            if (forum == null)
                throw new Error("Invalid proxy");
            Message m = new Message("CORBA","moi","10/01/2008","ça marche!");
			Message m2 = new Message("mes2","moi","10/01/2009","ok!");
			forum.postMessage(m);
			forum.postMessage(m2);
			Message tmp = forum.getMessage("CORBA");
			if(tmp!=null){
				System.out.println("Titre : " + tmp.title);
				System.out.println("Auteur : " + tmp.author);
				System.out.println("Message : " + tmp.body);
			}
			System.out.println("--------------------------");
			Message[] ms=forum.getMessages();
			for(Message m3: ms){
				System.out.println();
				System.out.println("Titre : " + m3.title);
				System.out.println("Auteur : " + m3.author);
				System.out.println("Message : " + m3.body);
			}
			System.out.println("--------------------------");

            
        } catch (Ice.LocalException e) {
            e.printStackTrace();
            status = 1;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            status = 1;
        }
        if (ic != null) {
            // Clean up
            //
            try {
                ic.destroy();
            } catch (Exception e) {
                System.err.println(e.getMessage());
                status = 1;
            }
        }
        System.exit(status);
	}

}
