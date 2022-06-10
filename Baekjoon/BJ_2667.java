import java.util.*;

public class BJ_2667 {
	
	static int N;
	static int[][] homeArr; // 지도배열
	static int cnt = 0; // 단지내 집의 수 
	static boolean[][] visited; //방문저장 배열
	static int[][] move = {{-1,0},{0,1},{0,-1},{1,0}}; //상하좌우
	static ArrayList<Integer> dangelist = new ArrayList<>(); //각 단지의 집의 수 리스트
	
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);

		N = SC.nextInt();

		homeArr = new int[N][N];
		visited = new boolean[N][N];
		
		// 지도입력
		for (int i = 0; i < N; i++) {
			String temp = SC.next();
			for (int j = 0; j < N; j++) {
				homeArr[i][j] = temp.charAt(j)-'0';		
			}
		}	
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt = 0;
				if (!visited[i][j] && homeArr[i][j] == 1) {
					cnt++;
					dfs(i,j);
					dangelist.add(cnt);
				}				
			}
		}
		
		Collections.sort(dangelist);
		System.out.println(dangelist.size());
		for(int cnt : dangelist) {
			System.out.println(cnt);
		}

	}
	
	static void dfs(int row, int col) {
		visited[row][col] = true;
		for (int i = 0; i < 4; i++) {
			int rn = row + move[i][0];
			int cn = col + move[i][1];
			if (rn >= 0 && rn < N && cn >= 0 && cn < N) {
				if (homeArr[rn][cn] == 1 && !visited[rn][cn]) {
					cnt++;
					dfs(rn,cn);
				}
			}				
		}
	}

}
