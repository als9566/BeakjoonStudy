import java.util.*;

public class BJ_1167 {
	static boolean visited[];
	static int[] distance;
	static ArrayList<Edge>[] A;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();   //��� ����
		A = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			A[i] = new ArrayList<Edge>();
		}
		for (int i = 0; i < N; i++) {  // A ���� ����Ʈ�� �׷��� ������ �����ϱ�
			int S = sc.nextInt();
			while (true) {
				int E = sc.nextInt();
				if (E == -1)
					break;
				int V = sc.nextInt();
				A[S].add(new Edge(E, V));
			}
		}
		distance = new int[N + 1];     // distance �ʱ�ȭ
		visited = new boolean[N + 1];  // visited  �ʱ�ȭ
		BFS(1);                        // ������ ���� ���������� BFS ����
		int Max = 1;
		for (int i = 2; i <= N; i++) { //distance �迭���� ���� ū ������ �ٽ� ������ ����
			if (distance[Max] < distance[i])
				Max = i;
		}
		distance = new int[N + 1];     // distance �ʱ�ȭ
		visited = new boolean[N + 1];  // visited  �ʱ�ȭ
		BFS(Max);                      // ���ο� ������(distance ����ū��)���� BFS����
		Arrays.sort(distance);         // ����
		System.out.println(distance[N]);  // ������ �����Ƿ� ������ �ε��� �迭�� ���
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
					distance[e] = distance[now_node] + v;  // �Ÿ��迭 ������Ʈ
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
