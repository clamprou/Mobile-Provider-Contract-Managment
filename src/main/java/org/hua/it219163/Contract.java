/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.it219163;

import java.util.Calendar;
import java.util.Date;



/**
 *
 * @author chris
 */
public abstract class Contract{
    
    private static long numberOfContracts;
    private long tilefono;
    private long monadikosArithmos; 
    private int minutesToAll;
    private String dateOfStart;
    private Date end;
    private Date start;
    private boolean is12months;
    private double costPerMonth;
    private boolean isOnline;
    private boolean payCard;
    private boolean pagio;
    private boolean internet;
    private double sale;
     
    
    
    public Contract(String dateOfStart, boolean is12months, boolean isOnline, boolean payCard, long tilefono,int minutesToAll, boolean internet, double sale, boolean pagio){
        this.pagio = pagio;
        this.internet = internet;
        this.dateOfStart = dateOfStart;
        this.is12months = is12months;
        this.isOnline = isOnline;
        this.payCard = payCard;
        this.tilefono = tilefono;
        this.minutesToAll = minutesToAll;
        this.monadikosArithmos = numberOfContracts;
        numberOfContracts++;
        ///////////////////////////////////////////////expire date
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, Integer.parseInt(dateOfStart.substring(3,5))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateOfStart.substring(0,2)));
        if(is12months){
            cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10))+1);
        }else{
            cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10))+2);
        }
        this.end = cal.getTime();
        //////////////////////////////////////////////start date
        cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.MONTH, Integer.parseInt(dateOfStart.substring(3,5))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateOfStart.substring(0,2)));
        cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10)));
        this.start = cal.getTime();
        this.sale = sale;
        this.costPerMonth = 30 -(30*sale);//30 kostizei ka8e simvoleo
    }    

    
    
    

    
    public boolean isActive(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        Date now = cal.getTime();
        return this.getEnd().after(now) && this.getStart().before(now);
    }
    

    //GETERS
  

    public boolean isPagio() {
        return pagio;
    }

    public double getSale() {
        return sale;
    }

    
    public boolean isInternet() {
        return internet;
    }

    
    public Date getEnd() {
        return end;
    }
    
    public Date getStart() {
        return start;
    }
    
    public long getMonadikosArithmosContract(){
        return monadikosArithmos;
    }

    public long getTilefono() {
        return tilefono;
    } 

    public int getNumberOfMinutesToAll() {
        return minutesToAll;
    }

    public String getDateOfStart() {
        return dateOfStart;
    }

    public boolean is12months() {
        return is12months;
    }

    public double getCostPerMonth() {
        return costPerMonth;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public boolean isPayCard() {
        return payCard;
    }
    
}
