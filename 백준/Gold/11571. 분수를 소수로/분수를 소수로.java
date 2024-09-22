import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {

            sb = new StringBuilder();

            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int denom = Integer.parseInt(st.nextToken());

            sb.append((int) num / denom + ".");
            if (num % denom == 0) {
                sb.append("(0)");
            } else {
                toDecimal(num, denom);
            }

            bw.write(sb.toString() + "\n");
        }

        bw.flush();
    }

    private static void toDecimal(int num, int denom) {

        Map<Integer, Integer> idxByNum = new HashMap<>();

        int remain = num % denom;
        int idx = 0;
        int len = -1;
        while (true) {

            // Exit: 동일한 나머지를 다시 만날 때
            if (idxByNum.containsKey(remain)) {
                len = idx - idxByNum.get(remain);
                break;
            }

            idxByNum.put(remain, idx++);

            sb.append((int) remain * 10 / denom);
            remain = (remain * 10) % denom;
        }

        sb.insert(sb.length() - len, "(").append(")");
        return;
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}