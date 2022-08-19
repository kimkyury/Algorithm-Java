import java.io.*;

public class baek_11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String st = br.readLine();
        int sum = 0;

        for (int i = 0; i < n; i++)
            sum += Character.getNumericValue(st.charAt(i));
        System.out.print(sum);
    }
}
