import java.io.*;
import java.util.*;

public class BJ_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		long[][] S = new long[N+1][N+1]; //�����迭
		long[][] D = new long[N+1][N+1]; //�չ迭
		
		// �����迭 �ޱ�
		for (int i = 1; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N+1; j++) {
				S[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// �չ迭 �����
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				D[i][j] = D[i-1][j] + D[i][j-1] - D[i-1][j-1] + S[i][j];
			}
		}
		
		// ��ǥ ������ ���ÿ� �� ���
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			//(X1,Y1)����(X2,Y2)������ ��
			long sum = D[X2][Y2] - D[X1-1][Y2] - D[X2][Y1-1] + D[X1-1][Y1-1];
			System.out.println(sum);
		}	

	}

}
