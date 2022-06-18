import java.util.*;

public class BJ_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int[] A = new int[N+1];
		
		for (int i = 2; i < N+1; i++) {// 인덱스로 값 채우기
			A[i] = i;
		}
		
		for (int i = 2; i <= Math.sqrt(N); i++) { // 제곱근까지만 반복
			if (A[i] == 0) {
				continue;
			}
			for (int j = i+i; j < N+1; j=j+i) { //배수지우기
				A[j] = 0;
			}
		}
		
		for (int i = M; i < N+1; i++) {
			if (A[i] != 0) {
				System.out.println(A[i]);
			}
		}

	}

}
