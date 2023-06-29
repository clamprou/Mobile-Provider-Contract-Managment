
package org.hua.it219163;




import java.util.InputMismatchException;
import java.util.Scanner;

public class it219163 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int x,y;
        long monadikosArithmos;
        String afm;
        User user;
        User.example();
        do{
            Menu.print();
            x = scan.nextInt();
            
            switch(x){
                case 1 : //εισαγωγη χρηστη
                    User.createUser();
                    break;
                case 2 : //εισαγωγη συμβολαιου
                    System.out.println("Dose to afm sou");
                    afm = scan.next();
                    user = User.findUserAfm(afm);
                    if(user == null){
                        System.out.println("den uparxei profile me afto to afm");
                    }else{
                        user.createContract();
                    }
                    break;
                case 3 : //διαγραφη συμβολαιου
                    System.out.println("Dose to afm sou");
                    afm = scan.next();
                    user = User.findUserAfm(afm);
                    if(user == null){
                        System.out.println("den uparxei profile me afto to afm");
                    }else{
                        if(user.hasContracts()){
                            user.printContracts();
                            System.out.println("Dose ton monadiko arithmo gia to simvoleo pou 8es na diagrapseis");
                            monadikosArithmos = scan.nextLong();
                            if(user.deleteContract(monadikosArithmos) == null){
                                System.out.println("Den exeis simvoleo me afto ton ari8mo");
                            }else{
                                System.out.println("To simvoleo diagraftike");
                            }
                        }else{
                            System.out.println("Den exeis simvolea");
                        }
                    }
                    
                    break;
                case 4 ://ενεργα συμβολαια - στατιστικα
                   System.out.println("Pata 1 gia na deis ta energa simvolea sou, 2 gia na deis ta statistika ollwn");
                   try{
                       y = scan.nextInt();
                   }catch(InputMismatchException e){
                       System.out.println("Mi egiri isodos");
                       break;
                   }
                   if(y == 1){
                        System.out.println("Dose to afm sou");
                        afm = scan.next();
                        user = User.findUserAfm(afm);
                        if(user == null){
                            System.out.println("den uparxei profile me afto to afm");
                        }else{
                            user.printActiveContracts();
                        }
                   }else if(y == 2){
                       System.out.println("TODO");
                   }
                    
                    break;
            }
        }while(x!=5); 
    }
}
