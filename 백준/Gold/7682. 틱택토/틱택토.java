import java.io.*;
import java.util.*;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        while (true) {
            String line = br.readLine();
            if (line.equals("end")) {
                bw.flush();
                return;
            }

            if (isValid(line)) {
                bw.write("valid\n");
            } else {
                bw.write("invalid\n");
            }

        }

    }

    public static boolean isValid(String line) {

        int xCnt = line.length() - line.replace("X", "").length();
        int oCnt = line.length() - line.replace("O", "").length();

        if (xCnt < oCnt) {
            return false;
        }

        if (Math.abs(xCnt - oCnt) > 1) {
            return false;
        }

        int xSuccCnt = 0;
        int oSuccCnt = 0;

        for (int i = 0; i < 3; i++) {

            // row
            if (line.charAt(i * 3) == line.charAt(i * 3 + 1)
                    && line.charAt(i * 3 + 1) == line.charAt(i * 3 + 2)) {

                if (line.charAt(i * 3) == 'X')
                    xSuccCnt++;
                else if (line.charAt(i * 3) == 'O')
                    oSuccCnt++;
            }

            // col
            if (line.charAt(i) == line.charAt(i + 3) &&
                    line.charAt(i + 3) == line.charAt(i + 3 * 2)) {

                if (line.charAt(i) == 'X')
                    xSuccCnt++;
                else if (line.charAt(i) == 'O')
                    oSuccCnt++;

            }
        }

        // 대각선 048 246
        if (line.charAt(4) == line.charAt(0) &&
                line.charAt(4) == line.charAt(8)) {
            if (line.charAt(4) == 'X')
                xSuccCnt++;
            else if (line.charAt(4) == 'O')
                oSuccCnt++;
        }
        if (line.charAt(4) == line.charAt(2) &&
                line.charAt(4) == line.charAt(6)) {
            if (line.charAt(4) == 'X')
                xSuccCnt++;
            else if (line.charAt(4) == 'O')
                oSuccCnt++;
        }

        if (xSuccCnt + oSuccCnt == 0 && xCnt + oCnt == 9){
            return true;
        }

        if (xSuccCnt + oSuccCnt == 0) {
            return false;
        }

        if (xSuccCnt == 1 && oSuccCnt == 1) {
            return false;
        }

        if (oSuccCnt == 1 && xCnt != oCnt) {
            return false;
        }

        if (xSuccCnt >= 1 && xCnt - oCnt != 1) {
            return false;
        }
        return true;
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