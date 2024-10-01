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
        int cntANA = 0;

        String str = br.readLine();

        // 1. 시작점 찾기
        int lt = 0;
        for (; lt < N; lt++) {
            if (str.charAt(lt) == 'A') {
                break;
            }
        }

        int cntN = 0;
        for (int i = lt; i < N; i++) {
            if (str.charAt(i) == 'N') { // 2. N이 하나 일 것
                cntN++;
            } else if (str.charAt(i) == 'A') { // 3. 시작점으로 교체
                if (cntN == 1) {
                    cntANA++;
                }
                cntN = 0;
            }
        }

        bw.write(cntANA + "");
        bw.flush();
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