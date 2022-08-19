import java.util.*;
import java.io.*;

//Comparable 인터페이스를 가진 클래스, Schedule를 만듦
class Schedule implements Comparable<Schedule> {
    int x;
    int y;

    public Schedule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 오버라이딩을 통해 [회의 종료시간의 오름차순]으로 sort시킨다
    public int compareTo(Schedule sc) {

        // 리턴값이 0혹은 -1이면 자리바꿈을 하고, 양수면 자리바꿈을 수행하는 integer.compare함수의 원형을 응용
        if (y == sc.y) {
            // 회의간 종료시간이 동일하면, 시작시간을 기준으로 오름차순 정렬한다
            return (x < sc.x) ? -1 : ((x == sc.x) ? 0 : 1); // Integer.compare(x, sc.x)와 동일
        }
        return (y < sc.y) ? -1 : ((y == sc.y) ? 0 : 1);
    }
}

public class baek1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int cnt = 0;

        Schedule[] schedules = new Schedule[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            schedules[i] = new Schedule(x, y);
        }

        // 회의 종료 시간을 기준으로 sort시킴 (Schedule의 compareTo오버라이딩을 통해)
        Arrays.sort(schedules);

        // 회의가 몇 개인지 세보자, 0과 같거나 크기만 하면 되지.
        int end = 0;
        for (int i = 0; i < n; i++) {
            if (schedules[i].x >= end) {
                end = schedules[i].y;
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}