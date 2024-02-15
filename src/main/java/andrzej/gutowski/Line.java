package andrzej.gutowski;

public class Line {
    
    public Line(){
        main(null);
    }
    
    public void clearln(){
        System.out.println("");
    }
    
    public static void main(String args[]) {
        StringBuilder sb = new StringBuilder(30);
        for(int n = 0; n < 30; ++n)
            sb.append('-');
        sb.append(System.lineSeparator());
        System.out.print(sb.toString());
    }
}
