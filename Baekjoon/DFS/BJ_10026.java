import java.util.*;

public class BJ_10026 {

	static int N;
	static char[][] RGBIMG;
	static boolean[][] visited;
	static int[][] move = {{-1,0},{0,1},{0,-1},{1,0}};
	static int cnt = 0;
	
	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		
		N = SC.nextInt();
		visited = new boolean[N][N];
		RGBIMG = new char[N][N];
		
		for (int i = 0; i < N; i++) {
			String temp = SC.next();
			for (int j = 0; j < N; j++) {
				RGBIMG[i][j] = temp.charAt(j);
			}
		}
		
		//아닌사람이 보을때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i,j,RGBIMG[i][j]);
					cnt++;
				}		
			}
		}
		System.out.print(cnt);
		
		//적록색약인 사람이 보는 그림을 만든다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(RGBIMG[i][j] == 'G') {
					RGBIMG[i][j] = 'R';
				}
			}
		}
		
		cnt = 0;
		visited = new boolean[N][N];
		//적록색약인 사람이 보았을때
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i,j,RGBIMG[i][j]);
					cnt++;
				}		
			}
		}
		
		System.out.print(" "+cnt);

	}
	
	static void dfs(int r, int c, char RGB) {
		visited[r][c] = true;
		for (int i = 0; i < move.length; i++) {
			int rn = r+move[i][0];
			int cn = c+move[i][1];
			if (rn>=0 && cn >= 0 && rn < N && cn < N) {
				if (RGB == RGBIMG[rn][cn] && !visited[rn][cn]) {
					dfs(rn,cn,RGB);
				}
			}
		}
	}

}
