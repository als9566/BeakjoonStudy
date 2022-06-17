import java.util.*;

public class BJ_11724 {
	
	static int[][] A;
	static boolean[] visited;
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		int count = 0;

		A = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			A[u][v] = 1;
			A[v][u] = 1;
		}
		
		for (int i = 1; i < N+1; i++) {
			if (!visited[i]) {
				count++;
				DFS(i);
			}	
		}
		
		System.out.println(count);

	}
	
	public static void DFS(int v) {
		if (visited[v]) {
			return;
		}
		visited[v] = true;
		for (int i = 1; i < N+1; i++) {
			if (visited[i]==false && A[v][i]==1) {
				DFS(i);
			}
		}
	}

}
