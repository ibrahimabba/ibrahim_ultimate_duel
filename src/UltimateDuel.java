import java.util.Scanner;

class Player {
    public int lifeSpan = 10;
    public BaseBallBat weapon;
    Player(int damageStrength){
        this.weapon = new BaseBallBat(damageStrength);
    }

}

class BaseBallBat {
    public int weaponStrength;

    BaseBallBat(int damageStrength){
        this.weaponStrength = damageStrength;
    }
}

public class UltimateDuel {

    public static void main(String[] args) {
        System.out.print("Welcome to the ultimateDuel");
        System.out.println("\nWhen the game starts, keep Pressing h to hit your Opponent");
        System.out.println("\npress s to start the Game");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if(input.equals("s")){
            start();
        }

    }

    static void start(){
        System.out.println("\nGame started");
        Player computer = new Player(2);
        Player person = new Player(2);


        double max = Math.floor(3);
        double min = Math.ceil(1);

        double determinedRandValue = Math.floor(Math.random() * (max - min) + min);

        double computerGeneratedRandValue;
        double playerGeneratedRandValue = 6;

        String input;
        while (computer.lifeSpan != 0 && person.lifeSpan != 0){
            computerGeneratedRandValue = Math.floor(Math.random() * (max - min) + min);
            Scanner sc = new Scanner(System.in);
            input = sc.nextLine();
            if(input.equals("h")){
                playerGeneratedRandValue = Math.floor(Math.random() * (max - min) + min);
            }
            if(playerGeneratedRandValue == determinedRandValue){
                computer.lifeSpan -= person.weapon.weaponStrength;
                System.out.print("Yeah Take this\n");
                System.out.print( computer.lifeSpan +"\n");
            }else if (computerGeneratedRandValue == determinedRandValue){
                person.lifeSpan -= computer.weapon.weaponStrength;
                System.out.print("Ouch!\n");
                System.out.print( person.lifeSpan +"\n");
            }else{
                System.out.print("you guys are not hitting yourselves\n");
            }
        }
        if(computer.lifeSpan == 0){
            System.out.print("You have won against your Opponent");
        }else if (person.lifeSpan == 0){
            System.out.print("your Opponent won!");
        }
    }
}