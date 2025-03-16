package edu.wgu.d387_sample_code;

import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessagesThreading extends Thread {

    private Locale locale;
    private List<String> messages;


    public MessagesThreading(Locale locale, List<String> messages) {
        this.locale = locale;
        this.messages = messages;
    }

    @Override
    public void run(){
        try {
		ResourceBundle bundle = ResourceBundle.getBundle("Messages", locale);
		String welcomeMessage = bundle.getString("message");
        synchronized (messages) {
            messages.add(welcomeMessage);
        }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
