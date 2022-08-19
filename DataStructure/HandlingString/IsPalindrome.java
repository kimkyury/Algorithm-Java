package HandlingString;

import java.util.Scanner;

class IsPalidrome {
    public String solution (String str){
        //palindrome
        String answer = "YES";
        String upperStr = str.toUpperCase();

        int len = str.length();
        for ( int i =0; i < len/2; i++){
            if(upperStr.charAt(i) != upperStr.charAt(len-i-1)){
                return "NO";
            }
        }
        return answer;
    }

    public static void main (String [] args){
        IsPalidrome T = new IsPalidrome();  
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }
}