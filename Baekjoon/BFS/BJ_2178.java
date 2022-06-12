import java.util.*;

public class BJ_2178 {

	static int[][] miro; //미로배열
	static boolean[][] visited; // 방문배열
	static int[][] move = {{-1,0},{0,-1},{1,0},{0,1}}; // 이동배열
	static int N,M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		miro = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			for (int j = 0; j < M; j++) {
				miro[i][j] = temp.charAt(j)-'0';
			}
		}
		
		/*
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < M; j++) {
				System.out.print(miro[i][j]);
			}
		}
		*/
		
		visited[0][0] = true;
		bfs(0,0);
		System.out.println(miro[N-1][M-1]);
		
		/*
		for (int i = 0; i < N; i++) {
			System.out.println();
			for (int j = 0; j < M; j++) {
				System.out.print(miro[i][j]);
			}
		}
		*/
		
	}
	
	static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int now[] = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for (int i = 0; i < 4; i++) {
				int nextX = nowX + move[i][0];
				int nextY = nowY + move[i][1];
				if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) 
					continue;
				if (miro[nextX][nextY] == 0 || visited[nextX][nextY]) 
					continue;
				q.add(new int[] {nextX, nextY});
				visited[nextX][nextY] = true;
				miro[nextX][nextY] = miro[nowX][nowY] + 1;
			}
		}
	}
}
