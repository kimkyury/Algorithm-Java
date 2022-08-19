import java.util.*;
import java.io.*;

public class baek_1654 {
    static int n, k, cnt;
    static Long[] lan;
    static Long mid;

    public static void main(String[] args) throws IOException {
        // 길이가 제각각인 랜선 k개
        // n개의 같은 길이의 랜선으로 만들자
        // n개를 만들 수 있는 랜선의 최대 길이
        // N개보다 많이 만드는 것도 N개를 만드는 것 포함. (즉,N개 이상 = N개)
        // 만들 수 있는 최대 랜선의 길이

        // 조건1. 1 <= k <= 10,000
        // 조건2. 1 <= N <= 1,000,000
        // 조건3. k <= N //랜선의 개수보다는 더 많은 수를 요구.
        // 조건4. maxLen <=2^31 -1 => 즉 int형으로 처리 가능

        // 힌트1. 이분탐색

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        lan = new Long[k];

        for (int i = 0; i < k; i++) {
            lan[i] = Long.parseLong(br.readLine());
        }

        // lan[0]~ lan[k-1]을 maxlen으로 나눈 몫의 합이 n이 되어야 한다
        // lan을 정렬하기
        Arrays.sort(lan); // 랜선 오름차순 정리

        // 힌트를 이용해서, 이분 탐색을 써보자
        binarySearch_LanMaxLen((long) 0, lan[k - 1] + 1);

        System.out.print(mid - 1); // 상한값을 +1을 해줬었으니 여기서 제거해주자.
    }

    static void binarySearch_LanMaxLen(Long min, Long max) { // 바이너리서치로 최대 랜선 길이 찾기

        mid = (min + max) / 2; // 이분법을 위한 임시 길이 중앙값, *(1) mid가 0이면 안 된다
        cnt = 0;

        if (min < max) { // 이분법의 실행 조건
            for (int j = 0; j < k; j++) {
                cnt += lan[j] / mid; // mid길이로 잘릴 토막 수를 세기 *(2) min =0, max=1이라면 mid=0이 된다, 이를 막자
            }

            if (cnt < n) { // 토막수가 적으니, 길이를 줄여야 한다 => 최대값이 감소된다
                binarySearch_LanMaxLen(min, mid);
            } else { // 토막수가 많으니, 길이를 증가시켜야 한다=> 최저값이 증가된다
                binarySearch_LanMaxLen(mid + 1, max); // 하한값은 +1을 해줘야 min<max 조건문을 제대로 수행하게 하겠지
                                                      // ex) min =2, max=3 이었다면=> mid=2가 되니까 계속 반복됨.
            }
        }
    }
}
