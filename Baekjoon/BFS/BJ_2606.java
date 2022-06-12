import java.util.*;

public class BJ_2606 {
	
	static int[][] node;
	static boolean[] visited;
	static int N,M;
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		node=new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int i=0;i<M;i++) { // 그래프 구성
			int a =sc.nextInt();
			int b = sc.nextInt();
			node[a][b]=node[b][a]=1;		
		}	
		
		bfs(1);
		
		System.out.println(cnt);

	}
	
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			for(int j = 1; j <= N; j++) {
		        if(node[temp][j] == 1 && visited[j]==false) {
		          q.offer(j);
		          visited[j] = true;
		          cnt++;
		        }
		    }
		}
		
	}

}
