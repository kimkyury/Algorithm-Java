import com.sun.source.tree.Tree;
import java.io.*;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static StringTokenizer st;
    static int N,M, T;

    static Set<Integer> nodes;
    static Map<Integer, Integer> parent ;
    static Map<Integer, Integer> depth ;
    static Map<Integer, List<Integer>> tree ;


    public static void main(String[] args) throws IOException {

       // 공통 조상 구하기
        T = Integer.parseInt(br.readLine());
        
        for(int t =0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            // 1. 양방향으로 저장한다
            // 2. parent가 없는 root를 찾는다 (parent 탐색)
            // 3. root에서부터 탐색하여 부모를 재설정해준다 (child 탐색)
            // 4. 두 노드의 깊이가 다를 수 있으므로, 깊이를 동일하게 만들어준다
            // 5. 깊이가 같은 상태에서 공통 부모를 찾는다

            nodes = new HashSet<>();
            parent = new HashMap<>();
            depth = new HashMap<>();
            tree = new HashMap<>();

            Set<Integer> child = new HashSet<>();

            for(int i =0; i<N-1; i++){
                st = new StringTokenizer(br.readLine());

                // 1. 트리를 만든다
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                nodes.add(p);
                nodes.add(c);

                parent.put(c, p);
                tree.putIfAbsent(p, new ArrayList<>());
                tree.get(p).add(c);

                child.add(c);
            }

            // 자식인 적이 없는 애가 root
            int root = -1;
            for(int node: nodes){
                if ( !child.contains(node)){
                    root = node;
                    break;
                }
            }

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            // depth 정보 관리
            setDepth( root, 0);

            int pNode = find(v1, v2);
        
            bw.write(pNode +"\n");
        }


        bw.flush();
    }

    static void setDepth(int root, int dep){

        depth.put(root, dep);

        for(int node : tree.getOrDefault(root, new ArrayList<>())){
            setDepth(node, dep+1);
        }
    }

    static int find(int v1, int v2){

        // 큰 쪽이 낮추러 가야함
        while(depth.get(v1) < depth.get(v2)){
            v2 = parent.get(v2);
        }

        while(depth.get(v1) > depth.get(v2)){
            v1 = parent.get(v1);
        }


        while( v1 != v2){
            v1 = parent.get(v1);
            v2 = parent.get(v2);
        }

        return v1;
    }

}
