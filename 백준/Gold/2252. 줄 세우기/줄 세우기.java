import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    private static final char U = '\u0000';
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;


    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 그래프를 통해, 작으면 좌측 크면 우측으로 달아넣는다
        // 다 끝났다면, 앞에서부터preorder.. 순환해서 뱉기?

        // Queue를 이용해서,

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] levels = new int[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            graph.get(A)
                 .add(B);
            levels[B]++;
        }

        // 일부 학생들의 키 비교 결과를 통해 줄 세우기
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (levels[i] == 0) {
                q.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 우선순위가 0인 것부터 차례로 뽑기
        while (!q.isEmpty()) {
            int curS = q.poll();
            sb.append(curS + " ");

            List<Integer> nextSList = graph.get(curS);
            for (Integer nextS : nextSList) {
                levels[nextS]--;
                if (levels[nextS] == 0) {
                    q.offer(nextS);
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
    }


    private void show(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                if (map[i][j] == U) {
                    System.out.print("u");
                }
                System.out.print(map[i][j]);
            }
            System.out.println("");
        }
    }
}

