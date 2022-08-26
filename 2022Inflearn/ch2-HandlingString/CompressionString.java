package HandlingString;

import java.util.Scanner;


class CompressionString {
    public String solution (String str){
        // CompressionString

        String answer="";
        str += " "; // 탐색을 위한 빈 문자 추가

        int cnt = 1;
        for ( int i =0; i<str.length() -1; i++){
            if (str.charAt(i) == str.charAt(i+1)) cnt++;
            else{
                answer += str.charAt(i);
                if (cnt >1) answer += String.valueOf(cnt);
                cnt =1;
            }
        }

        return answer;

                /*
        char tmp = str.charAt(0);
        int cnt=0;

        for (char c : str.toCharArray()){
            if(tmp != c ){
                answer += tmp;
            if( cnt > 1) answer +=cnt;
                cnt = 1;
                tmp = c;
            }
            else cnt ++;
        }
        answer += tmp;


        return answer;
    }
 */

    }
    public static void main (String [] args){
        CompressionString T = new CompressionString();  
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); //대문자로 입력받는다

        System.out.print(T.solution(str)); 
    }
}