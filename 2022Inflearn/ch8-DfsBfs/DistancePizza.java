import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point {
    int x;
    int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Main {

    static int N, M;
    static int map[][];

    static int cntPizza = 0;
    static ArrayList<Point> pizzaList = new ArrayList<>();
    static ArrayList<Point> houseList = new ArrayList<>();

    static int finalSum = Integer.MAX_VALUE;
    static int[] combiPizza;

    // level == 선택된 피자집의 개수
    public static void DFS(int level, int s) {

        if (level == M) {
            int sum = 0;

            for (Point house : houseList) {

                int dis = Integer.MAX_VALUE;
                for (int c : combiPizza) {
                    int tmp = Math.abs(house.x - pizzaList.get(c).x) +
                            Math.abs(house.y - pizzaList.get(c).y);
                    dis = Math.min(dis, tmp);

                }
                sum += dis;
            }
            finalSum = Math.min(finalSum, sum);
            return;

        }

        for (int i = s; i < cntPizza; i++) {
            combiPizza[level] = i;
            DFS(level + 1, i + 1); // (1,2), (1,3), (1,4) ... (2, 3), (2,4) .. (3,4)가 되도록
        }

    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        combiPizza = new int[N + 1];

        // 입력과 동시에 house, pizza가게 정보 기록
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    houseList.add(new Point(i, j));
                else if (map[i][j] == 2) {
                    cntPizza++;
                    pizzaList.add(new Point(i, j));
                }
            }
        }

        // M개의 피자집의 조합을 만들기
        DFS(0, 0);

        System.out.println(finalSum);

    }

}