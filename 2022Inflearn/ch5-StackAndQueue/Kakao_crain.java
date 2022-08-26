package StackAndQueue;

import java.util.Scanner;
import java.util.Stack;


class Kakao_crain{
    public int solution(int n, int [][] board, int m, int [] moves){
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        int j = 0;
        int i =0;
        while( i< m){
            j=0;
            while(j < n){
                int doll = board[j++][moves[i]-1];
                board[j-1][moves[i]-1] = 0;
                if ( doll != 0){
                    if( !stack.isEmpty() && (stack.lastElement() == doll)){
                        stack.pop();
                        answer +=2;
                    }
                    else {
                        stack.push(doll);
                    }
                    break;
                }
            }
            i++;
        }

        // 크레인이 같은 숫자를 두개 연속해서 쌓이면 stack에서 제거된다
        // 인형이 없는 곳에 크레인이 들어가면 아무 일도 안 일어난다

        // moves == 작동된 위치

        return answer;
    }

    public static void main(String [] args){
        Kakao_crain T =  new Kakao_crain();

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int [][] board = new int [n][n];
        for(int i =0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = sc.nextInt();
            }
        }

        int m = sc.nextInt();
        int [] moves = new int [m];
        for(int i =0; i<m; i++){
            moves[i] = sc.nextInt();
        }

        System.out.print(T.solution(n, board, m, moves)); 
    }
}