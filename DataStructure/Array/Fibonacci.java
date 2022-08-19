package Array;

import java.util.Scanner;

class Fibonacci {
    public String solution (int n ){
        int [] intArr = new int [n];
        intArr[0] = 1;
        intArr[1] = 1;

        for( int i =2; i<n; i++){
            intArr[i] = intArr[i-2] + intArr[i-1];
        }

        String answer = "1";
        for (int i =1; i<n; i++){
            answer += " " + intArr[i];
        }
        return answer;


    }
    public static void main (String [] args){
        Fibonacci T = new Fibonacci();  
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        System.out.println(T.solution(n));
    }
}