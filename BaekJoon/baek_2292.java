import java.io.*;

public class baek_2292 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 

        // 수열 1, 6, 12, 18, 24
        // a1=1,
        // a2부터는 +6임. 
        int answer;
        int number = 2;

        if (n == 1) { 
            answer = 1;
        } else { // n=1이상일 때,
            answer = 1;
            while (number <= n) {
                number += (6 * answer);
                answer++;
            }
        }
        System.out.print(answer);
    }
}