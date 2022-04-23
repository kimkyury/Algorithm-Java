import java.util.*;

class MaxSal_SlidingWindow  {

    public int solution (int n, int k, int [] arr){
        int answer =0;

        int windowSum=0;
        for(int i =0; i<k; i++){
            windowSum += arr[i];
        }
        
        int maxSum = windowSum;
        for(int i =k; i<n; i++){
            windowSum = windowSum - arr[i-k] + arr[i];
            maxSum = Math.max(maxSum, windowSum);
        }
    
        answer = maxSum;
        return answer;
    }


    public static void main (String [] args) {

        MaxSal_SlidingWindow  T = new MaxSal_SlidingWindow ();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
        int k = sc.nextInt();

		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=sc.nextInt();
		}

		System.out.print(T.solution(n, k, arr));
    }
}