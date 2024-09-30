import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 3 <=, start&End = A, N은 1개

        int N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i <= N - 3; i++) {
            for (int j = i + 3; j <= N; j++) {
                String subStr = str.substring(i, j);
                if (confirm(subStr)) {
                    cnt++;
                }
            }
        }

        bw.write(cnt + "");
        bw.flush();
    }

    public static boolean confirm(String str) {

        if (!str.startsWith("A") || !str.endsWith("A")) {
            return false;
        }

        if (str.length() - str.replaceAll("A", "").length() != 2) {
            return false;
        }

        if (!(str.length() - str.replaceAll("N", "").length() == 1)) {
            return false;
        }

        return true;
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