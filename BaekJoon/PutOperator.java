package BaekJoon;

import java.io.*;
import java.util.*;

public class PutOperator {

    private static int n;
    private static int [] arrOperationCnt;
    private static int [] arrA;
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;


    public void dfs(int num, int idx) {
        
        if (idx == n-1){
            if(min > num ) min = num;
            if (max <num) max = num;
            return;
        }

        for(int i =0; i<4; i++) { // 각 연산자에 대하여
            
            if(arrOperationCnt[i] != 0){
                arrOperationCnt[i]--;
                 if(i==0) dfs(num + arrA[idx+1], idx+1); 
                 if(i==1) dfs(num - arrA[idx+1], idx+1); 
                 if(i==2) dfs(num * arrA[idx+1], idx+1); 
                 if(i==3) dfs(num / arrA[idx+1], idx+1); 
                 arrOperationCnt[i] ++; // 이 부분을 이해하는 게 어려웠음, 재귀가 끝나면 원상복구 시키기.
            }

        }
    }

    public static void main (String [] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PutOperator problem = new PutOperator();

        n = Integer.parseInt(br.readLine());
        arrA = new int [n];
        arrOperationCnt = new int [4];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i =0; i<n; i++)
            arrA[i] = Integer.parseInt(st.nextToken());
        
        StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<4; i++)
            arrOperationCnt[i] = Integer.parseInt(st2.nextToken()); // 덧, 뺄, 곱, 나

        problem.dfs(arrA[0], 0);
        System.out.println(max);
        System.out.println(min);
    }
}
