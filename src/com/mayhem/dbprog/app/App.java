/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app;

import com.mayhem.dbprog.messages.MessageListener;
import com.mayhem.dbprog.messages.MessageProducer;
import com.mayhem.dbprog.messages.concrete.Message;
import com.mayhem.dbprog.messages.concrete.MessageType;
import com.mayhem.dbprog.messages.util.MessageHandler;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author Carlos
 */
public class App implements MessageProducer {
    private MessageHandler handler;
    private MessageTestListener receiver;
    private MessageStreamListener streamReceiver;
    private File file;
    
    public App(String path) throws FileNotFoundException {
        handler = new MessageHandler();
        receiver = new MessageTestListener();
        file = new File(path);
        streamReceiver = new MessageStreamListener(new PrintStream(file));
        
        
        this.addListener(receiver);
        this.addListener(streamReceiver);
        
        throwMessage("Hello World!");
        

    }
    
    public static void main(String[] args) {
        try {
            new App(args[0]);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    private void throwMessage(String messageTxt) {
        this.sendMessage(new Message(MessageType.TEST, messageTxt));
    }
    
    @Override
    public void addListener(MessageListener listener) {
        handler.addListener(listener);
    }

    @Override
    public void removeListener(MessageListener listener) {
        handler.removeListener(listener);
    }

    @Override
    public void sendMessage(Message message) {
        handler.sendMessage(message);
    } 
    
}

class MessageTestListener implements MessageListener {

    @Override
    public void messageReceived(Message message) {
        String textMessage = (String) message.getBody();
        System.out.println("Message: " + textMessage);
    }
    
}

class MessageStreamListener implements MessageListener {

    private PrintStream stream;

    public MessageStreamListener(PrintStream stream) {
        this.stream = stream;
    }
    
    @Override
    public void messageReceived(Message message) {
        String textMessage = (String) message.getBody();
        stream.println("Message: " + textMessage);
    }
}
