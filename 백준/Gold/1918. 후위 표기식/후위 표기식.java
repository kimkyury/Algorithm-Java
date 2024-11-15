import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        // st = new StringTokenizer(br.readLine());
        // 중위, 후위, 전위 표기법
        // 중위 표기를 후위표기로 바꾸기

        // 1. 중위 표기식을 우선순위에 따라 괄호로 묶기
        // 2. 괄호 안의 연산자를 괄호의 오른족으로 옮겨주기

        // (A*(B+C)) -> q:*, l:A
        // (B+C)) -> q:*, l:AB
        //

        // 시작한 ))의 개수만큼 끝나면 갖다붙이기 + 최초 )의 위치를 기억하기

        char[] line = br.readLine().toCharArray();
        // 1. 알파벳: 즉시 add
        // 2. "(": push
        // 3. ")": stack에서 "("가 나올 때까지 pop, pop으로 나오는 연산자 (+*-/)를 add
        // 4. 연산자: stack.peek()가 line[i]보다 높은 연산자라면 스택에서 꺼냄

        Map<Character, Integer> priorityByOper = new HashMap<>();
        priorityByOper.put('+', 0);
        priorityByOper.put('-', 0);
        priorityByOper.put('*', 1);
        priorityByOper.put('/', 1);

        ArrayDeque<Character> dq = new ArrayDeque<>();
        List<Character> result = new ArrayList<>();
        for (int i = 0; i < line.length; i++) {

            // 1. 괄호를 만났다면
            if (line[i] == '(') {

                dq.push(line[i]);
            } else if (line[i] == ')') {

                while (!dq.isEmpty() && dq.peek() != '(') {
                    result.add(dq.pop());
                }
                dq.pop();
            } else if (priorityByOper.containsKey(line[i])) {

                while (!dq.isEmpty() && dq.peek() != '(') {

                    char peek = dq.peek();
                    if (priorityByOper.get(line[i]) <= priorityByOper.get(peek)) {
                        result.add(dq.pop());
                    } else {
                        break;
                    }
                }
                dq.push(line[i]);

            } else {

                // 알파벳
                result.add(line[i]);
            }
        }

        while (!dq.isEmpty()) {
            result.add(dq.pop());
        }

        for (char c : result) {
            bw.write(c);
        }
        // bw.write((map[N][M]) + ""); // 0:노랭, 1:레드
        bw.flush();
    }

    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
