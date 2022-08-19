import java.io.*;
import java.util.*;

public class baek1449 {
    static int n, l;
    static int[] location;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        location = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            location[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(location);

        // 목차 n-1까지 검사하자
        // 찾다보면 n-1까지 가겠지? 그 부분이 l+1를 초과하는 부분일 수도, l+1 이하일 수도 있다

        // 끝이 l+1초과하는 부분이면 테이프를 하나 더 붙인다
        // 끝이 l+1 이하인 부분이면 그대로 종료한다

        int cnt = 0;
        int index = 0;

        while (index < n) {
            for (int j = index; j < n; j++) {
                // 테이프 허용길이(l+1) 초과 부분을 발견한다면, 테이프를 사용하고
                if (location[j] - location[index] > l - 1) {
                    cnt++;
                    // 초과된 범위에서부터 다시 허용길이를 초과하는 부분을 찾자
                    index = j;

                    // 초과한 부분이면서 끝부분이라면, 테이프 한 번 더 쓰고 개수 출력
                    if (j == n - 1) {
                        cnt++;
                        System.out.print(cnt);
                    }
                    return;
                }
                if (j == n - 1) {
                    cnt++;
                    System.out.print(cnt);
                    return;
                }
            }
        }
        System.out.print(cnt);
    }
}