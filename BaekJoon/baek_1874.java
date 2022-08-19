import java.io.*;
import java.util.*;

public class baek_1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int[] sortArr = new int[n];
        ArrayList<Character> pop = new ArrayList<Character>();

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine()); // 입력된 수열
        }

        int indexArr = 0;
        int indexSA = 1;

        int i = 1;
        Loop1: while (i <= n) {
            sortArr[indexSA - 1] = i;

            while (sortArr[indexSA - 1] == arr[indexArr]) {
                indexSA--;
                pop.add('-');
                indexArr++;
                if (indexSA == 0 && i == n) {
                    break Loop1;
                } else if (indexSA == 0) {
                    break;
                }
            }
            pop.add('+');
            i++;
            indexSA++;
        }

        for (int j = 0; j < pop.size(); j++) {
            System.out.print(pop.get(j));

        }
        // 스택 자료구조
        // push pop
        // 제일 나중에 들어간 자료가 제일 먼저 나오도록.
        // 스택에 push하는 순서는 반드시 오름차순이다
        // 임의의 수열을 주어졌을 때 그 스택을 이용해 그 수열을 만들 수 있는지 없는지
        // 만들 수 있다면 어떤 순서로 push와 pop연산을 수행해야 하는지 알아낼 수 있다.

        // 4 3 6 8 7 5 2 1
        // => 1 2 3 4 5 6 7 8
        // => 1 2 3 4 => 1 2 5 6 => 1 2 5 7 8 =>
        // => 4 3 => 4 3 6 => 4 3 6 8 7 5 2 1

        // 오. 오키

        // (1) 배열1에 수열 입력받기, 배열2에 n까지의 오름차순 만들기, 혹은 그런 반복문을 수행하기
        // (2) 배열에 push하다가, 배열1의 수열에 앞에서부터 필요한 숫자가 나오면 pop 시키기 ( pop내역을 Array에 삽입시키기)
        // (3) (2)번 수행중에 배열1과 순서가 다르면 종료시키기
        // (4) 오키오키오키오키오키

        // (3) pop, push에 대한 Array만들고 출력시키기
    }
}
