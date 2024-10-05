import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 동생 수
        int S = Integer.parseInt(st.nextToken()); // 수빈 위치

        st = new StringTokenizer(br.readLine());
        int[] diff = new int[N];

        for (int i = 0; i < N; i++) {
            diff[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int gcd = diff[0];
        for (int i = 0; i < N; i++) {
            gcd = GCD(gcd, diff[i]);
        }

        // 주어진 수 중 최대공약수 구하기

        bw.write(gcd + "");
        bw.flush();
    }

    // a,b의 공약수 == b, r의 공약수
    public static int GCD(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }

        return GCD(num2, num1 % num2);
    }

    public static long comb(int N, int M) {

        long c = 1;
        for (int i = N; i > N - M; i--) { // 8, 7, 6, 5
            c *= i;
        }

        long p = 1;
        for (int i = M; i > 0; i--) {
            p *= i;
        }

        // System.out.println("c:" + c + ", p: " + p)

        return c / p;
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