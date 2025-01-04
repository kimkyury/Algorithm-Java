import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;

    static boolean[] isLeft;

    public static void main(String[] args) throws IOException {

        // 빈 자리 중 번호가 가장 작은 자리에 앉기

        // 정해진 시간에 싸지방 사용

        // 1. 사용시간 순 정렬

        // 10 100 // C1 100 (1)
        // 20 50 // C2 50 (1)
        // 30 120 // C3 120 (1)
        // 60 110 // c2 110 (2)
        // 80 90 // c4 90 (1)

        // 컴퓨터 -> 시간이 겹치고 있으면 증성
        N = Integer.parseInt(br.readLine());
        int[] cntByCom = new int[N + 2];
        int[][] info = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(info, (a, b) -> a[0] - b[0]); // 오름차순

        // 종료시간pq
        PriorityQueue<int[]> pqT = new PriorityQueue<>(
                (o1, o2) -> o1[0] - o2[0]);

        // 번호 pq
        PriorityQueue<int[]> pqId = new PriorityQueue<>(
                (o1, o2) -> o1[1] - o2[1]);

        int[] firstCom = new int[] { 0, 1 };
        pqT.offer(firstCom);

        // 1. 사람 마다 반복
        int comCnt = 1;
        for (int i = 0; i < N; i++) {
            int[] cur = info[i];

            while (!pqT.isEmpty()) {

                int curCom[] = pqT.poll();
                // 현재 컴퓨터의 종료시간이 본인의 시작시간보다 크다면 그만
                if (curCom[0] > cur[0]) {
                    pqT.offer(curCom);
                    break;
                }

                pqId.offer(curCom);
            }

            if (!pqId.isEmpty()) {
                int[] minCom = pqId.poll();
                cntByCom[minCom[1]]++;
                minCom[0] = cur[1];
                pqT.offer(minCom);
            } else {
                // 없으면 새로운 거 만들기
                pqT.offer(new int[] { cur[1], ++comCnt });
                cntByCom[comCnt] = 1;
            }

        }

        bw.write(comCnt + "\n");

        int idx = 1;
        while (cntByCom[idx] != 0) {
            bw.write(cntByCom[idx++] + " ");
        }

        bw.flush();
    }

}
