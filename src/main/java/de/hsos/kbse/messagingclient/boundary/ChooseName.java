/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.hsos.kbse.messagingclient.boundary;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author davidherzog
 */
@SessionScoped
@Named
public class ChooseName implements Serializable {
    
    private String inputName;

    public String getInputName() {
        return inputName;
    }

    public void setInputName(String inputName) {
        this.inputName = inputName;
    }
    
    public String navigateToChat() {
        return "/Chat.xhtml?faces-redirect=false";
    }
    
}
