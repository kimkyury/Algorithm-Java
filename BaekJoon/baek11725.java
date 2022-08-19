import java.util.*;
import java.io.*;

public class baek11725 {
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>>();
    static int[] parant;

    public static void main(String[] args) throws IOException {
        // 루트없는 트리가 주어진다
        // 트리의 루트를 1이라고 정했을 때, 각 노드의 부모를 구하라
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 노드의 입력개수 입력받기
        int N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1];
        parant = new int[N + 1];

        // 입력받기 전, 트리를 저장하기 위한 arr의 초기 크기설정을 해주자.
        for (int i = 0; i <= N; i++) {
            // arr의 인덱스값은 0~7이 존재한다.
            arr.add(new ArrayList<Integer>());
        }

        // n-1개의 트리상 연결된 두 정점 입력받기
        // 연결 정보를 arr에 저장하자.
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            // 해당 연결 정보를 arr에 넣었다 (이 때, 인덱스값은 0부터 시작하고 입력값은 1부터 시작하므로 이를 처리 후 삽입한다.)
            arr.get(first).add(second);
            arr.get(second).add(first);
        }

        // 각 노드의 방문여부에 따른 탐색함수 실행
        for (int i = 1; i <= N; i++) {
            if (!visit[i])
                dfs(i);
        }

        for (int i = 2; i <= N; i++) {
            System.out.println(parant[i]);
        }

    }

    // n-1개의 줄에, '각 노드의 부모 노드 번호'를 2번 노드부터 순서대로 출력
    static void dfs(int num) {

        if (visit[num] == true) {
            return;
        }
        visit[num] = true;
        for (int i = 0; i < arr.get(num).size(); i++) {
            if (!visit[arr.get(num).get(i)]) {
                parant[arr.get(num).get(i)] = num;
                dfs(arr.get(num).get(i));
            }
        }
    }
}