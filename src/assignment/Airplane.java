/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;

/**
 *
 * @author 14383
 */
public class Airplane {
    int altitude;
    String state;
    
    public Airplane(){
        this.altitude = 0;
        this.state = "Plane is in landing position";
    }
    
    public void stop(){
        if(this.altitude > 0)
        {
            System.out.println("You need to decrease the altitude");
            return;
        }
        System.out.println("Airplane is stopped");
    }
    
    public void takeOff(){
        if(this.altitude == 0)
        {
            System.out.println("Airplane is in taking off mode");
            return;
        }
        System.out.println("Airplane is already in take off mode");
    }

    public int getAltitude() {
        return altitude;
    }
    
    public void setAltitude(String action) {
         if(action.equals("increase"))
            this.altitude += 1000;
        else
            this.altitude -= 1000;
    }

    public void changeAltitude(int altitude, String action){
        if(action.equals("increase"))
            if(altitude != -1) {
                if((this.altitude+altitude) >= 12000)
                {
                    System.out.println("Airplane exploded");
                    this.altitude = 0;
                    return;
                }
                else if((this.altitude+altitude) >= 10000){
                    System.out.println("Dangerous altitude!");
                    this.altitude += altitude;
                }
                else{
                    this.altitude += altitude;
                }
            }
            else{
                if((this.altitude+1000) >= 12000)
                {
                    System.out.println("Airplane exploded");
                    this.altitude = 0;
                }
                else if((this.altitude+1000) >= 10000){
                    System.out.println("Dangerous altitude!");
                    this.altitude += 1000;
                }
                else{
                    this.altitude += 1000;
                }
            }
        else {
            if(altitude != -1) {
                if((this.altitude-altitude) < 0)
                {
                    System.out.println("Airplane exploded");
                    this.altitude = 0;
                    return;
                }
                else if((this.altitude-altitude) == 0){
                    this.altitude = 0;
                    this.toString();
                }
                else{
                    this.altitude -= altitude;
                }
            }
            else{
                if((this.altitude-1000) < 0)
                {
                    System.out.println("Airplane exploded");
                    this.altitude = 0;
                    return;
                }
                else if((this.altitude-1000) == 0){
                    this.altitude = 0;
                    this.toString();
                }
                else{
                    this.altitude -= 1000;
                }
            }
        }
        setAltitude(this.altitude);
    }
    
    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public String toString() {
        return "Plane's altitude is " + altitude + " and " + state;
    }
}
