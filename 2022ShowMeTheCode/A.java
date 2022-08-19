package BaekJoon;

import java.io.*;
import java.util.*;

public class A {

    private Stack<Character> stack = new Stack<>(); // 유효성 검사
    
    public int solve(int n, int k, int [] powers, int [] citizen){
        int answer = 0;


        for(int power : powers){
            System.out.print(" " + power);
        }
        for(int cnt : citizen){
            System.out.print(" " + cnt);
        }


        return answer;
    }




    public static void main (String [] args) throws IOException{  
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        A problem = new A();

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 몬스터 수 (= 마을의 수)
        int n = Integer.parseInt(st.nextToken());
        // 시루의 초기 체력
        int k = Integer.parseInt(st.nextToken());

        // n마리 몬스터들의 각 공격력
        int powers[] = new int [n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++){
            powers[i] = Integer.parseInt(st2.nextToken());
        }

        // 각 마을에 있는 주민의 수
        int citizen [] = new int [n];
        StringTokenizer st3 = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            citizen[i] = Integer.parseInt(st3.nextToken());
        }

        System.out.print(problem.solve(n, k, powers, citizen));
    }
}