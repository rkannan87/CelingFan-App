package com.medavie.bluecross.tech.main;

import java.util.Scanner;
import com.medavie.bluecross.tech.enums.DirectionState;
import com.medavie.bluecross.tech.enums.SpeedState;

public class CeilingFan {
	
    private SpeedState level;
    private DirectionState state;
    private boolean isPowerOn;

    public CeilingFan() {
        this.level = SpeedState.OFF;
        this.state = DirectionState.FORWARD;
        this.isPowerOn = true;
    }
    
    public void start()	{
    	System.out.println(String.format("Ceiling Fan Application"));
    	Scanner sc = new Scanner(System.in);
    	while(isPowerOn) {
    		System.out.println(String.format("%nSpeed:%s Direction:%s%n", level.ordinal() == 0 ? "Off" : level.name(), state.name()));
    		int cordChoice = getUserOperation(sc, "Pull cord 1 for Speed or 2 for Direction : ");
    		if (cordChoice == 1) {
    			pullSpeedCord();
    		}  else if (cordChoice == 2) {
    			pullDirectionCard();
    		}
    	}
    }
    
    public static int getUserOperation(Scanner sc, String prompt) {
        boolean isValidInt = false;
        int cordChoice = 0;
        while (isValidInt == false) {
            System.out.print(prompt);
            if (sc.hasNextInt()) {
                cordChoice = sc.nextInt();
                if(cordChoice == 1 || cordChoice == 2){
                  sc.nextLine();
                  break;
                }               
            }   
            else{
            	sc.next();
            }
            System.out.println(String.format("%nInvalid selection. Please choose either option 1 or 2.%n"));
            sc.nextLine();          
        }
        return cordChoice;
    }

    private void pullSpeedCord(){
        System.out.println("-----------------------------------------------");
        System.out.println("Current Speed Mode is: " + level);
        if(state == DirectionState.FORWARD) {
        	level = level.getNextMode();
        }
        else if(state == DirectionState.REVERSED){
        	level = level.getPreviousMode();
        }
        System.out.println("After Changing Mode is: " + level);
        System.out.println("-----------------------------------------------");
    }

    private void pullDirectionCard(){
        System.out.println("-----------------------------------------------");
        System.out.println("Current Direction State is: " + state);
        this.state = changeDirection(state);
        System.out.println("After Changing Direction is: " + state);
        System.out.println("-----------------------------------------------");
    }

    private DirectionState changeDirection(DirectionState presentState) {
    	return presentState.ordinal()== 0 ?  DirectionState.REVERSED : DirectionState.FORWARD;
    }
    
    public static void main(String[] args) {
        CeilingFan ceilingFan = new CeilingFan();
        ceilingFan.start();
	}

}
