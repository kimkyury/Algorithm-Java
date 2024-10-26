import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[] tree, arr;

    static List<Integer> sosu;

    static int MAX = 4000000;

    public static void main(String[] args) throws IOException {

        // N = new StringTokenizer(br.readLine());
        N = Integer.parseInt(br.readLine());
        arr = new int[MAX + 1];

        sosu = new ArrayList<>();
        eratostenes();
        // bw.write(sosu.toString());

        // 1. 소수들을 모두 구한다
        // -- 에라토스테레스의 체 -> { 0, 0, 0, 0, 1}, 소수인 것들만 따로 arr로 만들기
        // 2. N 받기

        // 3. N을 연속된 소수로 나타낼 수 있는지 확인하기

        // 4. 완탐 시작,
        // -- 투 포인터로, idx:0부터 idx:N을 돌기
        // -- 연속된 구간합인데, 최초로 N을 만드는 순간을 만들고, rt++, lt-- 적절히, 최초로 만들어지는 게 없으면 0
        bw.write(calcul(N) + "");
        bw.flush();
    }

    public static int calcul(int N) {
        int cnt = 0;

        int lt = 1, rt = 1;
        // 1은 소수가 아닌가바
        int sum = 0;

        while (true) {
            if (sum >= N) {
                if (sum == N)
                    cnt++;
                sum -= sosu.get(lt++);
            } else if (rt == sosu.size()) {
                break;
            } else {
                sum += sosu.get(rt++);
            }
        }
        return cnt;
    }

    public static void eratostenes() {

        for (int i = 2; i <= Math.sqrt(MAX); i++) {
            if (arr[i] == 1)
                continue;
            for (int j = i * 2; j <= MAX; j += i) {
                arr[j] = 1;
            }
        }

        for (int i = 1; i < MAX; i++) {
            if (arr[i] == 0) {
                sosu.add(i);
            }
        }

        // sosu.add(N);
    }

}
