import java.util.*;

public class BJ_2251 {
	//6가지 이동 케이스를 표현하기 위한 배열
	static int[] Sender = { 0, 0, 1, 1, 2, 2 };
	static int[] Receiver = { 1, 2, 0, 2, 0, 1 };
	static boolean visited[][]; // A, B의 무게만 있으면 C의 무게가 고정되므로 2개만 체크
	static boolean answer[];
	static int now[];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		now = new int[3]; // A, B, C 물의 양을 저장하는 배열
		now[0] = sc.nextInt();
		now[1] = sc.nextInt();
		now[2] = sc.nextInt();
		visited = new boolean[201][201];
		answer = new boolean[201];
		BFS();
		for (int i = 0; i < answer.length; i++) {
			if (answer[i]) System.out.print(i + " ");
		}
	}
	
	public static void BFS() {
		Queue<AB> queue = new LinkedList<>();
		queue.add(new AB(0, 0));
		visited[0][0] = true;
		answer[now[2]] = true;
		while (!queue.isEmpty()) {
			AB p = queue.poll();
			int A = p.A;
			int B = p.B;
			int C = now[2] - A - B; // C는 전체 물의 양에서 A,B 를 뺀 것
			for (int k = 0; k < 6; k++) {
				int[] next = {A, B, C};
				next[Receiver[k]] += next[Sender[k]];
				next[Sender[k]] = 0;
				if (next[Receiver[k]] > now[Receiver[k]]) { // 물이 넘칠 때
					// 초과하는 만큼 다시 이전 물통에 넣어 줌
					next[Sender[k]] = next[Receiver[k]] - now[Receiver[k]];
					next[Receiver[k]] = now[Receiver[k]]; // 대상 물통은 최대로 채워 줌
				}
				if (!visited[next[0]][next[1]]) { // A와 B의 물의 양을 이용해 방문 배열 체크
					visited[next[0]][next[1]] = true;
					queue.add(new AB(next[0], next[1]));
					if (next[0] == 0) { // A의 물의 양이 0일 때 C의 물의 무게를 정답 변수에 저장
						answer[next[2]] = true;
					}
					
				}
			}
		}
	}
}

class AB {
	int A;
	int B;
	public AB(int A, int B) {
		this.A = A;
		this.B = B;
	}
}
