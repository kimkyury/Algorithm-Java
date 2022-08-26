package StackAndQueue;


import java.util.Scanner;
import java.util.Stack;


class RightBracket{
    public String solution(String str){
        String answer = "YES";
        Stack<Character> stack = new Stack<>();

        for( int i =0; i<str.length(); i++) {
            if(str.charAt(i) == '(') stack.push(str.charAt(i));
            else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }
        if(!stack.isEmpty()) return "NO";
        
         return answer;
    }

    public static void main(String [] args){
        RightBracket T =  new RightBracket();

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();
        
        System.out.print(T.solution(str)); 

    }
}