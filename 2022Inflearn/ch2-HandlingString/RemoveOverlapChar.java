package HandlingString;

import java.util.Scanner;
class RemoveOperlapChar {

    public String solution (String str){
        //deleteOverlapChar

        String answer = "";
        for(int i =0; i<str.length(); i++) {
            if ( i == str.indexOf(str.charAt(i)) ){
                answer +=str.charAt(i);
            }
        }
        return answer;
    }

    public static void main (String [] args){
        RemoveOperlapChar T = new RemoveOperlapChar();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }
}