/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.observer;

import de.hsos.kbse.messagingclient.boundary.Chat;
import java.util.LinkedList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author davidherzog
 */
@ApplicationScoped
public class BoundaryObserver {
    
    List<Chat> registeredBoundaries;
    
    
    public BoundaryObserver() {
        
    }
    
    @PostConstruct
    public void init() {
        this.registeredBoundaries = new LinkedList<Chat>();
    }
    
    public void sendToAllBoundaries(String message) {
        
        for (Chat currChat : this.registeredBoundaries) {
            currChat.displayNewMessage(message);
        }
        
    }
        
    public void registerChat(Chat newChat) {
        this.registeredBoundaries.add(newChat);
    }
    
    public void deregisterChat(Chat oldChat) {
        this.registeredBoundaries.remove(oldChat);
    }
    
}
