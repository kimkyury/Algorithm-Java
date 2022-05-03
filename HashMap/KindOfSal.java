import java.util.HashMap;
import java.util.Scanner;


class KindOfSal{
    public int[] solution(int[] arr, int n, int k) {
        int[] answer = new int [n-k+1]; 
        // n = 7, k=4 
        // 20 12 20 10 23 17 10
        //for(int i =0; i<n-k+1; i++) answer[i] = 0;

        HashMap<Integer, Integer> map= new HashMap<>();
        
        for(int i =0; i<k; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        answer[0] = map.size();

        int lt =0;
        for( int rt=k; rt<n; rt++){
            map.put(arr[rt], map.getOrDefault(arr[rt],0) + 1);
            map.put(arr[lt], map.get(arr[lt]) -1);

            if( map.get(arr[lt]) == 0) map.remove(arr[lt]);
            
            lt++;
            answer[lt] = map.size();
        }


         return answer;
    }

    public static void main(String [] args){
        KindOfSal T =  new KindOfSal();

        Scanner sc= new Scanner(System.in);
        // 500이하의 음이 아닌 정수
        int n = sc.nextInt();
        int k = sc.nextInt();

        int arr[] = new int [n];
        for ( int i =0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for(int x : T.solution(arr, n ,k)){
            System.out.print(x + " ");
        }

    }
}