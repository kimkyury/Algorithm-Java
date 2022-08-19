import java.util.*;
import java.io.*;

public class baek1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st_Sub = new StringTokenizer(br.readLine(), "-"); // '-' 을 기준으로 갖는다
        int[] tokens = new int[st_Sub.countTokens()];

        StringTokenizer st_Add;

        int cnt = 0;
        while (st_Sub.hasMoreTokens()) {
            st_Add = new StringTokenizer(st_Sub.nextToken(), "+"); // '+'를 기준으로 갖는다
            int num = Integer.parseInt(st_Add.nextToken());

            while (st_Add.hasMoreTokens()) {
                num += Integer.parseInt(st_Add.nextToken());
            }

            tokens[cnt] = num;
            cnt++;
        }

        int sum = tokens[0];
        for (int i = 1; i < tokens.length; i++) {
            sum -= tokens[i];
        }

        System.out.print(sum);
    }
}
