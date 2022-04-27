
import java.util.*;

class FINDSumInt_Math {

    public int solution (int n){
        // 몫과 나머지로 풀기
        int answer = 0, cnt = 1;

        n--;

        while ( n > 0){
            cnt ++;
            n = n - cnt;
            if ( n%cnt == 0) answer ++;
        }
        
        return answer;
    }


    public static void main (String [] args) {

        FINDSumInt_Math T = new FINDSumInt_Math();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();

		System.out.print(T.solution(n));
    }
}