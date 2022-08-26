package Array;
import java.util.Scanner;

class Main {
    public String [] solution (int N, int [] recordA, int [] recordB){
        String [] answer = new String [N];

        for( int i =0; i<N; i++){
            if(recordA[i] == recordB[i])
                answer[i] = "D";
            else if(recordA[i] ==1 && recordB[i] == 3) answer[i] = "A";
            else if(recordA[i] ==2 && recordB[i] == 1) answer[i] = "A";
            else if(recordA[i] ==3 && recordB[i] == 2) answer[i] = "A";
            else answer[i] = "B";
        }


        return answer;
        
    }
    public static void main (String [] args){
        Main T = new Main();  
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] recordA  = new int [n];
        int [] recordB  = new int [n];

        for(int i =0; i<n; i++){
            recordA[i] = sc.nextInt();
        }
        for(int i =0; i<n; i++){
            recordB[i] = sc.nextInt();
        }
        
        
        String [] answer = T.solution(n, recordA, recordB);
        for (int i =0; i<n; i++){
            System.out.println(answer[i]);
        }
    }
}