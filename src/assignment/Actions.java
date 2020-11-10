/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

import java.util.Scanner;

/**
 *
 * @author 14383
 */
public class Actions {

    /**
     * @param args the command line arguments
     */
    static Airplane newAirplane;
    static void allActions(int status) {
        if(status == 0) {
            System.out.println("1 - Start");
            System.out.println("2 - Stop");
            System.out.println("3 - Take off");
            System.out.println("4 - Increase Altitude");
            System.out.println("5 - Decrease Altitude");
            System.out.println("6 - Exit");
        }
        else if(status == 1) {
            System.out.println("1 - Enter manually");
            System.out.println("2 - Let system set automatically");
        }
    }
    
    static void selectAltitudeCase(int choice, String action){
        System.out.println("Enter altitude height");
        Scanner sc = new Scanner(System.in);
        switch (choice){
            case 1:
                int altitude = 0;
                altitude = sc.nextInt();
                newAirplane.changeAltitude(altitude, action);
                System.out.println("Now airplane's altitude is " + newAirplane.getAltitude());
                return;
            case 2:
                newAirplane.changeAltitude(-1, action);
                System.out.println("Now airplane's altitude is " + newAirplane.getAltitude());
                return;
        }
    }
    
    static void selectCase(int choice){
        Scanner sc = new Scanner(System.in);
        int ch =0;
        switch(choice){
            case 1:
                if(newAirplane != null) {
                    System.out.println("Airplane is already started");
                    return;
                }
                newAirplane = new Airplane();
                System.out.println(newAirplane.toString());
                return;
                
            case 2:
                newAirplane.stop();
                return;
                
            case 3:
                newAirplane.takeOff();
                return;
                
            case 4:
                allActions(1);
                ch = sc.nextInt();
                selectAltitudeCase(ch, "increase");
                return;
            case 5:
                allActions(1);
                ch = sc.nextInt();
                selectAltitudeCase(ch, "decrease");
                return;
        }
            
    }
    
    public static void main(String[] args) {
        int choice = 0;
        System.out.println("Select from options");
        allActions(0);
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        while(choice != 6) {
            selectCase(choice);
            System.out.println("Enter your choice");
            allActions(0);
            choice = sc.nextInt();
            
        }
    }
    
}
