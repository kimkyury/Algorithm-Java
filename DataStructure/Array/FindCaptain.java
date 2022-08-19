package Array;
import java.util.Scanner;
class Main {

    public int solution (int [][] arr, int n){

        int answer = 0,  max=Integer.MIN_VALUE;
        int cnt;
        
        for(int i =1; i<=n; i++){
            cnt =0;
            for(int j=1; j<=5; j++){
                for(int k =1; k<n; k++){
                    if(arr[i][j] == arr[k][j]){
                        cnt++;
                        break;
                    }
                }
            }
            if(max < cnt) {
                max = cnt;
                answer = i;
            }
        }
        return answer;
    }
    public static void main (String [] args){
		Main T = new Main();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n+1][6];
		for(int i=1; i<=n; i++){
            for(int j =1; j<6; j++){
                arr[i][j]=kb.nextInt();
            }
		}

        System.out.print(T.solution(arr, n));
        
	
    }
}

