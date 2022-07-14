import java.util.*;

public class BJ_1167 {
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   //노드 개수
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < N; i++) {  // A 인접 리스트에 그래프 데이터 저장하기
			int S = sc.nextInt();
			while (true) {
				int E = sc.nextInt();
				if (E == -1)
					break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N + 1];     // distance 초기화
		visited = new boolean[N + 1];  // visited  초기화
		BFS(1);                        // 임의의 점을 시작점으로 BFS 실행
		int Max = 1;
		for (int i = 2; i <= N; i++) { //distance 배열에서 가장 큰 값으로 다시 시작점 설정
			if (distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N + 1];     // distance 초기화
		visited = new boolean[N + 1];  // visited  초기화
		BFS(Max);                      // 새로운 시작점(distance 가장큰값)으로 BFS실행
		Arrays.sort(distance);         // 정렬
		System.out.println(distance[N]);  // 정렬을 했으므로 마지막 인덱스 배열값 출력
	}
	
	private static void BFS(int index) {  // BFS
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(index);
		visited[index] = true;
		while (!queue.isEmpty()) {
			int now_node = queue.poll();
			for (Edge i : A[now_node]) {
				int e = i.e;
				int v = i.value;
				if (!visited[e]) {
					visited[e] = true;
					queue.add(e);
					distance[e] = distance[now_node] + v;  // 거리배열 업데이트
				}
			}
		}
	}
}

class Edge {
	int e;
	int value;
	public Edge(int e, int value) {
		this.e = e;
		this.value = value;
	}
}
