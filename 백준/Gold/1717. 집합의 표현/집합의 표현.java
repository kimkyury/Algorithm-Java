
import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int[] parent;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
        }

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int cal = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // a, b 집합 합치기
            if (cal == 0) {
                union(a, b);
            } else {
                if (find(a) == find(b)) {
                    bw.write("YES\n");
                } else {
                    bw.write("NO\n");
                }
            }
        }

        bw.flush();
    }

    public static void union(int a, int b) {

        int parentA = find(a);
        int parentB = find(b);

        if (parentA > parentB) {
            parent[parentA] = parentB; // 1 3 -> 1 1
        } else {
            parent[parentB] = parentA;
        }
    }

    public static int find(int a) {

        if (parent[a] == a) {
            return a;
        }

        return parent[a] = find(parent[a]);
    }

    public static void show(boolean[][] arr) {
        System.out.println("------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {

                if (arr[i][j]) {
                    System.out.print(1 + " ");
                } else {
                    System.out.print(0 + " ");
                }
            }
            System.out.println("");
        }
    }
}