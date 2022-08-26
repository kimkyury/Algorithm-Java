package Array;
import java.util.Scanner;

class FindLargeInteger {
    public String solution (int N, String str){
        // CompressionString

        String answer="";
        // '#*****#' -> 이진수로 바꾸기, #:1, *:0
        // 2진수를 10진수화 하기
        // 아스키 번호에 대해서 문자로 변환하기

        String [] intArr = new String [N];
        intArr = str.split(" ");
        answer += intArr[0];

        int tmp;
        for ( int i =1; i<N; i++){
            tmp = Integer.parseInt(intArr[i]);
            if (tmp > Integer.parseInt(intArr[i-1]) ){
                answer += " " + tmp;
            }
        }

        return answer;


        /* 최적화 답안 */
        /* input: int n, int[] arr
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);

        for(int i =1; i<n; i++){
            if(arr[i] > arr[i-1]) answer.add(arr[i]);
        } */


    }
    public static void main (String [] args){
        FindLargeInteger T = new FindLargeInteger();  
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine(); //대문자로 입력받는다

        System.out.print(T.solution(N, str)); 
    }
}