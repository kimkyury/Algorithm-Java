import java.io.*;
import java.util.*;

public class baek_1259 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<String>();
        String str;

        while (true) {
            str = br.readLine();
            if (str.equals(String.valueOf('0'))) {
                break;
            } else {
                strings.add(str);
            }
        }

        String str2;
        for (int i = 0; i < strings.size(); i++) {
            str2 = strings.get(i);
            str = "";
            for (int j = strings.get(i).length() - 1; j >= 0; j--) {
                str += strings.get(i).charAt(j);
            }
            if (str2.equals(str)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

    }
}
