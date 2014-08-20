/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.messages;

import com.mayhem.dbprog.messages.concrete.Message;




/**
 * Interface that must implement the classes that acts in response to a
 * Message.
 * @author Carlos
 */
public interface MessageListener {

    /**
     * Action when a message is received.
     * @param message
     */
    public void messageReceived(Message message);
}
