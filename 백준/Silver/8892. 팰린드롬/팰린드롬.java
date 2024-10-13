import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        // 팰린드롬을 찾는다
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());

            String[] str = new String[N];
            for (int i = 0; i < N; i++) {
                str[i] = br.readLine();
            }

            StringBuilder sb = new StringBuilder();

            String result = "";
            boolean isFound = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j)
                        continue;
                    sb = new StringBuilder(str[i]);
                    sb.append(str[j]);

                    if (isCan(sb.toString())) {

                        result = sb.toString();
                        isFound = true;
                        break;
                    }
                }

                if (isFound) {
                    break;
                }
            }

            if (isFound) {

                bw.write(result + "\n");
            } else {
                bw.write("0\n");
            }
        }

        bw.flush();
    }

    private static boolean isCan(String str) {

        int lt = 0, rt = str.length() - 1;

        boolean isCan = true;
        while (lt < rt) {

            if (str.charAt(lt) != str.charAt(rt)) {
                isCan = false;
            }

            lt++;
            rt--;
        }

        return isCan;
    }

}