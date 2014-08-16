/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dleon.dbprog.messages.concrete;

/**
 * Message used in order to comunicate issues and results,
 * the MessageType is a sort of stamp to specify the kind of the Message,
 * the body which is an Object generally is an Object[] object, a cast must be performed
 * over this. 
 * @author Carlos
 */
public class Message {
    private MessageType type;
    private Object body;

    /**
     * Constructor that sets the type and content of the Message.
     * @param type
     * @param body
     */
    public Message(MessageType type, Object body) {
        this.type = type;
        this.body = body;
    }

    /**
     * Getter for the type of the Message consult MessageType Enum.
     * @return the type of Message.
     */
    public MessageType getType() {
        return type;
    }

    /**
     * Getter for the content of the Message, generally this content comes
     * in the form of an array of Object (Object[]) so a cast must be performed.
     * @return the content of the Message.
     */
    public Object getBody() {
        return body;
    }
    
    
}
