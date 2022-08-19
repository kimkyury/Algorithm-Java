import java.util.*;
import java.io.*;

public class baek_1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        double[] score = new double[n];
        for (int i = 0; i < n; i++)
            score[i] = Double.parseDouble(st.nextToken()); 

        double max = score[0];
        for (int i = 1; i < n; i++)
            if (max < score[i])
                max = score[i]; 

        double avg = 0;
        for (int i = 0; i < n; i++)
            avg += score[i] / max * 100;

        System.out.print(avg / n);
    }
}
