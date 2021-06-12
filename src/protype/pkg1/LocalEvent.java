/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package protype.pkg1;

/**
 *
 * @author s1083729
 */
import java.time.LocalDate;

public class LocalEvent {
    private String description;
    private String descriptionAddChoice;
    private LocalDate date;

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }
    
    public String descriptionAddChoice() {
        return descriptionAddChoice;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }
    
    public void setdescriptionAddChoice(String description) {
        this.descriptionAddChoice = descriptionAddChoice;
    }

    /**
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public LocalEvent(LocalDate date,String description){
        this.setDate(date);
        this.description = description;
    }
    

    @Override
    public String toString() {
        return this.getDate() + ": You pay " + this.getDescription();
    }

}
