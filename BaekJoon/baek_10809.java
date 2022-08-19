import java.io.*;

public class baek_10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] apb = new int[26];

        int len = str.length();
        for (int i = 0; i < 26; i++)
            apb[i] = -1;

        for (int i = len - 1; i >= 0; i--)
            apb[str.charAt(i) - 'a'] = i;

        for (int i = 0; i < 26; i++)
            System.out.print(apb[i] + " ");
    }
}
