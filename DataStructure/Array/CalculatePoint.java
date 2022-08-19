package Array;
import java.util.Scanner;

class CalculatePoint {

    public int solution (int [] arr){
        int answer = 0;
        int point = 0;
        for(int i =0; i<arr.length; i++){
            if( arr[i] == 1) point++;
            else point = 0;
            answer += point;   
        }
        return answer;

    }
    public static void main (String [] args){
		CalculatePoint T = new CalculatePoint();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
        System.out.print(T.solution(arr));
	
    }
}

