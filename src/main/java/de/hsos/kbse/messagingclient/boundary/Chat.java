/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.boundary;

import java.io.Serializable;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.jms.Message;

/**
 *
 * @author davidherzog
 */
/*@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})*/ //Als MDB funktioniert es nicht mehr als Boundary für JSF Views
@SessionScoped
@Named
public class Chat implements Serializable{
    
    private String userName;
    private String theMessage;

    public Chat() {
        
    }
    
    public void onMessage(Message inMsg) {
        
    }
    
    public void sendMessage() {
        
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTheMessage() {
        return theMessage;
    }

    public void setTheMessage(String theMessage) {
        System.out.println("aufgerufen!");
        this.theMessage = theMessage;
    }
    
}
