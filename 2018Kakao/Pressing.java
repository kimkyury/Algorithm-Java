import java.io.*;
import java.util.*;

public class Pressing {
    LinkedHashMap<Character, Integer> dictionary = new LinkedHashMap<>();

    public int[] solution(String msg) {
        int[] answer = {};
        
        initSetting();
        // a~z 까지 index는 1~26까지 저장되어있다

        // KAKAO
        // 시작은 K로 간다

        int msgIndex = 0;

        for(int i =0; i<msgIndex; i++){
            Character first = msg.charAt(i);
           
        }
        


        return answer;
    }
    public void initSetting() {
        
        int index =0 ;
        for( int i =65; i<=90; i++){
            dictionary.put( (char)i, ++index);
        }

        for(Character c: dictionary.keySet()){
            System.out.print( c + ": " + dictionary.get(c) + "\t");
        }
    }

    public static void main (String [] args) throws IOException{
        Pressing Problem = new Pressing();
        String msg = "KAKAO"	;  // 1< msg < 1000
        System.out.print(Problem.solution(msg));

    }
}