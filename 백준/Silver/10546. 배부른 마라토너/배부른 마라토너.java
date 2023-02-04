import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

  static HashMap<String, Integer> names;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st;
    names = new HashMap<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String name = br.readLine();
      names.put(name, names.getOrDefault(name, 0) + 1);
    }

    for (int j = 0; j < N - 1; j++) {
      String name = br.readLine();
      if (names.containsKey(name)) names.put(name, names.get(name) - 1);
    }

    for (String name : names.keySet()) {
      if (names.get(name) >= 1) bw.write(name + "\n");
    }
    bw.flush();
  }
}
