import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  private static int N, M, time;

  private static char sL, sR;
  private static String str;

  private static StringTokenizer st;

  public static void main(String[] args) throws Exception, IOException {

    /***
     * 1. str에 대한 각 문자의 좌표를 구한다
     * 2. 순서대로, sL과 sR로부터 가장 가까운 곳의 거리를 더하며, 가장 가까웠던 sL과 sR의 위치를 갱신한다
     */

    // KeyBoard 세팅
    int[][] pos = new int[26][2]; // 알파벳 별 좌표 정보 pos[alphbet][0] = x, pos[alphbet][1] = y
    String[] keyLines = {
        "qwertyuiop",
        "asdfghjkl",
        "zxcvbnm"
    };
    for (int idx = 0; idx < keyLines.length; idx++) {
      for (int i = 0; i < keyLines[idx].length(); i++) {
        char KEY = keyLines[idx].charAt(i);
        pos[KEY - 'a'][0] = i; // x
        pos[KEY - 'a'][1] = idx; // y
      }
    }

    // 한글 모음에 대해서만 매핑
    HashSet<Character> vowelEnSet = new HashSet<>(
        Arrays.asList('y', 'u', 'i', 'o', 'p', 'h', 'j', 'k', 'l', 'b', 'n', 'm'));

    st = new StringTokenizer(br.readLine());

    sL = st.nextToken().charAt(0);
    sR = st.nextToken().charAt(0);
    str = br.readLine();

    for (char c : str.toCharArray()) {
      int posX = pos[c - 'a'][0];
      int posY = pos[c - 'a'][1];

      int posLx = pos[sL - 'a'][0];
      int posLy = pos[sL - 'a'][1];
      int posRx = pos[sR - 'a'][0];
      int posRy = pos[sR - 'a'][1];

      int distanceL = Math.abs(posX - posLx) + Math.abs(posY - posLy);
      int distanceR = Math.abs(posX - posRx) + Math.abs(posY - posRy);

      boolean isVowel = vowelEnSet.contains(c);
      time += isVowel ? distanceR : distanceL; // 거리 계산

      if (isVowel)
        sR = c; // sR 갱신
      else
        sL = c; // sL 갱신

      time++; // 거리 + (KeyPress시간)1
    }

    bw.write(time + "");
    bw.flush();
  }
}
