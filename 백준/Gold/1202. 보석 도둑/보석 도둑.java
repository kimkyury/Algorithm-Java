import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static StringTokenizer st;
    static int[][] gems;
    static Integer[] bag;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        gems = new int[N][2];
        bag = new Integer[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gems[i][0] = Integer.parseInt(st.nextToken());
            gems[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems, Comparator.comparingInt(o -> o[0])); // 무게 기준 오름차순
        Arrays.sort(bag);

        long sum = 0;
        int gemIndex = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Comparator.reverseOrder()); // 내림차순

        // 각 가방에 대해 가장 높은 가치의 보석을 넣음
        for (int i = 0; i < K; i++) {
            
            // 현재 가방 용량 이하의 보석들을 모두 pq에 추가
            while (gemIndex < N && gems[gemIndex][0] <= bag[i]) {
                pq.offer(gems[gemIndex][1]);
                gemIndex++;
            }

            // 현재 가방에 넣을 수 있는 보석 중 가장 가치가 큰 보석을 선택
            if (!pq.isEmpty()) {
                sum += pq.poll();
            }
        }

        bw.write(sum + "\n");
        bw.flush();
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
