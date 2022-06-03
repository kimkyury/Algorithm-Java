package BaekJoon;

import java.io.*;
import java.util.*;

public class ValueBracket {

    private Stack<Character> stack = new Stack<>(); // 유효성 검사
    
    public int solve(String str){
        int answer = 0; // total(answer)
        int tmp = 1; // subSum

        int i = 0; // index
        for (char c : str.toCharArray()){
            //System.out.print(i + " 현재 total: " + answer);
            //System.out.println("\t 현재 stack: "  + stack.toString());
            //  (()[[]])([])
            
            // 여는 괄호들에 대하여
            if(c == '(' ){
                stack.push(c);
                tmp *=2; 
            }else if(c == '['){
                stack.push(c);
                tmp *=3;
            }

            //닫는 괄호 발견시
            if(c == ')'){
                //System.out.println("----total: "  + answer);

                // 올바르지 않을 경우 처리
                if(stack.isEmpty()) return 0;
                else if(!(stack.peek().equals('('))) return 0;

                // 점수 계산하기
                if(str.charAt(i-1) == '(') answer += tmp; // 더하기만 해당 if문에 종속된다
            
                tmp /= 2;
                stack.pop(); // pop은 str원본의 여부와 상관없이, 닫는 괄호 발생시 삭제한다 (여기까지 왔단 것 자체로 정상적인 괄호 상태이므로.)
                

            }else if( c == ']'){

                // 올바르지 않을 경우 처리
                if( stack.isEmpty())  return 0;
                else if(!(stack.peek().equals('['))) return 0;

                // 점수 계산하기
                if(str.charAt(i-1) == '[') answer += tmp; 
                tmp /= 3;
                stack.pop(); // 위와 동일하게 pop은 바로 위의 str의 여부와 상관없이 발생
            }

            i++;
        }

        return answer;
    }

    public static void main (String [] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ValueBracket problem = new ValueBracket();

        String str = br.readLine();

        System.out.println(problem.solve(str));

        //System.out.println(problem.solve(str));
    }
}