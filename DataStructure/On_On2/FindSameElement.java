package On_On2;

import java.util.*;

class FindSameElement {

    public ArrayList<Integer> solution (int n, int m, int [] arr1, int [] arr2){
        ArrayList<Integer> answer = new ArrayList<Integer>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1=0, p2=0;
        while ( p1 < n && p2 < m){
            if ( arr1[p1] < arr2[p2]){
                p1++;
            }else if(arr1[p1] > arr2[p2]){
                p2++;
            }else{
                answer.add(arr1[p1]);
                p1++;
                p2++;
            }
        }

        return answer;
    }


    public static void main (String [] args) {

        FindSameElement T = new FindSameElement();
		Scanner kb = new Scanner(System.in);
		int n=kb.nextInt();
		int[] a=new int[n];
		for(int i=0; i<n; i++){
			a[i]=kb.nextInt();
		}
		int m=kb.nextInt();
		int[] b=new int[m];
		for(int i=0; i<m; i++){
			b[i]=kb.nextInt();
		}
		for(int x : T.solution(n, m, a, b)) System.out.print(x+" ");
    }
}