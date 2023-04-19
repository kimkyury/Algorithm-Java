import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int N;
    static TreeSet<Integer> set = new TreeSet<>();
    static boolean isPassed[];

    public static int bfs(int subin, int sister) {
        int initDiff = sister - subin;
        int time = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(subin);
        boolean flag = false;
        int[] moves = new int[3];
        while (!q.isEmpty()) {
            int size = q.size();
            int target;
            for (int i = 0; i < size; i++) {
                target = q.poll();
                if (target == sister) {
                    flag = true;
                    break;
                }
                moves[0] = target - 1;
                moves[1] = target + 1;
                moves[2] = target * 2;

                boolean ishasPossibility = true;
                for (int move : moves) {
                    // 해당 거리가 목표보다 작은 곳일 때
                    // index가 넘치지 않기 위한 전처리
                    if (move >= isPassed.length || move < 0)
                        continue;

                    // 최적화를 위해 initDiff와 비교
                    if (move > sister && (move - sister) > initDiff)
                        ishasPossibility = false;

                    // 방문한 곳은 아닌지 확인
                    if (ishasPossibility && !isPassed[move]) {
                        q.offer(move);
                        isPassed[move] = true;
                    }
                }
            }

            if (flag)
                break;
            time++;
        }
        return time;
    }

    public static void main(String[] args) throws Exception {

        // N = Integer.parseInt(br.readLine());
        // 수빈이가 +1할 경우와 -1할 경우와 x2의 경우에 대하여 bfs로 간다

        st = new StringTokenizer(br.readLine());
        int subin = Integer.parseInt(st.nextToken());
        int sister = Integer.parseInt(st.nextToken());

        int answer;
        if (subin > sister) {
            answer = subin - sister;
        } else {
            isPassed = new boolean[sister * 2];
            answer = bfs(subin, sister);
        }
        bw.write(String.valueOf(answer) + " ");

        bw.flush();
    }
}
