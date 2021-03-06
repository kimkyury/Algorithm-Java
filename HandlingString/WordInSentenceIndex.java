package HandlingString;
import java.util.*;

class WordInSentenceIndex {
    public String solution (String str){
        String answer = "";
        int max = Integer.MIN_VALUE, pos;

        while((pos = str.indexOf(' '))!= -1){ // 띄어쓰기의 위치를 반환
            String tmp = str.substring(0, pos);
            int len = tmp.length();
            if (len > max) {
                max = len;
                answer = tmp;
            }
            str = str.substring(pos+1);
        }
        if ( str.length() > max ) {
            answer = str;
        }
    
        /*
        String [] s = str.split(" ");
        
        int len;
        for(String x : s){
            len = x.length();
            if ( max < len)
                max = len;
                answer = x;
        }
        */
        return answer; 
    }
    public static void main (String [] args){
        WordInSentenceIndex T = new WordInSentenceIndex();
    
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str));
    }
}