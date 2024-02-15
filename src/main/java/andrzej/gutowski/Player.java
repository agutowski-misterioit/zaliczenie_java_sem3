package andrzej.gutowski;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Player {
    
    private final String nickname, pathname;
    private final File file;
    private Integer bestScore, movements;
    private String level;
    
    public Player(String nickname)
    {
        this.nickname = nickname;
        this.pathname = Paths.get("./" + nickname + ".txt").toString();
        this.file = new File(pathname);
    }
    
    public String getNickname()
    {
        return nickname;
    }
    
    public void showNickname()
    {
        System.out.println("Your nickname: " + nickname);
    }
    
//    public Object DataThing(Integer scr, Integer mvmnts, Integer lvl){
//        scr = scr;
//        mvmnts = mvmnts;
//        lvl = lvl;
//        return this;
//    }
    
    public void flushBestScoreFromFile() throws FileNotFoundException{
        Scanner filereader = new Scanner(file);
        List<Integer> scores = new ArrayList<>();
        
//        List <Object> scoreFullLine = new ArrayList<>();
        
        List<PlayerScore> playerScoreList = new ArrayList<PlayerScore>();

        while ( filereader.hasNextLine() ){
            String readline = filereader.nextLine();
            String[] parts = readline.split(";");
            scores.add(Integer.valueOf(parts[0]));
            
            playerScoreList.add(
                new PlayerScore(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]), Integer.valueOf(parts[2]))
            );
                    
//            scoreFullLine.add(
//                    parts[0],parts[1]);
            
//            System.out.println(parts[0] + " | " + parts[1] + " | " + parts[2]);

//            Arrays.asList(playerScoreList).forEach(System.out::println);
            
        }
        
        if( !scores.isEmpty() ){
//            Collections.sort(scores, Collections.reverseOrder());    
//            this.bestScore = scores.get(0);

            Collections.sort(playerScoreList, new Comparator<PlayerScore>(){
                public int compare(PlayerScore o1, PlayerScore o2){
                    return o2.score.compareTo(o1.score);
                }
            });
            
            this.bestScore = playerScoreList.get(0).score;
            this.movements = playerScoreList.get(0).movements;
            this.level = GameLevelEnum.getNameOfEnum( playerScoreList.get(0).level );
        }
    }
    
    public void checkForPlayer() throws FileNotFoundException
    {
        new Line();
        System.out.println("Looking for player...");
        
        if (!file.exists())
        {       
            System.out.println("Save file not found");
            try 
            {
                System.out.println("Creating new save for " + this.nickname + " player" );
                Files.createFile(Paths.get(this.pathname));
            }
            catch (FileAlreadyExistsException x) 
            {
                System.err.format("file named %s" + " already exists%n", this.pathname);
            } 
            catch (IOException x) 
            {
                System.err.format("createFile error: %s%n", x);
            }
        }else{
            System.out.println("Save for player has been successfully found!");
            new Line();
            
            flushBestScoreFromFile();
        }
    }
    public void showBestScore()
    {
        if(bestScore != null){
            System.out.println(
                    "YOUR BEST SCORE: " + bestScore + "\n" +
                    "   movements: " + movements + "\n" +
                    "   level: " + level
            );
        }else{
            System.out.println("No score has been saved yet. Try play a game!");
        }
    }    
    public void saveGame(Integer score, Integer moves, Integer level) throws FileNotFoundException, IOException
    {
        try (PrintWriter filewriter = new PrintWriter(new FileWriter(file,true))) {
            filewriter.println(score.toString() + ";" + moves + ";" + level + ";");
        }
    }
}