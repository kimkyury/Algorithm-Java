import java.util.*;
import java.io.*;

public class baek13305 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력: 첫 줄-도시의 개수(n), 두 번째 줄- 두 도시를 연결하는 도로의 길이(n-1), 세번재 줄: 주유소 리터당 가격(n)
        // 출력: 최소비용값
        // 비용 계산:

        int n = Integer.parseInt(br.readLine());
        int[] length = new int[n - 1];
        int[] price = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n - 1; i++) {
            length[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        long totalCost = 0;
        int i = 0;

        while (i < n) {
            long cost = price[i];
            long distance = 0;

            for (i++; i < n; i++) {
                distance += length[i - 1];
                if (cost > price[i])
                    break;
            }
            totalCost += cost * distance;
        }
        System.out.print(totalCost);
    }
}
