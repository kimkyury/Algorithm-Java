import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static int[][] map;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static boolean[] passed;
    static int[] degree;

    static Map<String, int[]> movePos;

    public static void main(String[] args) throws IOException {

        // 알파벳: 열 (A~H), 숫자: 행 // 8(위)~1
        movePos = new HashMap<>();
        movePos.put("R", new int[] { 0, 1 });
        movePos.put("L", new int[] { 0, -1 });
        movePos.put("B", new int[] { -1, 0 });
        movePos.put("T", new int[] { 1, 0 });
        movePos.put("RT", new int[] { 1, 1 });
        movePos.put("LT", new int[] { 1, -1 });
        movePos.put("RB", new int[] { -1, 1 });
        movePos.put("LB", new int[] { -1, -1 });

        st = new StringTokenizer(br.readLine());
        String king = st.nextToken();
        String doll = st.nextToken();
        int N = Integer.parseInt(st.nextToken());
        // A4 -> 열:A, 행:4
        int kX = king.charAt(0) - 'A' + 1;
        int dX = doll.charAt(0) - 'A' + 1;

        int kY = Integer.parseInt(king.substring(1));
        int dY = Integer.parseInt(doll.substring(1));

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            int[] dir = movePos.get(command);

            int nyK = kY + dir[0];
            int nxK = kX + dir[1];

            // System.out.println("Origin y:" + kY + ", x:" + kX);
            // System.out.println("Command: " + command + ", kings y:" + nyK + ", x:" +
            // nxK);
            if (isOver(nyK, nxK)) {
                continue;
            }

            //
            if (nxK == dX && nyK == dY) {
                int nyD = dY + dir[0];
                int nxD = dX + dir[1];

                if (isOver(nyD, nxD)) {
                    continue;
                } else {
                    dY = nyD;
                    dX = nxD;
                    // System.out.println("Command: " + command + ", kings y:" + dY + ", x:" + dX);

                }
            }

            kY = nyK;
            kX = nxK;
        }

        // System.out.println("RESULT, kings y:" + kY + ", x:" + kX);

        StringBuilder sb = new StringBuilder();
        sb.append((char) (kX + 'A' - 1)).append(kY).append("\n");
        sb.append((char) (dX + 'A' - 1)).append(dY).append("\n");

        bw.write(sb.toString());
        bw.flush();
    }

    public static boolean isOver(int ny, int nx) {
        return nx < 1 || nx > 8 || ny < 1 || ny > 8;
    }
}