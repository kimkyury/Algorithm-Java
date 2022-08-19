import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class baek1904 {
    static ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
    static int[][] cbn;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        // 1과 00으로 만들 수 있는, 자리수가 N인 이진수의 개수
        // 1<= N <= 1,000,000
        // 1과 00 타일의 개수 제한은 없다

        // conbination 배열 생성, 총 n자리를 만들 1과 00의 개수를 넣는다
        cbn = new int[N / 2][2];

        for (int i = 0; i < N / 2; i++) {
            cbn[i][0] = i;
            cbn[i][1] = N - (i * 2);
        }

        // // 00은 'N/2' 만큼 쓸 수 있네
        // // 1은 'N이 홀수 -> 홀수 개의 1', 'N이 짝수 -> 짝수 개의 1', 사용되네
        // // 각 개수에 따라 중복이 있는 조합의 개수를 써야하네! (4!/3! 처럼)
        // //N의 개수에 따라 정해지는 00의 개수를 기준으로 arr공간을 만들자

        // for (int i = 0; i <= (int)(N / 2); i++) {
        // //여기는 1과 00의 개수에 따라 arr가 생겨난다
        // // 아직 여기에는 1과 00이 각각 들어간 게 없다.
        // ArrayList<String> zero = new ArrayList<String>();
        // arr.add(zero);
        // }
        // System.out.println("만들어진 Arraylist개수: " + arr.size() + "\n-------------");

        // //00이 0개일때, 1개일 때, ... , N/2개 까지 인덱스가 올라간다
        // //00이 0개일 때는 안 넣어줄 거니까, 1부터 (n/2) 까지하자.
        // for (int i = 1; i <= (N / 2); i++) {
        // for (int j = 0; j < i; j++) {
        // //그럼 j는 1개일 때 1번, 2개일 때 2번, ..., (n/2)일 때 (n/2)번 추가된다
        // arr.get(i).add("00");
        // }
        // }

        // //[00의 개수 -> 1의 개수] 는 다음과 같다.
        // //[0개 -> n개], [1개 -> n-2개], [2개 -> n-4개], ..., n/2개일 때 0개
        // //단, 1은 N이 홀수면 홀수 개, 짝수면 짝수 개다.
        // for (int i = 0; i <= (N / 2); i++) {
        // for (int j = 1; j <= N-2*i; j++) {
        // arr.get(i).add("1");
        // }
        // }
        // show();
        // // 각 케이스는 여기까지 다 나눴다. 이제 조합의 개수를 세보자

    }

    static void show() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(cbn[i][j] + " ");
            }
        }
    }

}
