import java.io.*;
import java.util.*;

public class baek1421{

    static int N, C, W;
    public static void main(String [] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //나무의 개수, 비용, 가격 정보 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        //갖고 있는 나무의 길이 받기
        int [] lengths = new int [N];
        for(int i =0; i<N; i++){
            lengths [i] = Integer.parseInt(br.readLine());
        }
        /*벌 수 있는 가장 큰 돈을 생각햅좌 */
        Arrays.sort(lengths);
        int [] values = new int [N];
        for (int i =0; i<N; i++){
            values[i] = 0;
        }

        int [] vv = new int [3];
        int tNum=0, cNum=0;
        for(int i =0; i<lengths[0]; i++){
            vv[0] =0;
            vv[1] =0;
            vv[2] =0;

            //자르는 비용이 단가보다 비싸면 팔아버리지 말자
            for (int j =0; j<N; j++){
                tNum += lengths[j]/(i+1); // 토막수 구하기
                tNum = 0;                       //가진 나무들(j)로 가능한 i+1길이의 토막 수 구하기
                cNum =0;                        //가진 나무들(j)로 i+1길이를 만들기 위한 커팅 횟수 구하기
                if(lengths[j] != (i+1)){    // 길이가 이미 완전할 땐 커팅수가 증가되지 않도록.
                    cNum += lengths[j]/(i+1); // 커팅수 구하기
                }

                if(tNum*(i+1)*W - cNum*C <0){ // j번쨰 나무의, [토막수 * 길이 * 단가] 가 오히려 -면, 그 나무는 팔지말자.
                    vv[j] = 0;
                }
                vv[j] = tNum * (i+1) * W -cNum*C;
            }
            
            for(int j =0; j<3; j++){
                values[i] += vv[j];
            }
            
            System.out.println(i+1 + "길이로 " + tNum + "토막이 나오도록 " + cNum +"번 컷팅하면: " + values[i]);

        }
        Arrays.sort(values);

        System.out.print(values[lengths[0]-1]);
    }
}