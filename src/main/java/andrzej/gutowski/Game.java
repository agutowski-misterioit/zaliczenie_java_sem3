package andrzej.gutowski;

import java.util.Scanner;
import java.io.*;
 
public class Game {
                     
    public static void main(String[] args) throws IOException{

        Scanner scan = new Scanner(System.in);
        
        Info.welcomeMsg();
        
        System.out.print("What is your nickname: ");
        String nickname = scan.nextLine();
        
        Player player = new Player(nickname);
        player.checkForPlayer();
        player.showBestScore();
        
        
        Boolean gameLoop = true;
        
        while(gameLoop){
            Menu menu = new Menu(player.getNickname());
            
            if( menu.getGameLevel() > 0){
                Engine gameInstance = new Engine(menu.getGameLevel(), 1);
                if( gameInstance.getScore() != 0 ){
                    player.saveGame(gameInstance.getScore(), gameInstance.getApproaches(), menu.getGameLevel());
                    player.flushBestScoreFromFile();
                }
            }
            
            Line obj = new Line();
            
            switch(menu.getMenuPosition()){
                case 0:
                    obj.clearln();
                    System.out.println("Program quit");
                    obj.clearln();
                    System.exit(0);
                    break;
                case 2:
                    obj.clearln();
                    player.showBestScore();
                    obj.clearln();
                    break;
                case 3:
                    obj.clearln();
                    player.showNickname();
                    obj.clearln();
                    break;
                case 1:
                default:
                    break;
            }   
        }
    }
}
