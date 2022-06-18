import java.util.*;

public class BJ_1260 {
	
	static int N,M,V;
	static int[][] A;
	static boolean[] visited;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();
		
		A = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			A[x][y] = 1;
			A[y][x] = 1;
		}
		
		//DFS
		DFS(V);
		
		//ÃÊ±âÈ­
		visited = new boolean[N+1];
		
		System.out.println();
		
		//BFS
		BFS(V);

	}
	
	static void DFS(int i) {
		System.out.print(i + " ");
		visited[i] = true;
		for (int j = 1; j < N+1; j++) {
			if (A[i][j] == 1 && !visited[j]) {
				DFS(j);
			}
		}
	}
	
	static void BFS(int i) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(i);
		visited[i] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			System.out.print(now + " ");
			for (int j = 1; j < N+1; j++) {
				if (!visited[j] && A[now][j] == 1) {
					queue.add(j);
					visited[j] = true;
				}
			}
		}
	}
	
}
