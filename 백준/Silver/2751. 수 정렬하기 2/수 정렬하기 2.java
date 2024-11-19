import java.io.*;
import java.util.*;
import java.math.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N, M;

    static int[] heap;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 1. 최대힙을 구성한다
        // 2. 최대힙의 root를 꺼내 뒤로 넣어 오름차순 정렬을 완성시킨다
        sort(arr);

        for (int i = 1; i <= N; i++) {
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb.toString());
        bw.flush();
    }

    private static void sort(int[] arr) {

        int size = arr.length - 1;

        if (size < 2) {
            return;
        }

        // 자식이 존재하는 최하위 부모노드(서브트리)부터 살펴본다
        int pIdx = N / 2;
        for (int i = pIdx; i > 0; i--) { // 위로 올라간다
            heapify(arr, i, size);
        }

        // 정렬하기
        for (int i = size; i > 1; i--) {

            swap(arr, 1, i); // maxHeap을 만족하도록
            heapify(arr, 1, i - 1);
        }
    }

    private static void swap(int[] arr, int i, int j) {

        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static void heapify(int[] arr, int pIdx, int limitIdx) {
        int lIdx = pIdx * 2;
        int rIdx = pIdx * 2 + 1;

        int maxIdx = pIdx;
        // 좌자식이 더 큰값이라면
        if (lIdx <= limitIdx && arr[maxIdx] < arr[lIdx]) {
            maxIdx = lIdx;
        }

        // 우자식이 더 큰값이라면
        if (rIdx <= limitIdx && arr[maxIdx] < arr[rIdx]) {
            maxIdx = rIdx;
        }

        // 더 큰 값을 발견한 거라면
        if (pIdx != maxIdx) {
            swap(arr, maxIdx, pIdx); // arr 원소 바꾸기
            heapify(arr, maxIdx, limitIdx); // 바뀐 원소에 대한 서브트리 검사
        }
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
