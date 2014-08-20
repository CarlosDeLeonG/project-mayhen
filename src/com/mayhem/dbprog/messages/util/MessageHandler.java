/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.messages.util;



import com.mayhem.dbprog.messages.MessageListener;
import com.mayhem.dbprog.messages.concrete.Message;
import java.util.ArrayList;
import java.util.List;

/**
 * This class performes operations on behalf of The MessageProducer objects
 * like: register the Listeners and  send Messages to all the Listeners already
 * in the list.
 * @author Carlos
 */
public class MessageHandler {
    
    private Message message;
    private List<MessageListener> listeners;
    
    /**
     * Constructor for the MessageHandler which performes operations
     * on behalf of the MessageListener.
     */
    public MessageHandler() {
        listeners = new ArrayList<>();
    }
    
    /**
     * Adds a Listener.
     * @param listener
     */
    public void addListener(MessageListener listener) {
        listeners.add(listener);
    }
    
    /**
     * Removes a Listener.
     * @param listener
     */
    public void removeListener(MessageListener listener) {
        listeners.remove(listener);
    }
    
    /**
     * Sends a Message to Listeners registered.
     * @param message
     */
    public void sendMessage(Message message) {
        this.message = message;
        notifyListeners();
    }
    
    private void notifyListeners() {
        for(MessageListener listener : listeners)
            listener.messageReceived(message);
    }
}
