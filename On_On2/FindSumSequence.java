import java.util.*;

class FindSumSequence {

    public int solution (int n, int m, int [] arr){
        int answer =0;

        int sum = arr[0];

        int i =1;
        int startIndex= 0;
        while(i <n){
            while( i<n && sum < m) sum += arr[i++];
            if( sum == m ) answer++;
            sum -= arr[startIndex++];
        }

        return answer;
    }


    public static void main (String [] args) {

        FindSumSequence T = new FindSumSequence();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
        int m = sc.nextInt();

		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=sc.nextInt();
		}

		System.out.print(T.solution(n, m, arr));
    }
}