import java.io.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static long N, M, T;
    static StringTokenizer st;
    static long max = 0;
    static long[] dp;

    public static void main(String[] args) throws IOException {

        int ham = 2001;
        int drink = 2001;
        for (int i = 0; i < 3; i++) {
            ham = Math.min(ham, Integer.parseInt(br.readLine()));
        }
        for (int i = 0; i < 2; i++) {
            drink = Math.min(drink, Integer.parseInt(br.readLine()));
        }

        bw.write((ham + drink - 50) + "");
        bw.flush();
    }

}
