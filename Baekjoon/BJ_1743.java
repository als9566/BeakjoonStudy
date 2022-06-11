import java.util.*;

public class BJ_1743 {

	static boolean [][] arr; //음식물 배열
	static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
	static boolean [][] visitied;
	static int N,M,K;
	static int max,cnt = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		
		arr = new boolean[N][M];
		visitied = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			int r = sc.nextInt()-1;
			int c = sc.nextInt()-1;
			arr[r][c] = true;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visitied[i][j] && arr[i][j] == true) {
					cnt++;
					dfs(i,j);
					if (max < cnt) {
						max = cnt;
					}
					cnt = 0;
				}	
			}
		}
		
		System.out.println(max);
		
	}
	
	static void dfs(int r, int c) {
		visitied[r][c] = true;
		for (int i = 0; i < move.length; i++) {
			int rn = r+move[i][0];
			int cn = c+move[i][1];
			if (rn >= 0 && cn >= 0 && rn < N && cn < M) {
				if (arr[rn][cn] == true && !visitied[rn][cn]) {
					cnt++;
					dfs(rn,cn);
				}
			}
		}
	}

}
