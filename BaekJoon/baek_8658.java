import java.io.*;

public class baek_8658 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int score, conScore;

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            score = 0;
            for (int j = 0; j < str.length(); j++) {
                conScore = 0;
                int k = j;
                while (str.charAt(k) == 'O') {
                    conScore++;
                    k++;
                    if (k >= str.length()) {
                        break;
                    }
                }
                score += conScore;
            }
            System.out.println(score);
        }
    }
}
