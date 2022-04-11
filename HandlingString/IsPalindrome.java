import java.util.Scanner;

class Main {
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
        Main T = new Main();  
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str));

    }
}