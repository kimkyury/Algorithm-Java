package HandlingString;
import java.util.*;

 class WordinSentence {
    public String solution (String str){
        String answer = "";
        int max = Integer.MIN_VALUE;
        String [] s = str.split(" ");
        
        for(String x : s){
            int len = x.length();
            if ( max < len){
                max = len;
                answer = x;
            }
        }

        return answer;
    }


    public static void main(String [] args){
        WordinSentence T = new WordinSentence();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }

}