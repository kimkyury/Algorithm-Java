import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] cnt;

    public static void main(String[] args) throws IOException {
        // st = new StringTokenizer(br.readLine());
        // N = Integer.parseInt(st.nextToken());
        // M = Integer.parseInt(st.nextToken());

        N = Integer.parseInt(br.readLine());

        int totalCnt = 0;
        st = new StringTokenizer(br.readLine());
        List<Integer> cntByT = new ArrayList<>();

        int idx = 0;
        while (st.hasMoreTokens()) {
            cntByT.add(Integer.parseInt(st.nextToken()));
            totalCnt += cntByT.get(idx);
            idx++;
        }

        st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int pCnt = 0;
        for (int i = 0; i < idx; i++) {

            pCnt += (cntByT.get(i) / T);

            if (cntByT.get(i) % T > 0) {
                pCnt++;
            }
        }

        bw.write(pCnt + "\n");
        bw.write((totalCnt / P) + " " + (totalCnt % P));

        // 티셔츠는 각 사이즈별 T장 묶음
        //
        // 펜은 한 종류이며 P자루씩 묶음 주문

        // 펜은 참가자 수만큼
        // 티셔츠는 N명중 부족해선 안됨

        // st = new StringTokenizer(br.readLine());

        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
