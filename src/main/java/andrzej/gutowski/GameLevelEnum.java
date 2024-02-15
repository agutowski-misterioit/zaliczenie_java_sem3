package andrzej.gutowski;

public enum GameLevelEnum {
    EASY    (100, "Easy"),
    MEDIUM  (10000, "Medium"),
    HARD    (1000000, "Hard");

    public final Integer value;
    public final String name;

    private GameLevelEnum(Integer value, String name) {
        this.value = value;
        this.name = name;
    }
    
    public static String getNameOfEnum(int value){
        for(GameLevelEnum e: GameLevelEnum.values()){
            if(e.value == value){
                return e.name;
            }
        }
        return null;
    }
}