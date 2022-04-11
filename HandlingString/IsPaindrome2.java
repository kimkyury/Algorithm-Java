import java.util.Scanner;

class IsPaindrome2 {
    public String solution (String str){
        //palindrome, 대소문자 구분을 하지 않는다면
        String answer = "YES";
        
        //reverse
        String tmp = new StringBuilder(str).reverse().toString();

        if (!str.equals(tmp)){
            return "NO";
        }
        return answer;
    }


    public static void main (String [] args){
        IsPaindrome2 T = new IsPaindrome2();  
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }
}