import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static int N, M, time;

  private static char sL, sR;
  private static String str;

  private static StringTokenizer st;

  static class Candidate {
    private int no; // 학생번호
    private int cnt; // 추천 수
    private int order; // 추천 순서

    Candidate(int no, int cnt, int order) {
      this.no = no;
      this.cnt = cnt;
      this.order = order;
    }

    public void addCount() {
      this.cnt++;
    }

    public void initCount() {
      this.cnt = 0;
    }

    public void setOrder(int order) {
      this.order = order;
    }

    public int getNo() {
      return no;
    }
  }

  public static void main(String[] args) throws Exception, IOException {

    /*
     * 추천을 한다 -> 사진틀에 게시된다
     * 빈 사진이 없다 -> 가장 적은 추천 학생의 사진을 삭제 후, 새로 개시한다
     * 최저추천자 >=2 인 경우, 오래된 순으로 삭제한다
     * 동일 학생에 대해서는 추천횟수만 증가시킨다
     * 삭제된 경우, 추천횟수 = 0
     * 
     * output: 최종 후보자
     */

    N = Integer.parseInt(br.readLine()); // <=20
    M = Integer.parseInt(br.readLine()); // <=10^3

    Candidate[] candidates = new Candidate[101];
    PriorityQueue<Candidate> pq = new PriorityQueue<>((a, b) -> {
      if (a.cnt == b.cnt)
        return a.order - b.order;
      return a.cnt - b.cnt;
    });

    int order = 0;
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {

      int curIdx = Integer.parseInt(st.nextToken());
      // 1. 신규 추천자인 경우
      if (candidates[curIdx] == null) {
        candidates[curIdx] = new Candidate(curIdx, 0, -1);
      }
      candidates[curIdx].addCount();

      if (pq.contains(candidates[curIdx])) {
        // 2. 사진틀에 이미 등록된 경우
        // 2-1. 추천수 ++, 정렬을 위한 재 삽입
        pq.remove(candidates[curIdx]);
        pq.offer(candidates[curIdx]);
      } else if (pq.size() < N) {
        // 3. 사진틀에 없고, 아직 사진틀이 여유가 있는 경우
        // 3.1 신규 후보자 등록
        candidates[curIdx].setOrder(order++);
        pq.offer(candidates[curIdx]);
      } else if (pq.size() >= N) {
        // 4. 사진틀에 없고, 사진틀이 꽉 찬 경우
        // 4.1. 기존 후보 삭제(poll) 및 추천 수 초기화
        Candidate removeTgt = pq.poll();
        removeTgt.initCount();
        // 4.2. 신규 후보자 등록
        candidates[curIdx].setOrder(order++);
        pq.offer(candidates[curIdx]);
      }
    }

    // 최종 후보자들에 대하여, no순으로 정렬 및 출력
    // 그래 갤러리 수보다 적을 수도 잇겟지!!!!!!!!!!
    ArrayList<Integer> result = new ArrayList<>();
    while (!pq.isEmpty()) {
      result.add(pq.poll().getNo());
    }

    Collections.sort(result);

    for (int no : result) {
      bw.write(no + " ");
    }

    bw.flush();
  }

  // 2
  // 11
  // 1 2 2 2 3 3 1 1 1 3 3
  // 2(3) 1(3)
}
