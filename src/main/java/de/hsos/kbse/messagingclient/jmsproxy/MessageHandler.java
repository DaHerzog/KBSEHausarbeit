/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.jmsproxy;

import de.hsos.kbse.messagingclient.boundary.Chat;
import de.hsos.kbse.messagingclient.observer.BoundaryObserver;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

/**
 *
 * @author davidherzog
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/myTopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
@ApplicationScoped
public class MessageHandler {
    
    @Inject
    BoundaryObserver myObserver;
    
    public MessageHandler() {
        
    }
    
    public void onMessage(Message inMsg) {
        
        if (inMsg instanceof TextMessage) {
            try {
                TextMessage txtMsg = (TextMessage)inMsg;
                myObserver.sendToAllBoundaries(txtMsg.getText());
            } catch (JMSException ex) {
                Logger.getLogger(MessageHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
