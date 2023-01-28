import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Cost {

  int v1;
  int v2;
  int cost;

  Cost(int v1, int v2, int cost) {
    this.v1 = v1;
    this.v2 = v2;
    this.cost = cost;
  }
}

class Main {

  static int N;
  static int M;
  static int K;
  static Cost[] costs;
  static int[] parent;
  // static int cntPass;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static int solve() {
    int result = 0;

    // cost기준 오름차 정렬
    Arrays.sort(costs, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

    // 각 원소가 이미 그룹에 속하는 것은 아닌지 체크
    // 발전소와 연결될 필요가 없음을 넣어야 함

    for (int i = 0; i < M; i++) {
      int parentV1 = find(costs[i].v1);
      int parentV2 = find(costs[i].v2);
      // if (cntPass == N) return result;
      // 소속확인이 되지 않을 때만 +
      if (parentV1 != parentV2) {
        // 결합시켜주기
        union(costs[i].v1, costs[i].v2);
        result += costs[i].cost;
        // System.out.println("------------");
        // for (int num : parent) {
        //   System.out.print(num + " ");
        // }
        // System.out.print("\n---------------");
      }
    }

    return result;
  }

  public static void union(int v1, int v2) {
    // 최종 부모정보 받아옴
    int parentV1 = find(v1);
    int parentV2 = find(v2);

    // 이전에 연결되어있던 것들도 동시에 부모정보를 갱신시켜주기

    if (parentV1 != parentV2) {
      if (parentV1 < parentV2) {
        parent[v2] = parentV1;

        ArrayList<Integer> tmp = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
          if (parent[i] == parentV2) {
            parent[i] = parentV1;
          }
        }
      } else {
        parent[v1] = parentV2;
        for (int i = 1; i <= N; i++) {
          if (parent[i] == parentV1) {
            parent[i] = parentV2;
          }
        }
      }
    }
  }

  public static int find(int v1) {
    if (parent[v1] == v1) return v1;

    return parent[v1] = find(parent[v1]);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // 도시의수 9
    M = Integer.parseInt(st.nextToken()); //케이블 수 14
    K = Integer.parseInt(st.nextToken()); // 발전소 수 3

    costs = new Cost[M]; // cable INFO
    parent = new int[N + 1];
    //init setting parent
    for (int i = 1; i <= N; i++) {
      parent[i] = i;
    }

    int[] powerPlant = new int[K];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < K; i++) {
      powerPlant[i] = Integer.parseInt(st.nextToken());
    }

    // 발전소는 이미 같은 집합인 것으로 체크해야한다
    for (int i = 0; i < K - 1; i++) {
      union(powerPlant[i], powerPlant[i + 1]); // 1, 2, 9  is same Set
    }
    // for (int i = 1; i <= N; i++) {
    //   System.out.println("정보:" + parent[i]);
    // }

    int u, v, w;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      u = Integer.parseInt(st.nextToken()); //v1
      v = Integer.parseInt(st.nextToken()); //v2
      w = Integer.parseInt(st.nextToken()); // 비용

      costs[i] = new Cost(u, v, w);
    }

    bw.write(String.valueOf(solve()));
    bw.flush();
  }
}
