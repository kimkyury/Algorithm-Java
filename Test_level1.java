import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;



class Test{
    public int[] solution(String [] id_list, String [] report, int k){
        int [] answer = new int [id_list.length];

        ArrayList <String> ids = new ArrayList<>();
        HashMap <String, ArrayList<String>> sendMap = new HashMap<>();
        HashMap <String, Integer> reciveMap = new HashMap<>();

        for(String id : id_list){
            sendMap.put(id, ids);
            reciveMap.put(id, 0);
        }

        StringTokenizer st;
        for (String repo : report){
            st = new StringTokenizer(repo);
            String sendUser = st.nextToken();
            String reciveUser = st.nextToken();

            if(sendMap.get(sendUser).contains(reciveUser)) continue;

            // 한 유저가 신고를 보낸 대상들을 저장
            sendMap.put();
            // 한 유저가 받은 신고 횟수들을 저장
            reciveMap.put(reciveUser, reciveMap.getOrDefault(reciveUser, 0)+1);
        }

        //for(String user : reciveMap.keySet()) System.out.println("보낸신고- " + user + ": " + sendMap.get(user));
        //for(String user : reciveMap.keySet()) System.out.println("받은신고- " + user + ": "  + reciveMap.get(user));


        // 신고한 유저에게 메일 발송
        for(int i =0; i<id_list.length; i++){
            for(String reciver : id_list){
                String target = sendMap.get(id_list[i]);
                if(target.contains(reciver)&& reciveMap.get(reciver) >= k)
                    answer[i] += 1;
                    //System.out.println(sendUser + "는 " + id + "로 인해 증가됨, " + answer[index]);
            }
        }

        return answer;
    }

    public static void main(String [] args){
        Test T =  new Test();
        
        String [] id_list = {"muzi", "frodo", "apeach", "neo"};
        String [] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        for(int x: T.solution(id_list, report, k)){
            System.out.print(x+ " ");
        }

    }
}