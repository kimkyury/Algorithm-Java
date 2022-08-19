import java.util.*;
import java.io.*;

public class baek11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), "");

        int n = Integer.parseInt(st.nextToken());
        int[] time = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
        }
        // time배열을 오름차순으로 정렬하자
        for (int i = 0; i < n - 1; i++) {
            boolean bigger = false;
            // 오름차순 되지 않은 순서가 있는지 확인하자
            for (int j = 0; j < n - 1; j++) {
                if (time[j] > time[j + 1]) {
                    bigger = true;
                    break;
                }
            }
            // 오름차순 되지 않은 순서가 있었다면 재정렬하자
            for (int k = 0; k < n - 1; k++) {
                if (bigger == true && time[k] > time[k + 1]) {
                    int tmp = time[k];
                    time[k] = time[k + 1];
                    time[k + 1] = tmp;
                }
            }
        }
        // answer배열을 만들어서 오름차순을 1, 2, 3, 4, 5번째까지 더하도록하고 리턴시키자
        int sum1, sum2 = 0;
        for (int j = 0; j < n; j++) {
            sum1 = 0;
            for (int i = 0; i <= j; i++) {
                sum1 += time[i];
            }
            sum2 += sum1;
        }

        System.out.print(sum2);
    }
}