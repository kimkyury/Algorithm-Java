import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int count(int[] arr, int capacity) {

        int cnt = 1; // 한 장이 이미 있다고 생각하고 가야한다
        int tmp = 0;
        for (int x : arr) {
            if (tmp + x > capacity) {
                cnt++;
                tmp = x;
            } else
                tmp += x;
        }

        return cnt;
    }

    public static int solution(int N, int M, int[] arr) {
        int answer = 0;

        // 배열을 스트림화, Iterator을 통해서 최대값을 찾고 int형으로 반환시키
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (count(arr, mid) <= M) {
                answer = mid;
                rt = mid - 1;

            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, arr));

    }
}