import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point> {
    public int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {

        // 만약, 현재 객체의 x좌표가 동일하다면 y좌표를 비교하겠다
        if (this.x == o.x) {
            return this.y - o.y;
        }

        // 기본적으로, x의 좌표가
        return this.x - o.x;
    }

}

public class Main {

    public static int[][] solution(int N, int points[][]) {

        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i < N - 1; i++) {
        // for (int j = 0; j < N - 1 - i; j++) {
        // int tmpP[] = new int[2];
        // if (points[j][0] > points[j + 1][0]) {
        // tmpP[0] = points[j][0];
        // tmpP[1] = points[j][1];

        // points[j][0] = points[j + 1][0];
        // points[j][1] = points[j + 1][1];

        // points[j + 1][0] = tmpP[0];
        // points[j + 1][1] = tmpP[1];

        // } else if (points[j][0] == points[j + 1][0]) {
        // if (points[j][1] > points[j + 1][1]) {
        // tmpP[0] = points[j][0];
        // tmpP[1] = points[j][1];

        // points[j][0] = points[j + 1][0];
        // points[j][1] = points[j + 1][1];

        // points[j + 1][0] = tmpP[0];
        // points[j + 1][1] = tmpP[1];
        // }
        // }
        // }
        // }

        return points;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        ArrayList<Point> arr = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new Point(x, y));
        }

        Collections.sort(arr);

        for (Point p : arr) {
            System.out.println(p.x + " " + p.y);
        }

    }
}