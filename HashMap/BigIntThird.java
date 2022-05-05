import java.lang.Integer;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;


class BigIntThird{
    public int solution(int n, int k, int [] arr){
        int answer = 0;

        TreeSet<Integer> tSet = new TreeSet<>(Collections.reverseOrder());

        for(int i =0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int m = j+1; m<n; m++){
                    tSet.add(arr[i] + arr[j] + arr[m]);
                }
            }
        }
        int cnt = 0;
        for(int x : tSet){
            cnt ++;
            if(cnt == k ){
                answer = x;
                return answer;
            }
        }


     
         return -1;
    }

    public static void main(String [] args){
        BigIntThird T =  new BigIntThird();

        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [] arr = new int [n];
        for(int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.print(T.solution(n, k, arr)); 

    }
}