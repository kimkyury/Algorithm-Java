import java.util.Scanner;

class MaxSumGrid {

    public int solution (int [][] arr){
        int answer = Integer.MIN_VALUE;
        int sumV, sumH;
        int sumD1=0, sumD2=0;

        for ( int i =0; i<arr.length; i++){
            sumV =0;
            sumH=0;
            for(int j =0; j<arr.length; j++){
                sumV += arr[i][j];
                sumH += arr[j][i];
            }
            answer = Math.max(answer, sumV);
            answer = Math.max(answer, sumH);

            sumD1 += arr[i][i];
            sumD2 += arr[i][arr.length-i-1];
        }
        answer = Math.max(answer, sumD1);
        answer = Math.max(answer, sumD2);
    
        return answer;
    }
    public static void main (String [] args){
		MaxSumGrid T = new MaxSumGrid();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[][] arr=new int[n][n];
		for(int i=0; i<n; i++){
            for(int j =0; j<n; j++){
                arr[i][j]=kb.nextInt();
            }
		}

        System.out.print(T.solution(arr));
        
        
	
    }
}

