package hello;

import java.util.concurrent.CountDownLatch;
import org.springframework.stereotype.Component;

import org.springframework.messaging.simp.SimpMessagingTemplate;

import org.springframework.messaging.handler.annotation.SendTo;

@Component
public class Receiver {
    private SimpMessagingTemplate template;

    public Receiver(SimpMessagingTemplate template){
        this.template = template;
    }


    public void receiveMessage(String message) throws Exception{
        Thread.sleep(1000); // simulated delay

        this.template.convertAndSend("/topic/greetings", "{\"content\":\"Simulation de la génération du pdf message :" + message + "\"}");

        System.out.println("Simulation de la génération du pdf <" + message + ">");
    }
}