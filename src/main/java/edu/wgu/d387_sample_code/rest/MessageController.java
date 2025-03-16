package edu.wgu.d387_sample_code.rest;

import edu.wgu.d387_sample_code.MessagesThreading;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


@RestController
@CrossOrigin("http://localhost:4200")
public class MessageController {

    @RequestMapping("/message")
    public List<String> welcomeMessage() throws InterruptedException {
        List<String> messages = new ArrayList<>();

        MessagesThreading enThread = new MessagesThreading(Locale.ENGLISH, messages);
        MessagesThreading frThread = new MessagesThreading(Locale.CANADA_FRENCH, messages);

        enThread.start();
        frThread.start();
        enThread.join();
        frThread.join() ;
        return messages;
    }
}
