package HandlingString;
import java.util.Scanner;

class IsPaindromeReplace {
    public String solution (String str){
        //palindrome, Should Care about only Char
        String answer = "YES";
        str = str.toUpperCase().replaceAll("[^A-z]", "");

        //reverse
        String tmp =  new StringBuilder(str).reverse().toString();

        if(!str.equals(tmp)) return "NO";
        
        return answer;
    }

    public static void main (String [] args){
        IsPaindromeReplace T = new IsPaindromeReplace();  
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(T.solution(str));
    }
}