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
public class Kiniti extends Contract{
    private double gb;
    private int sms;
            
    public Kiniti(String dateOfStart, boolean is12months, boolean isOnline, boolean payCard, long tilefono, double gb, int sms, int minutesToAll, boolean internet, double sale, boolean pagio){
        super(dateOfStart,is12months,isOnline,payCard,tilefono,minutesToAll,internet,sale,pagio);
        this.gb = gb;
        this.sms = sms;
    }

    public double getGb() {
        return gb;
    }

    public int getSms() {
        return sms;
    }
    
    
}
