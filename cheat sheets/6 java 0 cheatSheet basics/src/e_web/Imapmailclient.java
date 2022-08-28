
package e_web;

import java.io.*;
import java.util.Properties;
import javax.mail.*;

public class Imapmailclient {

    public static void main(String[] args) 
            throws NoSuchProviderException, MessagingException, IOException {
        
        Properties props = new Properties();
        props.setProperty("mail.store.protocol", "imaps");
        Session session = Session.getInstance(props);
        Store store = session.getStore();
        store.connect("imap.gmail.com", "electrohhh@gmail.com", "xyz");
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        int lastmsg = inbox.getMessageCount();
        while(lastmsg>0){
            Message msg = inbox.getMessage(lastmsg--);
            System.out.println("From: " + msg.getFrom()[0]);
            System.out.println("Subject: " + msg.getSubject());
            System.out.println("Body: " + msg.getContent());
        }
    }
}
