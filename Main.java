import java.util.Scanner;
import java.util.Stack;


class Main{
    public int solution(String str){
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<str.length(); i++){
           if(str.charAt(i) == '('){
               stack.push('(');
           } else{
               if(str.charAt(i-1) == ')'){
                   if(i-2>0 && str.charAt(i-2) ==')'){
                    stack.pop();
                   }
                   System.out.print(stack.size()+ " ");
                   stack.pop();
                   answer ++;
                   answer += stack.size();
               }else{
                stack.pop();
                System.out.print(stack.size() + " ");
                answer += stack.size();
               }
           }
        }

        return answer;
    }

    public static void main(String [] args){
        Main T =  new Main();

        Scanner sc= new Scanner(System.in);
        String str = sc.nextLine();

        System.out.print(T.solution(str)); 
    }
}