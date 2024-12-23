import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        // blue가 i j 사이 위치를 알고 싶다
        T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String pt = br.readLine();
            int len = pt.length();
            int cntByPt = len - pt.replaceAll("B", "").length();
            // pt가 반복된다

            st = new StringTokenizer(br.readLine());
            long i = Long.parseLong(st.nextToken());
            long j = Long.parseLong(st.nextToken());

            // i부터 j위치에 B가 몇개 존재하는가
            // (j - i) / pt.length 를 통해, 패턴의 반복 개수를 파악한다
            long cnt = (((j - i) + 1) / pt.length()) * cntByPt;

            // j % length, j%length를 통해서 개수의 오차를 계산한다
            if (((j - i) + 1) % pt.length() != 0) {

                int sIdx = (int) ((i - 1) % len);
                int eIdx = (int) ((j - 1) % len);

                String subPt = "";
                if (sIdx <= eIdx) {
                    subPt = pt.substring(sIdx, eIdx + 1);
                } else {
                    subPt = pt.substring(sIdx) + pt.substring(0, eIdx + 1);
                }

                cnt += subPt.length() - subPt.replaceAll("B", "").length();
            }

            bw.write("Case #" + t + ": " + cnt + "\n");
        }

        bw.flush();
    }

}
