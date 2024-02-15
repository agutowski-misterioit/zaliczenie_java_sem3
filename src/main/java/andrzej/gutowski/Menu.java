package andrzej.gutowski;

import java.util.Scanner;

public final class Menu {

    Scanner scan = new Scanner(System.in);
    
    private static boolean
            menuPlay,
            gameLevelMenuPlay;
    private Integer 
            menuPosition = 0,
            gameLevel;
    private static String nickname;
    
    public Menu(String nickname){
        Menu.menuPlay = true;
        Menu.gameLevelMenuPlay = false;
        Menu.nickname = nickname;
        this.gameLevel = 0;
        main(null);
    }
    
    public Boolean getMenuPlay(){
        return menuPlay;
    }
    
    private void setGameLevel(Integer lvl){
        this.gameLevel = lvl;
    }
    
    public Integer getMenuPosition(){
        return this.menuPosition;
    }
    public Integer getGameLevel(){
        return this.gameLevel;
    }
    public void switchMenuPlay(){
        Menu.menuPlay = !Menu.menuPlay;
    }
    
    public void switchGameLevelMenuPlay(){
        Menu.gameLevelMenuPlay = !Menu.gameLevelMenuPlay;
    }
    
    public static void showMainMenu(){
        new Line();
        
        System.out.println("1: Play a game with computer");
        System.out.println("2: Show your best score");
        System.out.println("3: Show your nickname");
        System.out.println("0: Exit a program");
    }
    
    private static void showGameTypeMenu(){
        new Line();
        
        System.out.println("1. Single game with CPU");
        System.out.println("2. Single game with CPU REVERSE");
        System.out.println("3. Multi games with CPU");
        System.out.println("4. Multi games with CPU ?");
        System.out.println("0. Go back");
    }
    
    private static void showGameLevelMenu(){
        
        new Line();
        System.out.println("1. Easy - between 0 to 100");
        System.out.println("2. Normal - between 0 to 10000");
        System.out.println("3. Hard - between 0 to 1000000");
        System.out.println("0. Go back");

        
    }
    
    private void gameLevelMenu(){
        
        showGameLevelMenu();
                
        while(gameLevelMenuPlay){
            System.out.println(" Select game level or go back");
            System.out.print("Player " + nickname + ": ");
            String level = scan.nextLine();
            
            switch(level){
                case "0":
                    switchGameLevelMenuPlay();
                    break;
                case "1":
                    setGameLevel(GameLevelEnum.EASY.value);
                    switchGameLevelMenuPlay();
                    break;
                case "2":
                    setGameLevel(GameLevelEnum.MEDIUM.value);
                    switchGameLevelMenuPlay();
                    break;
                case "3":
                    setGameLevel(GameLevelEnum.HARD.value);
                    switchGameLevelMenuPlay();
                    break;
                default:
                    System.out.println("command not found");
                    showGameLevelMenu();
                    break;
            }
        }
    }
    
    public void main(String args[]) {
        showMainMenu();
        
        while(menuPlay){
            
            if(getGameLevel() > 0){
                switchMenuPlay();
            }
            
            System.out.print("Player " + Menu.nickname + ": ");
            String menuPos = scan.nextLine();
            
            switch(menuPos){
                case "0":
                    switchMenuPlay();
                    break;
                case "1":
                    this.menuPosition = 1;
                    switchGameLevelMenuPlay();
                    gameLevelMenu();
                    switchMenuPlay();
                    break;
                case "2":
                    this.menuPosition = 2;
                    switchMenuPlay();
                    break;
                case "3":
                    this.menuPosition = 3;
                    switchMenuPlay();
                    break;
                default:
                    System.out.println("command not found");
                    showMainMenu();
                    break;
            }
        }
    }
}
