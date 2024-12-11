import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(binarySearch() + "");
        bw.flush();

    }

    public static int binarySearch() {

        // 수열을 순회하며 결과 배열을 관리한다
        // arr의 각 원소 num에 대하여 다음을 수행한다
        // rwsult가 비어있거나, result의 마지막 원소보다 arr[i]이 더 크다면

        List<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (result.isEmpty() || result.get(result.size() - 1) < num) {
                // 큰값을 넣는다
                result.add(num);
            } else {
                // 더 작은 값이라면 대체시켜버린다

                // num이 들어갈만한 위치를 찾는다
                int idx = Collections.binarySearch(result, num);
                // 위치가 없다면
                if (idx < 0) {
                    // index를
                    idx = -(idx + 1);
                }

                // 교체한다. 더 작은 값을 넣어두면 더 긴 증가 수열을 만들 수 있으니까.
                // 2,5 -> 2, 3으로.
                result.set(idx, num);
            }
        }

        return result.size();
    }

    // public static void calcul() {

    // for (int i = 1; i <= N; i++) {
    // for (int j = 1; j <= N; j++) {
    // if (arr[i - 1] < arr[j - 1]) {
    // // i번쨰보다 j가 더 크다면
    // lis[i][j] = lis[i - 1][j - 1] + 1;
    // } else {
    // lis[i][j] = lis[i - 1][j] > lis[i][j - 1] ? lis[i - 1][j] : lis[i][j - 1];
    // }
    // }
    // }

    // }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
