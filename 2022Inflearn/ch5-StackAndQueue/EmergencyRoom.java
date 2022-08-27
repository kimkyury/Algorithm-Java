import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static class Patient {
        int no;
        int risk;

        Patient(int no, int risk) {
            this.no = no;
            this.risk = risk;
        }
    }

    public static int solution(int N, int M, int[] risk) {
        int answer = 0;

        Queue<Patient> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            q.offer(new Patient(i, risk[i]));
            // System.out.println("hi" + " " + i + " " + risk[i]);
        }

        while (!q.isEmpty()) {
            Patient tmp = q.poll();
            for (Patient x : q) {
                if (x.risk > tmp.risk) {
                    q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.no == M)
                    return answer;
            }
        }

        // int cnt = 0;
        // boolean isPushed;
        // Patient patient;
        // while (!q.isEmpty()) {
        // isPushed = false;
        // patient = q.poll();
        // for (int i = 0; i < N; i++) {
        // if (risk[i] > patient.risk) {
        // q.offer(patient);
        // isPushed = true;
        // break;
        // }
        // }
        // if (isPushed == false) {
        // risk[patient.no] = 0;
        // cnt++;
        // if (patient.no == M) {
        // return cnt;
        // }
        // }
        // }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] risk = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            risk[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, risk));
        return;
    }
}