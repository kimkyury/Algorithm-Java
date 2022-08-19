import java.io.*;
import java.util.*;

public class baek_10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int num;
        int max = Integer.parseInt(st.nextToken());
        int min = max;

        for (int i = 0; i < n - 1; i++) {
            num = Integer.parseInt(st.nextToken());
            if (max < num)
                max = num;
            if (min > num)
                min = num;
        }
        System.out.print(min + " " + max);
    }
}
