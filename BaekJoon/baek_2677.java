import java.io.*;

public class baek_2677 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.valueOf(br.readLine());

        for (int i = 1; i <= 9; i++) {
            System.out.println(N + " * " + i + " = " + N * i);
        }
    }
}
