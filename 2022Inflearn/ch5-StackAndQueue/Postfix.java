package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;


class Postfix{
    public int solution(String str){
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(char c : str.toCharArray()){
            if(c == '+' ){
                stack.push(((stack.pop()) + (stack.pop())) );
            }else if (c == '-' ){
                int a = stack.pop();
                int b = stack.pop();
                stack.push(b-a );
            }else if (c == '*') {
                stack.push(((stack.pop()) * (stack.pop())) );
            }else if (c == '/') {
                stack.push(((stack.pop()) / (stack.pop())) );
            }
            else{
                stack.push(Character.getNumericValue(c));
            }
        }
        answer = stack.pop();
        return answer;
    }

    public static void main(String [] args){
        Postfix T =  new Postfix();

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str)); 
    }
}