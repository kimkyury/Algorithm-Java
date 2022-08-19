import java.io.*;

public class baek_2577 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int multiplication = 1;
        for (int i = 0; i < 3; i++) {
            multiplication *= Integer.parseInt(br.readLine());
        }

        int[] numberCnt = new int[10];

        String multiStr = String.valueOf(multiplication);
        int len = multiStr.length();

        for (int i = 0; i < len; i++) {
            switch (Character.getNumericValue(multiStr.charAt(i))) {
            case 0:
                numberCnt[0]++;
                continue;
            case 1:
                numberCnt[1]++;
                continue;
            case 2:
                numberCnt[2]++;
                continue;
            case 3:
                numberCnt[3]++;
                continue;
            case 4:
                numberCnt[4]++;
                continue;
            case 5:
                numberCnt[5]++;
                continue;
            case 6:
                numberCnt[6]++;
                continue;
            case 7:
                numberCnt[7]++;
                continue;
            case 8:
                numberCnt[8]++;
                continue;
            case 9:
                numberCnt[9]++;
                continue;
            }
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(numberCnt[i]);
        }

    }

}
