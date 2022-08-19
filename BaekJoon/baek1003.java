import java.io.*;

public class baek1003 {
    static BufferedWriter bw;

    // 기존 재귀방식으로 해결하면 런타임 오류걸림. 시간복잡도를 줄이기위해 동적으로 가자.
    // null값을 비교하기 위한 (Wrapper)Long 배열 생성
    static int[][] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            // 문제에서 N은 40이하라고 했으니, 41이라고 설정해두자.
            // 실은 N에 따라서 변화시키려니 0때문에 N+2라고 해야하는데 그게 더 가독력 떨어져보인다
            values = new int[41][2];

            // [0]일 때와 [1]일 때의 카운트 횟수를 초기화시켜주자, null비교하려면 Wrapper로 Integer 타입으로 바꾸는 방법도 있다.
            for (int j = 0; j < N + 1; j++) {
                values[j][0] = -1;
                values[j][1] = -1;
            }

            // 0과 1의 호출에 따라서만 카운트의 변화가 일어나니 이 두개만 미리 수정시켜준다
            values[0][0] = 1;
            values[0][1] = 0;
            values[1][0] = 0;
            values[1][1] = 1;

            fibonacci(N);
            bw.write(Integer.toString(values[N][0]) + " " + Integer.toString(values[N][1]) + "\n");
            // fivonacci(1) ==1출력 1 리턴, fibonacci(2) == 1리턴, fibonacci(3) == 2리턴 ,
            // fibonacci(0) == 0출력, 0 리턴
            // fibonacci(N)호출 시에, 0과 1이 각각 몇 번 출력되는지 구하는 프로그램
        }
        bw.flush();
    }

    // 배열의 리턴은 처음 해 봄
    static int[] fibonacci(int N) {

        // 재귀를 통해 피보나치의 횟수를 더해본다.
        if (values[N][0] == -1 || values[N][1] == -1) {

            // 각 0과 1의 저장값이 없다면, 원래 호출되어 더했을 값을 횟수의 덧셈으로 바꿔서(그걸 2차원배열로) 저장시킨다
            values[N][0] = fibonacci(N - 1)[0] + fibonacci(N - 2)[0];
            values[N][1] = fibonacci(N - 1)[1] + fibonacci(N - 2)[1];
        }

        return values[N];
    }
}
