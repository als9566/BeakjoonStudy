import java.util.*;
public class BJ_10986 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		//구간합 배열
		long[] A = new long[N];
		//나머지 카운트 배열(인덱스 == 나머지값)
		long[] C = new long[M];
		//쌍의개수(정답)
		long sum = 0;
		
		A[0] = sc.nextLong(); // 0인덱스는 반복문 밖에서 받아줘야 오류가 없음.
		for (int i = 1; i < N; i++) {
			A[i] = A[i-1] + sc.nextLong(); //숫자를 받으면서 합배열을 만든다.
		}
		
		for (int i = 0; i < N; i++) {
			if (A[i] % M == 0) {
				sum++;
			}
			C[(int) (A[i] % M)] += 1; 
		}
		
		for (int i = 0; i < M; i++) {
			if (C[i] > 0) { 
				sum = sum + C[i] * (C[i]-1) / 2; // C[i]개중에 2개를 뽑는 경우의수 수식
			}	
		}
		System.out.println(sum);
		
	}

}
