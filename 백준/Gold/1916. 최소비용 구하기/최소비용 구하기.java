import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Bus implements Comparable<Bus> {

  int start;
  int end;
  int distance;

  Bus(int start, int end, int distance) {
    this.start = start;
    this.end = end;
    this.distance = distance;
  }

  @Override
  public int compareTo(Bus o) {
    return this.distance - o.distance;
  }
}

class Main {

  static int N;
  static int M;
  static ArrayList<ArrayList<Bus>> buses;
  static int isPassed[];
  static int shortestDistance[];

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void solve(int startPoint, int endPoint) {
    PriorityQueue<Bus> pq = new PriorityQueue<>();

    // 본인에 대한 스타트는 distance:Zero && passed Check
    shortestDistance[startPoint] = 0;
    // isPassed[startPoint] = 1;
    // for (int i = 0; i < size; i++) {
    //   pq.offer(startCity.get(i));
    // }

    // start는 아무렇게나, end를 startPoint로 지정, distance는 0
    pq.offer(new Bus(0, startPoint, 0));
    Bus tmpBus;
    while (!pq.isEmpty()) {
      tmpBus = pq.poll();
      int tmpbusEnd = tmpBus.end;

      if (isPassed[tmpbusEnd] == 0) {
        isPassed[tmpbusEnd] = 1;

        // 버스의 종착점을 기준
        for (int i = 0; i < buses.get(tmpbusEnd).size(); i++) {
          Bus b = buses.get(tmpbusEnd).get(i);
          if (isPassed[b.end] == 0) {
            int newDistance = shortestDistance[b.start] + b.distance;
            if (shortestDistance[b.end] > newDistance) {
              shortestDistance[b.end] = newDistance;
              pq.add(new Bus(0, b.end, shortestDistance[b.end]));
            }
          }
        }
      }
    }
    //   // 한 city가 가진 bus 정보만큼 갱신시키기
    //   Bus tmpBus;
    //   int tmpBusSize = pq.size();
    //   for (int i = 0; i < tmpBusSize; i++) {
    //     tmpBus = pq.poll();
    //     int tmpbusStart = tmpBus.start;
    //     int tmpbusEnd = tmpBus.end;
    //     int tmpbusDistance = tmpBus.distance;

    //     if (shortestDistance[tmpbusEnd] == Integer.MAX_VALUE) {
    //       shortestDistance[tmpbusEnd] = tmpbusDistance;
    //     } else {
    //       int newDistance = shortestDistance[tmpbusStart] + tmpbusDistance;
    //       if (
    //         newDistance > shortestDistance[tmpbusEnd]
    //       ) shortestDistance[tmpbusEnd] = newDistance;
    //     }
    //   }

    //   int min = Integer.MAX_VALUE;
    //   int minIndex = -1;
    //   for (int i = 1; i <= N; i++) {
    //     if (shortestDistance[i] < min) {
    //       min = shortestDistance[i];
    //       minIndex = i;
    //     }
    //   }

    //   if (isPassed[minIndex] != 1) {
    //     LinkedList<Bus> tmpCity = buses.get(minIndex);
    //     for (int i = 0; i < tmpCity.size(); i++) {
    //       pq.offer(tmpCity.get(i));
    //     }
    //     isPassed[minIndex] = 1;
    //   }
    // }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    isPassed = new int[N + 1];
    shortestDistance = new int[N + 1];
    buses = new ArrayList<>();

    // Setting
    for (int i = 1; i <= N; i++) {
      shortestDistance[i] = Integer.MAX_VALUE;
    }
    for (int i = 0; i <= N; i++) {
      ArrayList<Bus> tmp = new ArrayList<>();
      buses.add(tmp);
    }

    // Save Input
    int start, end, distance;
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      start = Integer.parseInt(st.nextToken());
      end = Integer.parseInt(st.nextToken());
      distance = Integer.parseInt(st.nextToken());

      buses.get(start).add(new Bus(start, end, distance));
    }
    st = new StringTokenizer(br.readLine());
    int startPoint = Integer.parseInt(st.nextToken());
    int endPoint = Integer.parseInt(st.nextToken());

    solve(startPoint, endPoint);

    bw.write(String.valueOf(shortestDistance[endPoint]));
    bw.flush();
  }
}
