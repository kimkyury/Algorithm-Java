import java.util.*;
import java.io.*;

public class baek11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        // k개의 동전 단위를 입력받는다(오름차순으로 받는다)
        int[] unit = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            unit[i] = Integer.parseInt(st.nextToken());
        }

        // 동전단위를 가장 큰것부터 나눈다.
        // 나눴을 때의 나머지를 이어받아 계속 나눈다
        // 그렇게 했을 때 각각의 몫의 갯수의 합을 받는다
        int cnt = 0;
        int rest = k;

        for (int i = n - 1; i >= 0; i--) {
            cnt += rest / unit[i];
            rest = rest % unit[i];
        }
        System.out.print(cnt);
    }
}
