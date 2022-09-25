import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {

    // 말을 배치할 수 있는 수를 리턴, 좌표배열과 거리를 파라미터로 함
    public static int count(int[] arr, int dist) {
        int cnt = 1;
        int ep = arr[0]; // End Position

        for (int i = 1; i < arr.length; i++) { // 좌표 순환
            // 바로 직전에 배치한 좌표와의 거리를 본다
            // if, (현재지점과 마지막 지점 사이의 거리가 dist보다 크다면)
            if (arr[i] - ep >= dist) {
                cnt++;
                ep = arr[i];
            }
        }

        return cnt;
    }

    public static int solution(int N, int C, int[] arr) {
        int answer = -1;

        // 1. 마굿간 좌표 정렬
        Arrays.sort(arr);

        // 2. ㅁ
        int lt = 1;
        int rt = arr[N - 1];

        // 이분탐색
        while (lt <= rt) {

            // 가장 가깝게 있는 두 말 사이의 거리를 예상해본다
            int mid = (lt + rt) / 2;

            // 해당 좌표들사이에 mid값으로 배치할 수 있는 말의 개수가, 이상이 된다면 Distance를 높인다
            if (count(arr, mid) >= C) {
                answer = mid;
                lt = mid + 1;
            } else // mid값으로 배치할 수 있는 말의 개수가, 미만이 된다면 distance를 줄인다
                   // 간격이 좁아야 말의 배치 개수가 늘어날 테니까
                rt = mid - 1;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] poss = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            poss[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, C, poss));

    }
}