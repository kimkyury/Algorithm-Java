
import java.io.*;
import java.util.*;

public class baek2839 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        if (n % 5 == 0) {
            System.out.print(n / 5);
        }

        else if ((n - 3) % 5 == 0) {
            System.out.print((n - 3) / 5 + 1);
        }

        else if (n > 5 && (n - 6) % 5 == 0) {
            System.out.print((n - 6) / 5 + 2);
        }

        else if (n > 8 && (n - 9) % 5 == 0) {
            System.out.print((n - 9) / 5 + 3);
        }

        else if (n > 11 && (n - 12) % 5 == 0) {
            System.out.print((n - 12) / 5 + 4);
        }

        else {
            System.out.print(-1);
        }
    }
}
