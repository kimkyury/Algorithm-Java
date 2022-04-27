import java.util.Scanner;

class TwoPoint {

    public int solution (int [] arr, int k){

        // 최대 k번을 0을 1로 변경 가능
        // 최대 k번의 변경을 통해 1로만 구성된 최대 길이 연속 부분수열 찾기
        // 1 1 0 0 1 1 0 1 1 0 1 1 0 1
        int answer = 0;
        int cnt = 0;
        int lt =0;
        int len;

        for ( int rt =0; rt<arr.length; rt++){
            if(arr[rt] == 0) cnt ++;

            while ( cnt > k) {
                if(arr[lt] == 0) cnt --;
                lt ++;
            }
            
            answer = Math.max(answer, rt-lt+1);
        }


        return answer;
    }


    public static void main (String [] args) {

        TwoPoint T = new TwoPoint();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();
        int k = sc.nextInt();
        int [] arr = new int [n];

        for (int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

		System.out.print(T.solution(arr, k));
    }
}