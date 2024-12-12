import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;

    static int N, M, T;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        while (true) {

            st = new StringTokenizer(br.readLine());

            int[] arr = new int[3];

            arr[0] = Integer.parseInt(st.nextToken());
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());

            if (arr[0] == 0 && arr[0] == arr[1] && arr[1] == arr[2]) {
                break;
            }

            Arrays.sort(arr);

            if (arr[0] == arr[1] && arr[1] == arr[2]) {
                bw.write("Equilateral\n");
                continue;
            }

            if (arr[2] >= arr[1] + arr[0]) {
                bw.write("Invalid\n");
                continue;
            }

            if (arr[0] != arr[1] && arr[1] != arr[2]) {
                bw.write("Scalene\n");
                continue;
            }

            bw.write("Isosceles\n");

        }

        // bw.write(binarySearch() + "");
        bw.flush();

    }

    static boolean isOver(int y, int x) {

        if (y < 0 || x < 0 || y > 1 || x > N - 1) {
            return true;
        }
        return false;

    }
}
