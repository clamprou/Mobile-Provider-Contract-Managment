/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.it219163;


/**
 *
 * @author chris
 */
public class Statheri extends Contract{
    private String speed;//an den 8elei internet 8a einai null
    private boolean isAdsl;
    
    public Statheri(String dateOfStart, boolean is12months, boolean isOnline, boolean payCard, long tilefono, boolean isAdsl, int minutesToAll, boolean internet, double sale, boolean pagio){
        super(dateOfStart,is12months,isOnline,payCard,tilefono,minutesToAll,internet,sale,pagio);
        this.isAdsl = isAdsl;
        if(isAdsl)
            this.speed = "25mbps";
        else
            this.speed = "50mbps";
    }

    public String getSpeed() {
        return speed;
    }

    public boolean isIsAdsl() {
        return isAdsl;
    }
    
    
    
}
