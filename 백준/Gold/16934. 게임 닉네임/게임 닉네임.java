import java.io.*;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringTokenizer st;

    private static HashMap<String, Integer> cntByNick;

    public static class Node {
        private Node[] child = new Node[26]; // 소문자만큼
        private boolean isEnd = false; // 문자열의 종료

        public Node[] getChild() {
            return this.child;
        }

        public boolean getIsEnd() {
            return this.isEnd;
        }
    }

    public static class Trie {
        Node root = new Node();

        public void add(char[] str) {

            Node node = root;

            for (char c : str) {
                int idx = c - 'a';
                Node[] child = node.getChild();

                if (child[idx] == null) {
                    child[idx] = new Node();
                }
                node = child[idx];
            }
            node.isEnd = true;
        }

        public boolean canPrefix(char[] candidate) {

            Node node = root;

            for (char c : candidate) {
                int idx = c - 'a';
                if (node.getChild()[idx] == null) {
                    return true;
                }
                node = node.getChild()[idx];
            }

            return false;
        }
    }

    public static void main(String[] args) throws IOException {

        cntByNick = new HashMap<>();
        Trie trie = new Trie();

        int N = Integer.parseInt(br.readLine()); // 10^5
        for (int i = 0; i < N; i++) {

            char[] str = br.readLine().toCharArray();

            cntByNick.put(String.valueOf(str), cntByNick.getOrDefault(String.valueOf(str), 0) + 1);

            // prefix 탐색
            char[] prefix = null;
            boolean isPossible = false;
            for (int len = 1; len <= str.length; len++) {
                prefix = Arrays.copyOfRange(str, 0, len);
                isPossible = trie.canPrefix(prefix);
                if (isPossible) {
                    break;
                }
            }
            trie.add(str);

            if (isPossible) { // Prefix가 존재할 경우
                bw.write(String.valueOf(prefix) + "\n");
            } else { // 본인의 닉네임을 prefix로 보유한 게 있을 경우
                int curCnt = cntByNick.get(String.valueOf(str));

                if (curCnt == 1) {
                    bw.write(String.valueOf(str) + "\n");
                } else {
                    bw.write(String.valueOf(str) + curCnt + "\n");

                }
            }
        }
        bw.flush();
    }

    private static void print(int[][] map) {
        System.out.println("-----------------");
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
