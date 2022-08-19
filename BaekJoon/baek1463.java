import java.io.*;

public class baek1463 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // N % 3== 0 이면 3으로 나누기
        // N % 2== 0 이면 2로 나누기
        // 둘 다 안되면 -1 시키기.
        // 결론적으로 이 연산을 통해 1을 만들기

        // 연산을 사용하는 횟수의 최솟값 출력하기
        // 1 <= N <=10^6

        // 계산횟수를 담는 배열을 만들자.
        int nums[] = new int[N + 1];
        nums[0] = 0;
        nums[1] = 0;

        // 원하는 정수 N에 도달할 때까지 점화식으로 횟수를 헤아려보자
        for (int i = 2; i <= N; i++) {
            // num[1]이 0부터 시작할테니, 우선 횟수를 한 번 더하자.
            nums[i] = nums[i - 1] + 1;

            // if (i % 3 == 0) {
            // // 3으로 나눠지는 수라면, +1로 끝나는 거지. 6일 때부터 이 행위에 의미를 가짐
            // nums[i] = Math.min(nums[i / 3] + 1, nums[i]);
            // continue;
            // }

            if (i % 2 == 0) {
                // 2로 나눠지는 수라면, +1로 끝나는 거지. 6일 때부터 이 행위에 의미를 가지기 시작함
                nums[i] = Math.min(nums[i / 2] + 1, nums[i]);
            }

            if (i % 3 == 0) {
                // 3으로 나눠지는 수라면, +1로 끝나는 거지. 6일 때부터 이 행위에 의미를 가짐
                nums[i] = Math.min(nums[i / 3] + 1, nums[i]);
            }
            // 2로도 3으로도 안 나눠지면 +1을 그대로 끌어안고 간다
        }
        System.out.print(nums[N]);

    }
}
