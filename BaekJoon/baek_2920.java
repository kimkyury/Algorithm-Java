import java.io.*;
import java.util.*;

public class baek_2920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int orderCnt = 0;
        int note;
        for (int i = 1; i <= 8; i++) {
            note = Integer.parseInt(st.nextToken());
            if (note == i)
                orderCnt++;
            else if (note == (9 - i))
                orderCnt--;
            else
                break;
        }

        if (orderCnt == 8)
            System.out.print("ascending");
        else if (orderCnt == -8)
            System.out.print("descending");
        else
            System.out.print("mixed");
    }
}