package StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Princenss{
    public int solution(int n, int k){
        int answer = 0;
        Queue <Integer> queue = new LinkedList<>();


        for ( int i =1; i<=n; i++){
            queue.offer(i);
        }

        while(!queue.isEmpty()){
            for(int i =1; i<k; i++){
                int move = queue.poll();
                queue.offer(move);
            }
            queue.poll();
            if(queue.size() ==1) answer = queue.poll();
        }

        return answer;
    }

    public static void main(String [] args){
        Princenss T =  new Princenss();

        Scanner sc= new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        System.out.print(T.solution(N, K)); 
    }
}