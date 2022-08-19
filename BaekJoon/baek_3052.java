import java.io.*;

public class baek_3052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] num = new int[10];
        for (int i = 0; i < 10; i++)
            num[i] = Integer.parseInt(br.readLine()) % 42;

        int cnt = 0;
        Boolean[] isExist = new Boolean[43];
        for (int i = 0; i < 10; i++)
            isExist[num[i]] = true;

        for (int i = 0; i < 43; i++)
            if (isExist[i] != null)
                cnt++;

        System.out.print(cnt);
    }
}
