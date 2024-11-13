import java.io.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        int[] posP = { 0, 0 };
        int[] posC = { 0, -1 };

        int dx = posC[0] - posP[0];
        int dy = posC[1] - posP[1];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            if (str.equals("MR")) {
                // 90도 시계회전
                int tmp = dx;
                dx = dy;
                dy = -tmp;

                posC[0] = posP[0] + dx;
                posC[1] = posP[1] + dy;
            } else if (str.equals("ML")) {
                // 반시계회전
                int tmp = dx;
                dx = -dy;
                dy = tmp;

                posC[0] = posP[0] + dx;
                posC[1] = posP[1] + dy;
            } else {
                // 함께이동
                int fx = posP[0] - posC[0];
                int fy = posP[1] - posC[1];

                int moveX = 0;
                int moveY = 0;

                if (str.equals("W")) {
                    moveX = fx;
                    moveY = fy;
                } else if (str.equals("S")) {
                    moveX = -fx;
                    moveY = -fy;
                } else if (str.equals("A")) {
                    moveX = -fy;
                    moveY = fx;
                } else if (str.equals("D")) {
                    moveX = fy;
                    moveY = -fx;
                }

                posP[0] += moveX;
                posP[1] += moveY;
                posC[0] += moveX;
                posC[1] += moveY;
            }

            bw.write(posP[0] + " " + posP[1] + " " + posC[0] + " " + posC[1] + "\n");
        }

        bw.flush();
    }
}
