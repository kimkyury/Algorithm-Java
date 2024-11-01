import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, K;
    static StringTokenizer st;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(insert(arr) + "");
        bw.flush();
    }

    public static int insert(int[] arr) {

        int[] plug = new int[N];

        int idx = 0;
        int useCnt = 0;
        int pullCnt = 0;
        for (int i = 0; i < K; i++) {

            // 1. 이미 꽂혀있다면 패스
            boolean exist = false;
            for (int j = 0; j < plug.length; j++) {
                if (plug[j] == arr[i]) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                continue;
            }

            // 2. 여유공간이 있다면 사용하기
            if (useCnt < N) {
                plug[idx++] = arr[i];
                useCnt++;
                continue;
            }

            // 3. 대체할 자리 찾기
            int tgtIdx = findTgt(plug, i + 1);
            plug[tgtIdx] = arr[i];
            pullCnt++;
        }
        return pullCnt;
    }

    public static int findTgt(int[] plug, int arrIdx) {

        boolean[] appear = new boolean[plug.length];
        List<Integer> appearList = new ArrayList<>();
        for (int i = arrIdx; i < arr.length; i++) {
            for (int j = 0; j < plug.length; j++) {

                if (arr[i] == plug[j] && !appear[j]) {
                    appear[j] = true; // 해당 플러그가 미래에 존재합니다
                    appearList.add(j); // 등장 순서
                }
            }
        }

        // 미래에 사용하지 않는다면 당장 뽑기
        for (int i = 0; i < appear.length; i++) {
            if (!appear[i]) {
                return i;
            }
        }

        // 기어코 다 나타날 예정이라면,
        return appearList.get(N - 1);
    }

    public static void print(int map[][]) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
