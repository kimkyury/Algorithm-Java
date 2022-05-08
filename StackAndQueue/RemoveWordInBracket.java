
import java.util.Scanner;
import java.util.Stack;


class RemoveWordInBracket{
    public String solution(String str){
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<str.length(); i++){
            if(str.charAt(i) == ')'){ 
                //for(char c : stack) System.out.print(Character.toString(c) + ' ');
                //System.out.println();
                //while(stack.lastElement() != '(') stack.pop();
                while(stack.pop() != '(');
            }else stack.push(str.charAt(i));
        }

        for(char c : stack) answer += c;
        return answer;
    }

    public static void main(String [] args){
        RemoveWordInBracket T =  new RemoveWordInBracket();

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str)); 
    }
}