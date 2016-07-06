/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.boundary;

import de.hsos.kbse.messaging.dtos.MyMessageDTO;
import de.hsos.kbse.messagingclient.jmsproxy.MessageHandler;
import de.hsos.kbse.messagingclient.jmsproxy.MessagingProxy;
import de.hsos.kbse.messagingclient.observer.BoundaryObserver;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
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
    
    @Inject
    MessagingProxy msgProxy;
    
    @Inject
    BoundaryObserver myObserver;

    public Chat() {
        
    }
    
    @PostConstruct
    public void init() {
        this.userName = "Testweise";
        this.myObserver.registerChat(this);
    }
    
    @PreDestroy
    public void destroy() {
        this.myObserver.deregisterChat(this);
    }
    
    
    public void sendMessage() {
        MyMessageDTO newMsg = new MyMessageDTO();
        
        newMsg.setMessage(theMessage);
        newMsg.setAuthor(userName);
        
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.LONG);
        Date actualDate = new Date();
        newMsg.setDateSent(df.format(actualDate));
        
        msgProxy.sendMessage(newMsg);
    }
    
    public void displayNewMessage(String msg) {
        System.out.println("in der boundary" + msg);
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
        this.theMessage = theMessage;
    }
    
}
