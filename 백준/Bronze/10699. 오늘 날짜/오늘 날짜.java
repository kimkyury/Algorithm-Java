import java.io.*;
import java.util.*;
import java.math.*;
import java.time.LocalDate;
import java.util.concurrent.Semaphore;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] heap;
    static StringBuilder sb = new StringBuilder();

    static int DIVIDE = 1000;
    static int[][] result;
    static int max = 0;

    static int[] arr;

    public static void main(String[] args) throws IOException {

        bw.write(LocalDate.now() + "");
        bw.flush();
    }


    private static void show(int[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
