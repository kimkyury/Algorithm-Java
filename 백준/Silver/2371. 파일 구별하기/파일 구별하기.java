import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static int[] tree, arr;

    public static void main(String[] args) throws IOException {

        // size < K -> 0을 붙여 총 길이 K로 만들기
        // 모든 파일들이 구분되는 최소 K 구하기

        N = Integer.parseInt(br.readLine());

        String[][] inputs = new String[N][];
        for (int i = 0; i < N; i++) {
            inputs[i] = br.readLine().split(" ");
        }

        int idx = 1;
        while (true) {

            Set<String> set = new HashSet<>();

            int skipCnt = 0;
            for (String[] input : inputs) {
                if (input.length < idx) {
                    skipCnt++;
                    continue;
                }

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < idx; i++) {
                    sb.append(input[i] + " ");
                }

                set.add(sb.toString());
            }

            if (set.size() + skipCnt == N) {
                break;
            }
            idx++;
        }

        bw.write((idx) + "");
        bw.flush();
    }

}
