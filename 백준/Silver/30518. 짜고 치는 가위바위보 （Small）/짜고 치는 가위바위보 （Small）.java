import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] arr;
    static String smallant;
    static int count;

    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {

        // lighter가 이긴 뒤, 직후 비기면 안 된다

        // R:바위, P:보, S:가위
        // 0:짐, 1:이김, 2:비김
        // sm: PSPSPPRS // 보가보가보보바가 // SSLSL-LL
        // li: RPSPSPPR // 바보가보가보보바
        // 전체경우의 수 - {L- 인 경우}

        // sm:PP // 보보 // S-
        // li:RP // 바보

        // 1. 제거할 문자열 자리를 택한다
        // 2. 제거한 후 합친 결과, 이긴 결과가 (L-)이 존재하면 카운팅하지 않는다?
        // 3. 제거하는데, 이미 불가능한(L-)존재함으로 판명난 곳을 선택한다면 백트랙킹

        char start = br.readLine().charAt(0);
        smallant = br.readLine();
        count = 0;

        perm(start, smallant, "", 0);

        bw.write(count + "");
        bw.flush();

    }

    static void perm(char start, String smallant, String cur, int tIdx) {
        if (tIdx == smallant.length()) {

            if (can(start, cur.toString())) {
                count = (count + 1) % mod;
            }
            return;
        }

        // 포함하지 않을 때
        perm(start, smallant, cur, tIdx + 1);

        perm(start, smallant, cur + smallant.charAt(tIdx), tIdx + 1);
    }

    static boolean can(char start, String smallant) {

        if (smallant.isEmpty()) {
            return false;
        }

        char preL = start;
        for (int i = 0; i < smallant.length(); i++) {
            // 현재 선택 정보를 탐색

            char curS = smallant.charAt(i);
            int result = getResult(preL, curS);

            // L- 인 경우 무효임
            if (result == 1 && i + 1 < smallant.length()) {
                if (getResult(curS, smallant.charAt(i + 1)) == 0) {
                    return false;
                }
            }
            preL = curS; // L 따라쟁이
        }

        return true;
    }

    static int getResult(char lighter, char smallant) {

        if (smallant == lighter) {
            return 0;
        }

        if (lighter == 'R' && smallant == 'S') {
            return 1;
        }
        if (lighter == 'P' && smallant == 'R') {
            return 1;
        }
        if (lighter == 'S' && smallant == 'P') {
            return 1;
        }

        return -1;
    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
