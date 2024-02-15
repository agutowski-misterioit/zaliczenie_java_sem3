package andrzej.gutowski;

import java.util.Random;
import java.util.Scanner;

public final class Engine {
    
    private final Integer 
        level,
        gameType,
        defaultScore = 1000,
        numberToGuess;
    private Boolean
        gameInstance;
    private Integer
        numOfApproaches = 0,
        playerScore = 0;
            
    public Engine(int level, int gameType) {
        this.level = level;
        this.numberToGuess = 0; //new Random()
//                .ints(0,this.level)
//                .findFirst()
//                .getAsInt();
        this.gameInstance = true;
        this.gameType = gameType;
        
        main(gameInstance);
    }
    
    public Integer getLevelScore(){
        return (int)(defaultScore * (level / 100));
    }
    
    public Integer getApproaches(){
        return numOfApproaches;
    }
        
    public Integer getScore(){
        if(numOfApproaches > 0){
            playerScore = getLevelScore() / numOfApproaches;
        }
        return playerScore;
    }
    
    public Integer getGameType(){
        return gameType;
    }
    
    
    private Boolean checkIfParseInt(String input){
        try{
            Integer.valueOf(input);
            return true;
        }catch(NumberFormatException nfe){
            return false;
        }
    }
    
    public Boolean checkNumber(String input){

        if(checkIfParseInt(input)){
            
            Integer inputInt = Integer.valueOf(input);

            numOfApproaches++;
        
            if(!(inputInt.equals(numberToGuess))){
                if(numberToGuess > inputInt){
                    System.out.println("Number is bigger than " + input);
                }
                if(numberToGuess < inputInt){
                    System.out.println("Number is lower than " + input);
                }

                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
        
    }
    
    public void main(Boolean gameInstance) {
        Scanner scan = new Scanner(System.in);
        
        while(this.gameInstance.equals(true)){
            
            if(numOfApproaches.equals(0)){
                new Line();
                System.out.println("The computer drew a number from 0 to " + level);// + " [" + numberToGuess + "]");
                System.out.println("Can you guess it?");
            }else{
                System.out.print("Wrong, try again! ");
                System.out.println("Movements made: " + numOfApproaches);
            }
            
            String playerInput = scan.nextLine();
            
            if(playerInput.equals("no")){
                this.gameInstance = !this.gameInstance;
                System.out.println("You loose");
            }else if(checkNumber(playerInput).equals(true)){
                this.gameInstance = !this.gameInstance;
                System.out.println("You win!!\n Movements: " + numOfApproaches + "\n Your score: " + getScore() );
            }
            
        }
        
        

    }
}
