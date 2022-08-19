import java.io.*;

public class baek_2562 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[9];

        for (int i = 0; i < 9; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = arr[0];
        int index = 1;
        for (int i = 1; i < 9; i++) {
            if (max < arr[i]) {
                max = arr[i];
                index = i + 1;
            }
        }

        System.out.println(max);
        System.out.println(index);
    }
}
