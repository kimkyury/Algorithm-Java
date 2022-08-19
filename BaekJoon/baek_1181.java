import java.io.*;
import java.util.*;

public class baek_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayList<String> word = new ArrayList<String>();

        // 단어를 입력받기
        for (int i = 0; i < n; i++) {
            word.add(br.readLine());
        }

        Collections.sort(word, new Comparator<String>() {
            public int compare(String s1, String s2) {
                if (s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        });

        System.out.println(word.get(0));
        for (int i = 1; i < word.size(); i++) {
            if (word.get(i).equals(word.get(i - 1))) {
                continue;
            }
            System.out.println(word.get(i));
        }

    }
}