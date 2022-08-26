package Array;
import java.util.ArrayList;
import java.util.Scanner;

class ReverseErastothenes {
    public boolean isPrime(int num) {
        if(num ==1) return false;
        for ( int i =2; i<num/2+1; i++){
            if ( num % i == 0){
                return false;
            }
        }
        return true;

    }


    public ArrayList<Integer> solution (int n, int [] arr){
        
        ArrayList<Integer> answer = new ArrayList<Integer>();

        
        int tmp, t;
        for ( int i =0; i<n; i++){
            tmp = arr[i]; //1230;
            int res =0;
            while (tmp > 0){
                t = tmp%10; // 0, 3
                res = res*10 + t; // 0 , 3
                tmp = tmp /10; //123

            }
            if(isPrime(res)) answer.add(res);
        }
        
        return answer;

    }
    public static void main (String [] args){
		ReverseErastothenes T = new ReverseErastothenes();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] arr=new int[n];
		for(int i=0; i<n; i++){
			arr[i]=kb.nextInt();
		}
		for(int x : T.solution(n, arr)){
			System.out.print(x+" ");
		}

    }
}

