import java.util.*;
import java.io.*;

public class baek1018 {

    static char[][] board;
    static int N, M;

    static int[] cnt;

    // 체스판의 완성본은 흰색으로 시작하거나 검은색으로 시작하거나 둘 중 하나이다.
    static final char[][] W_board = { { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' },
            { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' }, };

    static final char[][] B_board = { { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, { 'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W' },
            { 'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B' }, };

    public static void main(String[] args) throws IOException {

        // 1. 주어진 NxM사이즈의 보드를 8x8로 잘라낸다,

        // 2. 잘라낸 부분을 W, B 버전과 비교하여 횟수를 센다
        // 잘라낸 부분은 몇 개지?, cut_Num = {(N-8)+1} * {(M-8)+1} 개의 잘라낼 부분이 있네. 카운트도 이만큼 개수가
        // 있겠네?
        // cut_Num번 W과 비교해서 다른 게 몇개(W_cnt)인지, B와 비교해서 다른 게 몇개(B_cnt)인지 찾자
        // W_cnt와 B_cnt 를 합쳐서 가장 작은 수를 출력시키자

        // 체스판을 입력받자.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];

        // 얘는 나중에 생성되는 각각의 체스판들의, 결과체스판과의 different카운트 수를 저장할 공간
        // 만들어질 체스판이 총 {N-7}*{M-7} 개가 될 거니까 개수도 이만큼
        cnt = new int[(N - 7) * (M - 7)];

        String str;
        for (int i = 0; i < N; i++) {
            str = new String(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = str.charAt(j);
            }
        }
        // 입력받기 끝

        // 함수 count의 시작점을 보내자.
        int k = 0;
        for (int i = 0; i < N - 7; i++) {
            for (int j = 0; j < M - 7; j++) {
                cnt[k++] = count(board, i, j);
            }
        }

        // 배열을 오름차순으로 정렬
        Arrays.sort(cnt);

        // 인덱스0이 가장 작은 값일테니까
        System.out.print(cnt[0]);

    }

    // 배열을 잘라 저장하고, 잘라낸 배열이 결과보드와 얼마나 차이나는지 (W, B 중에 더 작은 값을) 리턴하는 함수 작성
    static int count(char[][] board, int start_row, int start_col) {
        // 8x8사이즈로 자른 판을 저장시킬 board 생성
        char[][] cutBoard = new char[8][8];
        int W_cnt = 0, B_cnt = 0;

        // 체스판 잘라다가 저장하기.
        for (int i = start_row; i < start_row + 8; i++) {
            for (int j = start_col; j < start_col + 8; j++) {
                // cutBoard에 판을 저장시킨다.
                cutBoard[i - start_row][j - start_col] = board[i][j];
            }
        }

        // 자른체스판 가져와서 비교하기
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (cutBoard[i][j] != W_board[i][j]) {
                    W_cnt++;
                }
                if (cutBoard[i][j] != B_board[i][j]) {
                    B_cnt++;
                }
            }
        }

        // 이제 카운트 수가 뭐가 작은지 판단해서 리턴시키기
        // W가 더 작을 때
        if (W_cnt < B_cnt) {
            return W_cnt;
        }

        // W, B가 같거나 B가 더 작거나
        else {
            return B_cnt;
        }
    }

    static void show(char[][] board) {
        System.out.println("--입력된 체스판---");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(board[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("-----------------");
    }
}
