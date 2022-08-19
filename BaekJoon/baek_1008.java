import java.io.*;
import java.util.*;

public class baek_1008 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        float a = Integer.parseInt(st.nextToken());
        float b = Integer.parseInt(st.nextToken());

        System.out.print((a / b));
    }
}