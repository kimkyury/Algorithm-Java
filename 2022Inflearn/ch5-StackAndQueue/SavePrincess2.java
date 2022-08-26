import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static int solution(int N, int K) {

        int answer = 0;
        // Integer Type으로 initialize
        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() != 1) {
            int target;
            for (int i = 1; i < K; i++) { // k-1명 First -> last 이동
                target = q.poll();
                q.add(target);
            }
            q.poll(); // k번째 인물 제거
        }

        answer = q.peek();

        return answer;

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int K = in.nextInt();

        System.out.println(solution(N, K));
        return;
    }
}