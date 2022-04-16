import java.util.Scanner;

class TallerStudent {
    public int solution (int N, int [] intArr){
        int answer = 1;

        // i는 자신의 앞에 있는 모든 학생보다 커야한다

        Boolean isTaller;

        for ( int i =1; i<N; i++){
            isTaller = true;
            for (int j = 0; j<i; j++){
                if( intArr[j] >= intArr[i]){
                    isTaller = false;
                    break;
                } 
            }
            if(isTaller == false) continue;
            else answer++;
        }

        return answer;
        
    }
    public static void main (String [] args){
        TallerStudent T = new TallerStudent();  
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int [] intArr = new int [n];
        for(int i =0; i<n; i++){
            intArr[i] = sc.nextInt();
        }
        

            System.out.print(T.solution(n, intArr));
    }
}