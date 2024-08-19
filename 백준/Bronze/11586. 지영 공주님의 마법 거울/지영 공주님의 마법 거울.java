
import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    private static int N, K;

    public static void main(String[] args) throws IOException {

        // 2 -> 좌우 반전, 3 -> 상하 반전

        int N = Integer.parseInt(br.readLine());

        char[][] arr = new char[N][N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        int K = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        switch (K) {
            case 3:
                // 상하
                for (int i = N - 1; i >= 0; i--) {
                    sb.append(new String(arr[i]));
                    sb.append("\n");
                }
                break;
            case 2: {
                // 좌우
                Arrays.stream(arr).map(row -> new StringBuilder(new String(row)).reverse().toString())
                        .forEach((row) -> {
                            sb.append(row);
                            sb.append("\n");
                        });
                break;
            }
            case 1: {
                for (int i = 0; i < N; i++) {
                    sb.append(new String(arr[i]));
                    sb.append("\n");
                }
            }
        }

        bw.write(sb.toString());
        bw.flush();
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