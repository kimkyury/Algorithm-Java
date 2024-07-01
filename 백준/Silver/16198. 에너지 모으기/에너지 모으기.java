import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;

    private static StringBuilder sb = new StringBuilder();

    private static int maxSum = 0;

    public static void main(String[] args) throws IOException {

        // 에너지 구하기
        // x번째 에너지 구슬 제거
        // 각 무게의 곱만큼 에너지를 모을 수 있음

        int N = Integer.parseInt(br.readLine());

        // N-2자리는 가장 작은 수로 지정한다

        // 1 2 3 4 -> 1 2 4 (2x4) -> 1 4 (8 + 1x4)

        List<Integer> list = new LinkedList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        recur(0, list);
        // bw.write(sb.toString());

        bw.write(maxSum + "");
        bw.flush();

        // 완전 탐색을 통해서, 1부터 N-2까지를 뽑고 합계를 구한다

    }

    private static void recur(int sum, List<Integer> list) {

        // 자릿수가 2자리 수라면 중단한다
        if (list.size() == 2) {
            // sb.append("result: " + sum + "\n");
            maxSum = Math.max(sum, maxSum);
            return;
        }

        for (int i = 1; i <= list.size() - 2; i++) {

            List<Integer> copyList = new LinkedList<>(list);

            int subSum = copyList.get(i - 1) * copyList.get(i + 1);

            copyList.remove(i);

            recur(sum + subSum, copyList);

        }

    }
}