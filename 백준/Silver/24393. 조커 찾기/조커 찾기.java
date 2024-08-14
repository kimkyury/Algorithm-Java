
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

import javax.print.DocFlavor.INPUT_STREAM;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int joker = 1;

        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            boolean isJokerLeft = true;
            if (joker > 13) {
                isJokerLeft = false;
                joker -= 13;
            }

            int deckLen = 0;
            boolean isOrderLeft = false;
            while (st.hasMoreTokens()) {
                int moveLen = Integer.parseInt(st.nextToken());

                // 조커가 이동할리 없을 때
                if (isOrderLeft != isJokerLeft) {
                    deckLen += moveLen;
                    isOrderLeft = !isOrderLeft;
                    continue;
                }

                // 조커가 이동할 때
                if (moveLen >= joker) {
                    joker += deckLen;
                    break;
                }

                // 조커 순서가 당겨질 때
                joker -= moveLen;
                deckLen += moveLen;
                isOrderLeft = !isOrderLeft;
            }
        }

        // 최종 조커 위치
        bw.write(String.valueOf(joker));
        bw.flush();
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