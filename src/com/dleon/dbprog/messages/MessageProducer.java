/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dleon.dbprog.messages;

import com.dleon.dbprog.messages.concrete.Message;


/**
 * All classes that can be traced in results and performance should implement
 * this interface in order to cast Messages to the Listeners registered in its list;
 * a MessageHandler which performes this tasks is provided in the package.
 * @author Carlos
 */
public interface MessageProducer {

    /**
     * Adds a Listener for the message produced.
     * @param listener
     */
    public void addListener(MessageListener listener);

    /**
     * Removes a Listener for the message produced.
     * @param listener
     */
    public void removeListener(MessageListener listener);

    /**
     * Sends a message for the Listeners registered.
     * @param message
     */
    public void sendMessage(Message message);
}
