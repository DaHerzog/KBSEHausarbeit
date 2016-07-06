/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.jmsproxy;

import de.hsos.kbse.messaging.entities.MyMessage;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author davidherzog
 */
@SessionScoped
public class MessagingProxy implements Serializable{
    
    @Resource(lookup = "jms/ConnectionFactory")
    ConnectionFactory myConFactory;
            
    @Resource(lookup = "jms/myQueue")
    Queue myQueue;
    
    private Connection myCon;
    private Session mySession;
    private MessageProducer myProducer;
    
    @PostConstruct
    public void init() {
        try {
            myCon = myConFactory.createConnection();
            mySession = myCon.createSession(false, Session.AUTO_ACKNOWLEDGE);
            myProducer = mySession.createProducer(myQueue);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    @PreDestroy
    public void destroy() {
        try {
            myCon.close();
        } catch (JMSException ex) {
            Logger.getLogger(MessagingProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(MyMessage msg) {
        try {
            ObjectMessage myMsg = mySession.createObjectMessage();
            myMsg.setObject(msg);
            myProducer.send(myMsg);
        } catch (JMSException ex) {
            Logger.getLogger(MessagingProxy.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
