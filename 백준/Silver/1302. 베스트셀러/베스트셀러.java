import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {

  static TreeMap<String, Integer> books;

  static BufferedWriter bw = new BufferedWriter(
    new OutputStreamWriter(System.out)
  );

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    // StringTokenizer st;
    books = new TreeMap<>();

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      String book = br.readLine();
      books.put(book, books.getOrDefault(book, 0) + 1);
    }

    int maxCnt = 0;
    String bestBook = "";
    for (String bookName : books.keySet()) {
      if (books.get(bookName) > maxCnt) {
        maxCnt = books.get(bookName);
        bestBook = bookName;
      }
    }

    bw.write(bestBook);
    bw.flush();
  }
}
