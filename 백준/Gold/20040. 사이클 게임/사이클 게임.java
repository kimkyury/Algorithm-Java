import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int N;
    static long M;
    static int[] parent;

    public static void main(String[] args) throws IOException {

        // 0~ N-1 사이클이 완성되면 게임 종료

        // 한 점에서 모든 선분을 한 번씩 지나서 출발점으로 되돌아옴

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 5* 10^5
        M = Integer.parseInt(st.nextToken()); // 10^6

        parent = new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = i;
        }

        int order = 0;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            // 한 점에서 출발해서 모든 선분을 지나 출발점을 되돌아 올 수 있는가?
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());


            if (find(v1) == find(v2)) {
                order = i;
                break;
            }
            union(v1, v2);
        }

        // bw.write(Arrays.toString(search(arr)) + "");
        bw.write(order + "");
        bw.flush();

    }

    public static void union(int v1, int v2) {

        int p1 = find(v1);
        int p2 = find(v2);

        if (p1 != p2) {
            parent[p2] = p1;
        }
    }

    public static int find(int v) {

        if (parent[v] == v) {
            return v;
        }

        return parent[v] = find(parent[v]);
    }

}
