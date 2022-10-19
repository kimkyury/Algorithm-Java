import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int v1;
    int v2;
    int weight;

    Edge(int v1, int v2, int weight) {
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

class Main {

    public static void solution(String[] babbling) {

        int cnt = 0;
        String[] availWords = { "aya", "ye", "woo", "ma" };
        boolean isOverap = false;

        for (String b : babbling) {

            isOverap = false;
            for (int i = 0; i < 4; i++) {
                String doubleAvailWords = availWords[i] + availWords[i];

                if (b.contains(doubleAvailWords)) {
                    isOverap = true;
                    break;
                }

                if (b.contains(availWords[i]))
                    b = b.replace(availWords[i], "");
            }

            if (isOverap == true)
                continue;

            if (b.length() == 0)
                cnt++;

        }
        System.out.println(cnt);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String[] babbling = { "aya", "yee", "u", "maa" };

        solution(babbling);

    }

}