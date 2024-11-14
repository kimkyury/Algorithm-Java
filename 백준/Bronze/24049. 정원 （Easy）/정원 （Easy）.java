import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            // 왼측 정보
            map[i][0] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            // 상단 정보
            map[0][i] = Integer.parseInt(st.nextToken());
        }

        // N,M격자판
        // 동일 간격의 N,M개 꽃 피기
        // 전염인데, 왼위의 두 꽃의 색이 같다면 노란색, 다르다면 빨간색곷

        calcul();
        bw.write((map[N][M]) + ""); // 0:노랭, 1:레드
        bw.flush();
    }

    public static void calcul() {

        int[] dy = { 0, 1 }; // L, U
        int[] dx = { 1, 0 };

        // map의 i열, i행부터 탐색한다

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int nx1 = j - dx[0];
                int ny1 = i - dy[0];

                int nx2 = j - dx[1];
                int ny2 = i - dy[1];

                if (map[ny1][nx1] == map[ny2][nx2]) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = 1;
                }
            }
        }

        // show(map);
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
