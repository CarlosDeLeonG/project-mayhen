/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mayhem.dbprog.app.data.dao.jpa;


import com.mayhem.dbprog.messages.util.MessageHandler;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Carlos
 */
public abstract class DaoJPA {
    
    /**
     * 
     */
    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("projectPU");

    /**
     * Object required for handling entities.
     */
    protected static EntityManager em = emf.createEntityManager();
    
    /**
     * Message Dispatcher to the Listeners.
     */
    protected MessageHandler handler = new MessageHandler();

    /**
     *
     */
    public DaoJPA() { 
        em = emf.createEntityManager();
       
    }
    
    @Override
    public void finalize() throws Throwable {
        try {
            em.flush();
            em.close();
        } finally {
            super.finalize();
        }
         
    }
    
    /**
     * Begin a Transaction.
     */
    protected void begin(){
        em.getTransaction().begin();
    }
    
    /**
     * Performs a commit to de DB
     */
    protected void commit() {
        em.getTransaction().commit();
    }
    
    /**
     * Cancel any changes to the DB.
     */
    protected void rollback() {
        em.getTransaction().rollback();
    }
    
}
