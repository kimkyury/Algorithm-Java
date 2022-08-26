package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;


class Stick{
    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        for(int i =0; i<str.length(); i++){
           if(str.charAt(i) == '('){
               stack.push('(');
           } else{ // ')' 라면
                stack.pop();
                if(str.charAt(i-1) == '(') // 레이저라면
                    answer += stack.size();
                else{
                    answer ++;
                }
            }
        }

        return answer;
    }

    public static  void main(String [] args){
        Stick T =  new Stick();

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str)); 
    }
}