/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.dtos;

import java.util.Date;
import javax.enterprise.inject.Vetoed;

/**
 *
 * @author davidherzog
 */
@Vetoed
public class MyMessage {
    
    private Date dateSent;
    private String message;
    private String author;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }
   
    
}
