import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    public static String solution(String condition, String input) {
        String answer = "YES";

        Queue<Character> q = new LinkedList<>();

        for (char c : condition.toCharArray())
            q.offer(c);

        for (char c : input.toCharArray()) {

            if (q.contains(c)) {
                if (c != q.poll())
                    return "NO";
            }
        }
        // Queue<Character> qCondition = new LinkedList<>();
        // Queue<Character> qInput = new LinkedList<>();

        // for (char c : condition.toCharArray())
        // qCondition.offer(c);

        // for (char c : input.toCharArray())
        // qInput.offer(c);

        // while (qInput.isEmpty() != true && qCondition.isEmpty() != true) {
        // if (qCondition.peek() == qInput.peek()) {
        // qInput.poll();
        // qCondition.poll();
        // } else {
        // qInput.poll();
        // }
        // }

        // if (qCondition.isEmpty() == false)
        // answer = "NO";

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String condition = br.readLine();
        String input = br.readLine();

        System.out.println(solution(condition, input));
        return;
    }
}