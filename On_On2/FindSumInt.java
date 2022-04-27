import java.util.*;

class FindSumInt {

    public int solution (int n){
        int answer =0;

        int sum = 0;
        int lt =1;
        for(int i =1; i<=n; i++){
            if( sum == n)answer ++;
            sum += i;
            
            if( sum > n ) {
                while(sum >n) sum -= lt++;
            }
        }

        return answer;
    }


    public static void main (String [] args) {

        FindSumInt T = new FindSumInt();
		Scanner sc = new Scanner(System.in);
		int n =sc.nextInt();

		System.out.print(T.solution(n));
    }
}