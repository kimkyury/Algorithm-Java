
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 임의의 부분합이 M이 되는 경우의 수 구하기, Window

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int caseCnt = 0;
        for (int i = 0; i < N; i++) {
            int sIdx = i;
            caseCnt += countSumCasesM(arr, sIdx, M);
        }
        bw.write(String.valueOf(caseCnt));
        bw.flush();
    }

    public static int countSumCasesM(int[] arr, int sIdx, long M) {

        int cnt = 0;
        long subSub = 0;
        for (int i = sIdx; i < arr.length; i++) {

            if (subSub > M) {
                return cnt;
            }

            subSub += arr[i];
            if (subSub == M) {
                cnt++;
            }
        }

        return cnt;
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