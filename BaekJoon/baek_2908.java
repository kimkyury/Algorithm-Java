import java.util.*;
import java.io.*;

public class baek_2908 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        String reverseA = "", reverseB = "";
        for (int i = a.length() - 1; i >= 0; i--)
            reverseA += Character.toString(a.charAt(i));
        for (int i = b.length() - 1; i >= 0; i--)
            reverseB += Character.toString(b.charAt(i));

        int answer = Integer.parseInt(reverseA);
        if (answer < Integer.parseInt(reverseB))
            answer = Integer.parseInt(reverseB);

        System.out.print(answer);
    }

}
