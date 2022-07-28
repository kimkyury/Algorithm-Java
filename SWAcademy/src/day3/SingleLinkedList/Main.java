package day3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private final static int MAX_NODE = 10000;
	private final static int ADD_HEAD = 1;
	private final static int ADD_TAIL = 2;
	private final static int ADD_NUM = 3;
	private final static int REMOVE = 4;
	private final static int PRINT = 5;
	private final static int END = 99;

	private final static UserSolution usersolution = new UserSolution();

	private static BufferedReader br;

	private static void run() throws Exception {

		int cmd, data, num, ret;
		int[] output = new int[MAX_NODE];
		String str;
		StringTokenizer st;

		while (true) {
			str = br.readLine(); // str = 1 5
			st = new StringTokenizer(str, " "); // st.cur =1, st.next = 5
			cmd = Integer.parseInt(st.nextToken()); // cmd = 1

			switch (cmd) {
				case ADD_HEAD: // 첫
					data = Integer.parseInt(st.nextToken()); // data =5
					usersolution.addNode2Head(data);
					break;

				case ADD_TAIL:
					data = Integer.parseInt(st.nextToken());
					usersolution.addNode2Tail(data);
					break;

				case ADD_NUM:
					data = Integer.parseInt(st.nextToken());
					num = Integer.parseInt(st.nextToken());
					usersolution.addNode2Num(data, num);
					break;

				case REMOVE:
					data = Integer.parseInt(st.nextToken());
					usersolution.removeNode(data);
					break;

				case PRINT: // 둘
					ret = usersolution.getList(output);
					for (int i = 0; i < ret; i++) {
						System.out.print(output[i] + " ");
					}
					System.out.println();
					break;

				case END:
					return;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int TC;
		System.setIn(new java.io.FileInputStream("res/day2/sll_input.txt"));

		br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		TC = Integer.parseInt(str); // 3,

		for (int tc = 1; tc <= TC; tc++) {
			System.out.println("#" + tc);
			usersolution.init();
			run();
			System.out.println();
		}
	}
}