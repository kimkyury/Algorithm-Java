import java.util.ArrayList;

public class UserSolution {

    ArrayList<ArrayList<Integer>> pdigree;
    boolean[] visited;

    public void dfs_init(int N, int[][] path) {
        pdigree = new ArrayList<>();
        visited = new boolean[N + 1];

        for (int i = 0; i < N; i++) {
            pdigree.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < path.length; i++) {
            int parent = path[i][0];
            int child = path[0][i];
            pdigree.get(parent).add(child);
        }

    }

    public int dfs(int n) {

        if( n > )

        for (int i = 0; i < pdigree.get(n).size(); i++) {
            dfs(pdigree.get(n).get(i));
        }

    }
}