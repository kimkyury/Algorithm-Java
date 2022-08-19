import java.util.*;
import java.io.*;

public class baek1080 {

    static int row, column;
    static boolean[][] m1;
    static boolean[][] m2;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        column = Integer.parseInt(st.nextToken());
        m1 = new boolean[row][column];
        m2 = new boolean[row][column];

        // m1입력받기
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                if (line.charAt(j) == '1') {
                    m1[i][j] = true;
                } else {
                    m1[i][j] = false;
                }
            }
        }
        // m2입력받기
        for (int i = 0; i < row; i++) {
            String line = br.readLine();
            for (int j = 0; j < column; j++) {
                if (line.charAt(j) == '1') {
                    m2[i][j] = true;
                } else {
                    m2[i][j] = false;
                }
            }
        }

        // 3x3미만 행렬의 예외처리
        int ans = 0;
        if (row < 3 || column < 3) {
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < column; j++) {
                    // 동일하지 않으면 -1출력
                    if (m1[i][j] != m2[i][j]) {
                        ans = -1;
                        System.out.print(ans);
                        return;
                    }
                }
            }
            // 동일하면 0 출력
            System.out.print(ans);
            return;
        }

        // 3x3이상의 행렬, 여기까지 ans=0
        for (int i = 0; i < row - 2; i++) {
            for (int j = 0; j < column - 2; j++) {
                if (m1[i][j] ^ m2[i][j]) { // 두 맵의 다른 부분을 찾았다면 (연산자 ^: 다르면 1출력)
                    ans += 1;

                    // 다른 부분(i,j)을 기준으로 3x3영역 반전시키기
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            m1[k][l] = !m1[k][l];
                        }
                    }
                }
            }
        }

        for (int k = 0; k < row; k++) {
            for (int l = 0; l < column; l++) {
                if (m1[k][l] != m2[k][l]) { // 다른 부분을 찾았다면
                    ans = -1;
                    System.out.print(ans);
                    return;
                }
            }
        }
        System.out.print(ans);
    }
}