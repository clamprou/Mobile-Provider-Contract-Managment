/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.hua.it219163;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class User {
    static ArrayList<User> arrayU = new ArrayList<>();//apo8ikevw olous tous Users edw gia afto einai static
    private ArrayList<Contract> arrayC = new ArrayList<>();//apo8ikevw gia ka8e User enan pinaka gia ta energa simvolea
    private String afm;            
    private String adress;
    private String at;
    private boolean idiotis;
    private boolean foititis;
    private boolean epagelmatias;
    private String email;
    private double ekptwsh;
    private int monadikosArithmos;

    public User(String afm, String adress, String at, boolean idiotis, boolean foititis, boolean epagelmatias, String email) {
        this.afm = afm;
        this.adress = adress;
        this.at = at;
        this.idiotis = idiotis;
        this.foititis = foititis;
        this.epagelmatias = epagelmatias;
        this.email = email;
        this.ekptwsh = 0;
        
        //afou ton eftiakses apo8ikefseton ston pinaka
        
        arrayU.add(this);
       
        
    }
    
    public User(){
       
    }
    
    public static void example(){
        User x = new User("123456789", "Anaksagora", "AM15343", false, true, false, "it219163@hua.gr");
        Kiniti k = new Kiniti("22/01/2021", true, false, true,Long.parseLong("6912432365") , 1.5, 100, 1012, true, x.getEkptwsh(), false);
        x.arrayC.add(k);
        x.updateEkptwsh();
        Statheri s = new Statheri("01/05/2024", false, true, true, Long.parseLong("2900432341"), true, 1234, true, x.getEkptwsh(), false);
        x.arrayC.add(s);
        x.updateEkptwsh();
        k = new Kiniti("24/02/2021", false, false, false, Long.parseLong("6900432341"), 3.3, 254, 112, false, x.getEkptwsh(), true);
        x.arrayC.add(k);
        x.updateEkptwsh();
        k = new Kiniti("01/05/2030", false, false, false, Long.parseLong("6900432341"), 3.3, 254, 112, false, x.getEkptwsh(), true);
        x.arrayC.add(k);
        x.updateEkptwsh();
        k = new Kiniti("01/06/2032", false, false, false, Long.parseLong("6900432341"), 3.3, 254, 112, false, x.getEkptwsh(), true);
        x.arrayC.add(k);
        x.updateEkptwsh();
        x = new User("648324089", "Xiou", "AK673412", true, false, false, "asdgfds@hua.gr");
        k = new Kiniti("01/06/2050", false, false, false, Long.parseLong("6900432341"), 3.3, 254, 112, false, x.getEkptwsh(), true);
        x.arrayC.add(k);
        x.updateEkptwsh();
        s = new Statheri("01/05/2024", false, true, true, Long.parseLong("2904132341"), true, 1234, true, x.getEkptwsh(), false);
        x.arrayC.add(s);
        x.updateEkptwsh();
        x = new User("580093416", "Dervenakion", "XZ326545", false, false, true, "eeeasASDwedww@hua.gr");
    }
    
    public static User createUser(){
        String afm;
        String adress,at,email;
        boolean idiotis,fititis,epagelmatias,isNotNumber = false;
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Dose afm");
        afm = scan.next();
        try{
            int c = Integer.parseInt(afm);
        }catch(NumberFormatException e){
            isNotNumber = true;
        }
        while(findUserAfm(afm) != null || afm.length()!= 9 || isNotNumber){//elenxoume thn egirotita tou afm
            if(afm.length() != 9 || isNotNumber){
                System.out.println("To afm prepei na exei 9 psifia");
            }else{
                System.out.println("uparxei idi user me afto to afm");
            }
            System.out.println("ksanadose");
            afm = scan.next();
            isNotNumber = false;
            try{
                int c = Integer.parseInt(afm);
            }catch(NumberFormatException e){
                isNotNumber = true;
            }
            
        }
        
        System.out.println("Dose dief8insh");
        adress = scan.next();
        System.out.println("Dose ari8mo taftotitas");
        at = scan.next();
        ////////////////////////////////////////////////elenxos egirotitas tou ari8mou taftotitas apo EDO
        while(at.length() < 3){
            System.out.println("la8os sidaxi grapse gia paradigma AN534312");
            System.out.println("ksanadose");
            at = scan.next();
        }//EINAI LA8OS
        boolean tmp1 = (findUserAt(at) != null);//true an uparxei false an den uparxei
        boolean tmp2 = !(Character.isLetter(at.charAt(0)));//true an den einai grama
        isNotNumber = false;
        try{
            int b = Integer.parseInt(at.substring(2));
        }catch(Exception e){
            isNotNumber = true;
        }
        
        while(tmp1 || tmp2 || isNotNumber){
            if(tmp1){
                System.out.println("uparxei idi user me afto ton ari8mo taftotitas");
            }
            if(tmp2 || isNotNumber){
                System.out.println("la8os sidaxi grapse gia paradigma AN534312");
            }
            
            System.out.println("ksanadose");
            at = scan.next();
            isNotNumber = false;
            try{
                int b = Integer.parseInt(at.substring(2));
            }catch(Exception e){
                isNotNumber = true;
            }
            tmp1 = (findUserAt(at) != null);
            tmp2 = !(Character.isLetter(at.charAt(0)));
        }
        //////////////////////////////////////////////////////mexri EDO
        System.out.println("Dose email");
        email = scan.next();
        System.out.println("Eisai idiotis?(true gia nai false gia oxi)");
        idiotis = scan.nextBoolean();
        System.out.println("Eisai fititis?(true gia nai false gia oxi)");
        fititis = scan.nextBoolean();
        System.out.println("Eisai epagelmatias?(true gia nai false gia oxi)");
        epagelmatias = scan.nextBoolean();
        
        User user = new User(afm, adress, at, idiotis, fititis, epagelmatias, email);
        return user;
    }
    
    
    
    //me at
    public static User findUserAt(String at){
        for(int i=0;i<arrayU.size();i++){
            if(arrayU.get(i).at.equals(at)){
                return arrayU.get(i);
            }
        }
        return null;
    }
    
    //me afm
    public static User findUserAfm(String afm){
        for(int i=0;i<arrayU.size();i++){
            if(arrayU.get(i).afm.equals(afm)){
                return arrayU.get(i);
            }
        }
        return null;
    }
    
    public static boolean overlay(long tilefono,String dateOfStart,boolean is12months){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10)));
        cal.set(Calendar.MONTH, Integer.parseInt(dateOfStart.substring(3,5))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateOfStart.substring(0,2)));
        Date start = cal.getTime();
        if(is12months){
            cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10))+1);
        }else{
            cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10))+2);
        }
        Date end = cal.getTime();
        
        for(int i=0;i<arrayU.size();i++){
            for(int x=0;x<arrayU.get(i).arrayC.size();x++){
                if((arrayU.get(i).arrayC.get(x).getTilefono() == tilefono) && (end.compareTo(arrayU.get(i).arrayC.get(x).getStart()) >=0 && start.compareTo(arrayU.get(i).arrayC.get(x).getEnd()) <= 0 )){
                    return true;
                }
            }
        }
       return false;
    }    
    //epistrefei null an den to vriskei h einai adios o pinakas alliws to contract pou vrike
    public static Contract findActiveContractFromAll(long tilefono){
        for(int i=0;i<arrayU.size();i++){
            for(int x=0;x<arrayU.get(i).arrayC.size();x++){
                if(arrayU.get(i).arrayC.get(x).getTilefono() == tilefono && arrayU.get(i).arrayC.get(x).isActive()){
                    return arrayU.get(i).arrayC.get(x);
                }
            }
        }
        return null;
    }
    
    public boolean hasContracts(){
        return !this.arrayC.isEmpty();
    }
    
    public void printContracts(){
        if(!this.hasContracts()){
            System.out.println("den exeis simvolea");
            return;
        }
        for(int i=0;i<this.arrayC.size();i++){
            System.out.println("````````````````````````");
            if(arrayC.get(i) instanceof Statheri)
                    System.out.println("Tupos simvoleou: stathero");
                else
                    System.out.println("Tupos simvoleou: kinito"); 
                System.out.println("Tilefono simvoleou: "+arrayC.get(i).getTilefono());
                System.out.println("Monadikos ari8mos simvoleou: "+arrayC.get(i).getMonadikosArithmosContract());
                System.out.println("Imerominia enarksis simvoleou: "+arrayC.get(i).getDateOfStart());
                System.out.println("Dorean lepta pros oloys simvoleou: "+arrayC.get(i).getNumberOfMinutesToAll());
                if(arrayC.get(i).is12months()){
                    System.out.println("Diarkia simvoleou: 1 xrono");
                }else{
                    System.out.println("Diarkia simvoleou: 2 xronia");
                }
                if(arrayC.get(i).isOnline()){
                    System.out.println("Logarismos simvoleou: ilektronikos");
                }else{
                    System.out.println("Logarismos simvoleou: mi ilektronikos");
                }
                if(arrayC.get(i).isPayCard()){
                    System.out.println("Tropos pliromis simvoleou: mi ilektronikos");
                }
                System.out.println("Kostos ana mina simvoleou: "+arrayC.get(i).getCostPerMonth()+'$');
                System.out.println("Ekptwsh simvoleou: "+arrayC.get(i).getSale()+'%');
                if(arrayC.get(i) instanceof Statheri){
                    if(arrayC.get(i).isInternet()){
                        if(((Statheri)arrayC.get(i)).isIsAdsl())
                            System.out.println("Tupos internet simvoleou: ADSL");
                        else
                            System.out.println("Tupos internet simvoleou: VDSL");
                    }
                }else{
                    if(arrayC.get(i).isInternet())
                        System.out.println("Dorean GB simvoleou: "+((Kiniti)arrayC.get(i)).getGb());
                    System.out.println("Dorean SMS simvoleou: "+((Kiniti)arrayC.get(i)).getSms());    
                }
        }
    }
    
    public void printActiveContracts(){
        this.updateEkptwsh();
        if(!this.hasActiveContracts()){
            System.out.println("den exeis energa Contracts");
            return;
        }
        
        for(int i=0;i<arrayC.size();i++){
            if(arrayC.get(i).isActive()){
                System.out.println("````````````````````````");
                if(arrayC.get(i) instanceof Statheri)
                    System.out.println("Tupos simvoleou: stathero");
                else
                    System.out.println("Tupos simvoleou: kinito");
                    
                System.out.println("Tilefono simvoleou: "+arrayC.get(i).getTilefono());
                System.out.println("Monadikos ari8mos simvoleou: "+arrayC.get(i).getMonadikosArithmosContract());
                System.out.println("Imerominia enarksis simvoleou: "+arrayC.get(i).getDateOfStart());
                System.out.println("Dorean lepta pros oloys simvoleou: "+arrayC.get(i).getNumberOfMinutesToAll());
                if(arrayC.get(i).is12months()){
                    System.out.println("Diarkia simvoleou: 1 xrono");
                }else{
                    System.out.println("Diarkia simvoleou: 2 xronia");
                }
                if(arrayC.get(i).isOnline()){
                    System.out.println("Logarismos simvoleou: ilektronikos");
                }else{
                    System.out.println("Logarismos simvoleou: mi ilektronikos");
                }
                if(arrayC.get(i).isPayCard()){
                    System.out.println("Tropos pliromis simvoleou: mi ilektronikos");
                }
                System.out.println("Kostos ana mina simvoleou: "+arrayC.get(i).getCostPerMonth()+'$');
                System.out.println("Ekptwsh simvoleou: "+arrayC.get(i).getSale()+'%');
                if(arrayC.get(i) instanceof Statheri){
                    if(arrayC.get(i).isInternet()){
                        if(((Statheri)arrayC.get(i)).isIsAdsl())
                            System.out.println("Tupos internet simvoleou: ADSL");
                        else
                            System.out.println("Tupos internet simvoleou: VDSL");
                    }
                }else{
                    if(arrayC.get(i).isInternet())
                        System.out.println("Dorean GB simvoleou: "+((Kiniti)arrayC.get(i)).getGb());
                    System.out.println("Dorean SMS simvoleou: "+((Kiniti)arrayC.get(i)).getSms());    
                }
            }
        }
    }
    
    public boolean hasActiveContracts(){
        if(arrayC.isEmpty()){
            return false;
        }
        for(int i=0;i<arrayC.size();i++){
            if(arrayC.get(i).isActive()){
                return true;
            }
        }
        return false;
    }
    
    public Contract findActiveContract(long tilefono){
        for(int i=0;i<arrayC.size();i++){
            if(arrayC.get(i).getTilefono() == tilefono && arrayC.get(i).isActive()){
                return arrayC.get(i);
            }
        }
        return null;
    }
    
    public Contract findContract(long monadikosArithmos){
        for(int i=0;i<arrayC.size();i++){
            if(arrayC.get(i).getMonadikosArithmosContract() == monadikosArithmos){
                return arrayC.get(i);
            }
        }
        return null;
    }
    
    public Contract deleteContract(long monadikosArithmos){
        Contract tmp = this.findContract(monadikosArithmos);
        if(tmp == null)
            return null;
        
        arrayC.remove(tmp);
        this.updateEkptwsh();
        return tmp;
    }
    
    public Contract deleteActiveContract(long tilefono){
        Contract tmp = this.findActiveContract(tilefono);
        if(tmp == null){
            return null;
        }
        //uparxei ara to diagrafoume
        arrayC.remove(tmp);
        this.updateEkptwsh();
        return tmp;
    }
    
    private void updateEkptwsh(){
        double sale,contracts=0.15,epagelmatias=0,fititis=0,statheri=0,kiniti=0,card=0,online=0,active=0;
        for(int x=0;x<this.arrayC.size();x++){
            if(this.arrayC.get(x).isActive()){
                active++;
            }
        }
        if(active <= 3){
            contracts = active*0.15;
        }
            
        if(this.hasActiveContracts()){
            if(this.isEpagelmatias())
                epagelmatias = 0.1;
            if(this.isFoititis())
                fititis = 0.15;
            for(int i=0;i<this.arrayC.size();i++){
                if(this.arrayC.get(i).isActive()){
                    if(this.arrayC.get(i).getNumberOfMinutesToAll() > 1000){
                        if(this.arrayC.get(i) instanceof Statheri)
                            statheri = 0.08;
                        else
                            kiniti = 0.11;
                    }
                    if(this.arrayC.get(i).isPayCard() || this.arrayC.get(i).isPagio())
                        card = 0.05;
                    if(this.arrayC.get(i).isOnline())
                        online = 0.02;
                }    
            }
        }
        sale = contracts+epagelmatias+fititis+statheri+kiniti+card+online;
        if(sale>0.45)
            this.ekptwsh = 0.45;
        else
            this.ekptwsh = sale;
    }
    
    public Contract createContract(){
        Contract c;
        int sms,minutesToAll,dayNow,monthNow,yearNow,d,m,y;
        double gb=0;
        String dateOfStart;
        boolean is12months,isOnline,payCard=false,isAdsl=false,isStatheri,isNotNumber,isNotValid,overlay,internet,pagio;
        long tilefono;
        Scanner scan = new Scanner(System.in);
        Date now,wanted = new Date();
        
        System.out.println("8es statheris h kinitis tilefonias simvoleo?(true gia statheri kai false gia kiniti)");
        isStatheri = scan.nextBoolean();
        System.out.println("8es internet?(true gia nai false gia oxi)");
        internet = scan.nextBoolean();
        System.out.println("Dose tin imerominia enarksis");
        dateOfStart = scan.next();
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        cal.set(Calendar.MILLISECOND, 0);
        try{
        cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10)));
        cal.set(Calendar.MONTH, Integer.parseInt(dateOfStart.substring(3,5))-1);
        cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateOfStart.substring(0,2)));
        wanted = cal.getTime();
        now = new Date();
        if(wanted.after(now)){
            isNotValid = false;
        }else{
            isNotValid = true;
        }
        }catch(Exception e){
            isNotValid = true;
        }
        try{
            if(Integer.parseInt(dateOfStart.substring(0,2)) >0 && Integer.parseInt(dateOfStart.substring(0,2)) < 32 && Integer.parseInt(dateOfStart.substring(3,5)) > 0 && Integer.parseInt(dateOfStart.substring(3,5)) < 13 && Integer.parseInt(dateOfStart.substring(6,10)) > 0){
                isNotNumber = false;
            }else{
                isNotNumber = true;
            }
            
        }catch(Exception e){
            isNotNumber = true;
        }
        
        while(dateOfStart.length() != 10 || dateOfStart.charAt(2) != '/' || dateOfStart.charAt(5) != '/' || isNotNumber || isNotValid){
            System.out.println("Mi egiri imerominia(--/--/----)");
            System.out.println("ksanadose");
            dateOfStart = scan.next();
            try{
                cal.set(Calendar.YEAR, Integer.parseInt(dateOfStart.substring(6,10)));
                cal.set(Calendar.MONTH, Integer.parseInt(dateOfStart.substring(3,5))-1);
                cal.set(Calendar.DAY_OF_MONTH, Integer.parseInt(dateOfStart.substring(0,2)));
                wanted = cal.getTime();
                now = new Date();
                if(wanted.after(now)){
                    isNotValid = false;
                }else{
                    isNotValid = true;
                }
            }catch(Exception e){
                isNotValid = true;
            }
            try{
                if(Integer.parseInt(dateOfStart.substring(0,2)) > 0 && Integer.parseInt(dateOfStart.substring(0,2)) < 32 && Integer.parseInt(dateOfStart.substring(3,5)) > 0 && Integer.parseInt(dateOfStart.substring(3,5)) < 13 && Integer.parseInt(dateOfStart.substring(6,10)) > 0){
                    isNotNumber = false;
                }else{
                    isNotNumber = true;
                }
            }catch(Exception e){
                isNotNumber = true;
            }
        }
        System.out.println("8a einai 12 h 24 mhnes?(true gia 12 kai false gia 24)");
        is12months = scan.nextBoolean();//idios
        System.out.println("8a einai ilektronikos o logariasmos tou simvoleou?(true gia nai false gia oxi)");
        isOnline = scan.nextBoolean();//idios
        System.out.println("8a pliroseis me pagio?(true gia nai false gia oxi)");
        pagio = scan.nextBoolean();
        if(!pagio){
            System.out.println("8a pliroseis me karta h metrita?(true gia karta false gia metrita)");
            payCard = scan.nextBoolean();//idios
        }
        System.out.println("Dose posa dorean lepta pros olous 8es");
        minutesToAll = scan.nextInt();
        System.out.println("Dose to tilefono");
        tilefono = scan.nextLong();
        if(isStatheri){//elenkse gia tilefono
            if(String.valueOf(tilefono).charAt(0) == '2' && String.valueOf(tilefono).length() == 10){
                overlay = User.overlay(tilefono, dateOfStart, is12months);
            }else{
                overlay = true;
            }
            while(!(String.valueOf(tilefono).charAt(0) == '2') || String.valueOf(tilefono).length() != 10 || overlay){
                System.out.println("la8os sidaksh h ginetai epikalipsh imerominion me alo simvoleo");
                System.out.println("Ksanadose");
                tilefono = scan.nextLong();
                if(String.valueOf(tilefono).charAt(0) == '2' && String.valueOf(tilefono).length() == 10){
                    overlay = User.overlay(tilefono, dateOfStart, is12months);
                }else{
                    overlay = true;
                }
            }
            if(internet){
                System.out.println("8a einai ADSL h VDSL?(true gia ADSL false gia VDSL)");
                isAdsl = scan.nextBoolean();
            }
            c = new Statheri(dateOfStart,is12months,isOnline,payCard,tilefono,isAdsl,minutesToAll,internet,this.getEkptwsh(),pagio);
        }else{//elenkse gia kinito
            if(String.valueOf(tilefono).charAt(0) == '6' && String.valueOf(tilefono).length() == 10){
                overlay = User.overlay(tilefono, dateOfStart, is12months);
            }else{
                overlay = true;
            }
            while(!(String.valueOf(tilefono).charAt(0) == '6') || String.valueOf(tilefono).length() != 10 || overlay){
                System.out.println("la8os sidaksh h ginetai epikalipsh imerominion me alo simvoleo");
                System.out.println("Ksanadose");
                tilefono = scan.nextLong();
                if(String.valueOf(tilefono).charAt(0) == '6' && String.valueOf(tilefono).length() == 10){
                    overlay = User.overlay(tilefono, dateOfStart, is12months);
                }else{
                    overlay = true;
                }
            }
            System.out.println("Dose ton ari8mo twn dorean SMS pou 8es");
            sms = scan.nextInt();
            if(internet){
                System.out.println("Dose ton ari8mo twn dorean GB pou 8es(px 1.3)");
                gb = scan.nextDouble();
            }
            c = new Kiniti(dateOfStart,is12months,isOnline,payCard,tilefono,gb,sms,minutesToAll,internet,this.getEkptwsh(),pagio);
        }
        arrayC.add(c);
        this.updateEkptwsh();
        return c;
    }
    
    //GETTERS
    
    
    
    public boolean isFoititis() {
        return foititis;
    }

    public String getAfm() {
        return afm;
    }

    public String getAdress() {
        return adress;
    }

    public String getAt() {
        return at;
    }

    public boolean isIdiotis() {
        return idiotis;
    }

    public boolean isEpagelmatias() {
        return epagelmatias;
    }

    public String getEmail() {
        return email;
    }

    public double getEkptwsh() {
        return ekptwsh;
    }

    public int getMonadikosArithmosUser() {
        return monadikosArithmos;
    }

}
