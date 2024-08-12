
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 배열 A에서 N번째 큰 값
        // 각 케이스마다 10개

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {

            Queue<Integer> q = new PriorityQueue<>(
                    (o1, o2) -> {
                        return o2 - o1;
                    });

            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                q.offer(Integer.parseInt(st.nextToken()));
            }

            q.poll();
            q.poll();
            bw.write(String.valueOf(q.poll()) + "\n");
        }
        bw.flush();
    }

    public static Long getThirdBigValue(int[] input) {

        return -1L;
    }

    public static int findNotPassedNeuron(Set<Integer> passedNeuron, int N) {

        for (int i = 1; i <= N; i++) {
            if (!passedNeuron.contains(i)) {
                return i;
            }
        }

        return 0;
    }

    public static void show(boolean[][] arr) {

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }
}