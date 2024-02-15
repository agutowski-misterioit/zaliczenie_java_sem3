package andrzej.gutowski;

public class PlayerScore {
    Integer score, movements, level;
    
    public PlayerScore(Integer score, Integer movements, Integer level){
        this.score = score;
        this.movements = movements;
        this.level = level;
    }
    
    public Integer getScore(){
        return this.score;
    }
    
    public Integer getMovements(){
        return this.movements;
    }
    
    public Integer getLevel(){
        return this.level;
    }
}
