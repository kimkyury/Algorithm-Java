import java.io.*;
import java.util.*;

public class baek_1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] point = new int[4];
        int[] distance = new int[4];

        for (int i = 0; i < 4; i++) {
            point[i] = Integer.parseInt(st.nextToken());
        }

        distance[0] = point[0]; // x to 0
        distance[1] = point[1]; // y to 0
        distance[2] = point[2] - point[0]; // x to w
        distance[3] = point[3] - point[1]; // y to h

        int minDistance = distance[0];
        for (int i = 1; i < 4; i++) {
            if (minDistance > distance[i])
                minDistance = distance[i];
        }
        System.out.print(minDistance);

    }
}
