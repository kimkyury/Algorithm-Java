import java.io.*;
import java.util.*;

public class Main {

    static StringTokenizer st;
    static Map<String, String> teamByName;
    static Map<String, List<String>> nameListByTeam;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int N, M;

    public static void main(String[] args) throws IOException {

        // gCnt, winCnt (Z% (소수점버림))
        // 최소 몇 번을 더 해야 Z가 변하는가?

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        teamByName = new HashMap<>();
        nameListByTeam = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            List<String> nameList = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                String name = br.readLine();
                nameList.add(name);
                teamByName.put(name, team);
            }

            Collections.sort(nameList);
            nameListByTeam.put(team, nameList);
        }

        for (int i = 0; i < M; i++) {

            String quiz = br.readLine();

            int sign = Integer.parseInt(br.readLine());
            if (sign == 0) {
                // 팀 이름에 대한 이름 출력
                for (String name : nameListByTeam.get(quiz)) {
                    bw.write(name + "\n");
                }
            } else {
                bw.write(teamByName.get(quiz) + "\n");
            }
        }

        // bw.write(result + "");
        bw.flush();
    }

}
