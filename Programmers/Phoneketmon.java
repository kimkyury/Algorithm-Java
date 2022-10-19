import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {

    public static int solution(int[] nums) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            hash.put(nums[i], i);
        }

        if (hash.size() > length / 2) {
            return length / 2;
        } else {
            return hash.size();
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = { 3, 3, 3, 2, 2, 4 };
        int answer = solution(arr);

        System.out.println(answer);

    }

}