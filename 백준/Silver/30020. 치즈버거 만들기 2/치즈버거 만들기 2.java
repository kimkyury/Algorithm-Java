import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, T;
    static int arr[];

    public static void main(String[] args) throws IOException {

        // patty = cheese +1
        // patty & cheese 다 쓰기

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        // 패티가 무조건 더 많아야함
        if (A > B && B >= (A - B)) {
            bw.write("YES\n");
        } else {
            bw.write("NO");
            bw.flush();
            return;
        }
        // ababa
        // abababa

        // (A-B) 개의 조합을 출력해야한다
        // B를 (A-B)개로 나눠야한다
        // 각 버거마다 1개의 치즈를 기본 할당
        int[] cheeseCount = new int[A - B];
        Arrays.fill(cheeseCount, 1);

        int cnt = A - B;
        bw.write(cnt + "\n");
        // 남은 치즈(B-K)개를 앞에서부터 하나씩 배분
        int remain = B - cnt;
        for (int i = 0; i < cnt && remain > 0; i++) {
            int add = Math.min(remain, 100); // 적당히 한 번에 많이 줘도 됨(여기서는 단순히 remain 모두 줘도 됨)
            cheeseCount[i] += add;
            remain -= add;
        }

        // 이제 각 버거를 패턴 출력: 치즈 c개, 패티 c+1개 -> "ab"를 c번 반복 후 마지막에 "a"
        for (int i = 0; i < cnt; i++) {
            int c = cheeseCount[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < c; j++) {
                sb.append("ab");
            }
            sb.append("a");
            bw.write(sb.toString() + "\n");
        }

        bw.flush();
    }
}
