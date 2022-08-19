package HandlingString;
import java.util.*;

 class FindingcharForEach {

    public int solution(String str, char t) {
        int answer =0;
        str = str.toUpperCase();
        t = Character.toUpperCase(t);
        // 향상된 for문
        for(char c : str.toCharArray()){
            if(c == t){
                answer++;
            }
        }

        return answer;
    }



    public static void main(String [] args){
        FindingcharForEach T = new FindingcharForEach();
        Scanner kb = new Scanner(System.in);

        String str = kb.next();
        char c = kb.next().charAt(0);
        System.out.print(T.solution(str, c));

    }
}