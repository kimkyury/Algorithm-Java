package day5;

import java.util.Scanner;

class fibonacci {

    private static long arr[] = new long[100002];

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int answer;
        arr[0] = 0;
        arr[1] = 1;

        fibonazzi(n);
        Long res = arr[n] % 1234567;
        answer = res.intValue();

        System.out.println(answer);
    }

    public static void fibonazzi(int n) {

        if (n <= 1) {
            return;
        }
        fibonazzi(n - 1);
        arr[n] = arr[n - 2] + arr[n - 1];

    }

}
