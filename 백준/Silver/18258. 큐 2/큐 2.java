import java.io.*;

import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M, T;
    static StringTokenizer st;

    static boolean[] isLeft;

    static List<Integer> arr;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        arr = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String command = st.nextToken();

            switch (command) {

                case "push":
                    int num = Integer.parseInt(st.nextToken());
                    push(num);
                    break;
                case "pop":
                    bw.write(pop() + "\n");
                    break;
                case "size":
                    bw.write(size() + "\n");
                    break;
                case "empty":
                    bw.write(empty() + "\n");

                    break;
                case "front":
                    bw.write(front() + "\n");
                    break;
                case "back":
                    bw.write(back() + "\n");

                    break;

            }
        }

        bw.flush();
    }

    static void push(int a) {
        arr.add(a);
    }

    static int pop() {
        if (empty() == 1) {
            return -1;
        }

        return arr.remove(0);
    }

    static int size() {
        return arr.size();
    }

    static int empty() {
        if (arr.size() == 0) {
            return 1;
        }
        return 0;
    }

    static int front() {
        if (empty() == 0) {
            return arr.get(0);
        }
        return -1;
    }

    static int back() {
        if (empty() == 0) {
            return arr.get(arr.size() - 1);
        }
        return -1;
    }
}
