import java.io.*;
import java.util.*;

public class Main{
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	private static StringTokenizer st;
	// private static int [][]  gearInfos;
	private static List<LinkedList<Integer>> gearInfos;
	private static int N;
	
	public static void main(String [] args) throws IOException {
		
		// 1. 입력
		 N = Integer.parseInt(br.readLine());
		
		// gearInfos = new int [N+1][8];
		gearInfos = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i<=N; i++){
			LinkedList<Integer> q = new LinkedList<>();
			gearInfos.add(q);
		}
		
		for(int i =1; i<=N; i++){
			String gearInfoStr = br.readLine();
			char [] gearInfoChar = gearInfoStr.toCharArray();
			
			for(int j =0; j<8; j++){
				gearInfos.get(i).offerLast(gearInfoChar[j] - '0');
			}
		}
		
		// 2. 회전시키기
		int K = Integer.parseInt(br.readLine());
		for(int i =0; i<K; i++){
			st = new StringTokenizer(br.readLine());
			int gearNo = Integer.parseInt(st.nextToken());
			int direction = Integer.parseInt(st.nextToken());
			
			// 2-1. 회전 대상자 가져오기
			List<Integer [] > targetGearAndDirection = findCurveGearList(gearNo, direction);
			
			// 2-2. 대상자들 회전 시키기
			curveGear(targetGearAndDirection);
		}
		
		int answer = countS();
		
		// . 12시 방향이 S극인 개수 세기

		bw.write(String.valueOf(answer));
		bw.flush();
	
	}
	
	private static int countS(){
		
		int count = 0;
		
		for( int i =1; i<=N; i++){
			
			if ( gearInfos.get(i).get(0) == 1){
				count++;
			}
			
		}
		
		return count;
	}
	
	private static List<Integer []> findCurveGearList(int gearNo, int direction){
		
		List<Integer []> targetGearAndDirection = new ArrayList<>();
		Integer [] initTarget = { gearNo, direction};
		targetGearAndDirection.add(initTarget);
		
		// check Left
		int gearIdx = gearNo;
		int tmpD = direction;
		while(true){
			
			if ( gearIdx == 1)  break;
			
			
			LinkedList<Integer> curGear = gearInfos.get(gearIdx);
			LinkedList<Integer> leftGear = gearInfos.get(gearIdx-1);
			
			if (  curGear.get(6) == leftGear.get(2) ) break;

			Integer [] targetInfo = { --gearIdx, tmpD *= (-1)};
			targetGearAndDirection.add(targetInfo);
		}
		
		// check right
		gearIdx = gearNo;
		tmpD = direction;
		while(true){
			
			if ( gearIdx == N ) break;
			
			LinkedList<Integer> curGear = gearInfos.get(gearIdx);
			LinkedList<Integer> rightGear = gearInfos.get(gearIdx + 1);
			
			if (  curGear.get(2) == rightGear.get(6)) break;

			Integer [] targetInfo = { ++gearIdx,tmpD *= (-1)};
			targetGearAndDirection.add(targetInfo);
		}
		
		return targetGearAndDirection;
	}
	
	private static void curveGear(List<Integer []> targets){
		
		for( Integer [] target : targets){
			// System.out.println("회전중: " + target[0] + ", 방향: " + target[1]);
			
			LinkedList<Integer> targetGear = gearInfos.get(target[0]);
			// 반시계
			if ( target[1] == -1){
				int tmp = targetGear.pollFirst();
				targetGear.offerLast(tmp);
			}else{
				int tmp = targetGear.pollLast();
				targetGear.offerFirst(tmp);
			}
		}
		
	}
	
	private static void show(int [][] arr){
		for( int i = 0; i< arr.length; i++){
			for(int j =0; j<arr[0].length; j++){
				System.out.print(arr[i][j] + " " );
			}
			System.out.println("");
		}
	}
	
	private static void show(List<LinkedList<Integer>> lists){
		for(Queue<Integer> list : lists){
			System.out.println(list);
		}
	}

}