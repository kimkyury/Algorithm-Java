
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static StringTokenizer st;
    private StringBuilder sb;

    public static void main(String[] args) throws IOException {

        // 단어 최대 길이: 100, 최대 개수: 100

        int T = Integer.parseInt(br.readLine());

        List<String> words;
        for (int i = 0; i < T; i++) {

            words = new ArrayList<>();
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens()) {
                words.add(st.nextToken());
            }

            bw.write(run(words) + "\n");
            // bw.write(run(line).replaceAll(" ", " ").trim() + "\n");
        }

        bw.flush();

    }

    public static String run(List<String> words) throws IOException {

        String nextLine;
        while (true) {
            nextLine = br.readLine();
            if (nextLine.equals("what does the fox say?")) {
                return words.stream().collect(Collectors.joining(" "));
            }

            st = new StringTokenizer(nextLine);
            st.nextToken();
            st.nextToken();

            String removeWord = st.nextToken();
            words.removeIf(word -> word.equals(removeWord));
        }

    }

    public static String run(String line) throws IOException {

        String nextLine;
        while (true) {
            nextLine = br.readLine();
            if (nextLine.equals("what does the fox say?")) {
                return line;
            }

            st = new StringTokenizer(nextLine);
            st.nextToken();
            st.nextToken();

            String removeWord = st.nextToken();
            line = line.replaceAll(removeWord, "");
        }

    }
}