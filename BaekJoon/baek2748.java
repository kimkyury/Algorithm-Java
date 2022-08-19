import java.io.*;

public class baek2748 {

    // 수의 크기가 크기 때문에, 또 나중에 해당 공간이 null인지 확인하기 위하여 변수공간을 Long으로 지정한다 ('L'ong =
    // 'l'ong의 warpper타입(객체화)이기 때문에 null비교 가능)
    static Long[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        values = new Long[N + 1];

        // Long을 사용할 때 이를 표시해주기 위해 끝에 L를 삽입한다. 하지 않으면 오류남
        values[0] = 0L;
        values[1] = 1L;

        // 결과값은 null비교할 것도 아니고, 값만 저장하면 되니까 long으로 쓰자.
        long answer = fibonacci(N);
        System.out.print(answer);
    }

    // 동적할당으로 풀어보자. 해당 배열에 값이 없으면 재귀호출을 하고 있을 경우 그 값을 그대로 쓴다.
    static long fibonacci(int N) {

        if (values[N] == null) {
            values[N] = fibonacci(N - 1) + fibonacci(N - 2);
        }

        return values[N];
    }
}
