import java.util.*;
import java.io.*;

public class baek2217 {
    public static void main(String[] arg) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] access = new int[n];

        // 로프 개수를 입력받자
        // 입력받은 허용무게중 가장 작은 값이, 개당 받을 수 있는 맥시멈이 된다 걔 곱하기 로프개수.. 하면 되잖아?

        int[] maxAc = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            access[i] = Integer.parseInt(st.nextToken());
        }
        // 입력된 값을 가장 작은 순으로 sort시키자
        // i~n까지의 [i]*n, (i-1)~n의 [i-1]*n 을 구하자

        Arrays.sort(access); // 오름차순 정렬시킴

        for (int i = 0; i < n; i++)
            maxAc[i] = access[i] * (n - i);

        int max = 0;
        for (int i = 0; i < n; i++)
            max = (maxAc[i] > max ? maxAc[i] : max);

        System.out.print(max);
    }
}
