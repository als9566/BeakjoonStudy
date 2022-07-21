import java.util.*;

public class BJ_1929 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();  // 시작 수
		int N = sc.nextInt();  // 종료 수
		
		int[] A = new int[N+1]; // 소수 배열
		
		for (int i = 2; i < N+1; i++) {// 인덱스로 값 채우기
			A[i] = i; // 각각의 인덱스 값으로 초기화
		}
		
		for (int i = 2; i <= Math.sqrt(N); i++) { // 제곱근까지만 반복
			if (A[i] == 0) { // 소수가 아니면 넘어감
				continue;
			}
			for (int j = i+i; j < N+1; j=j+i) { //배수지우기
				A[j] = 0; // 이 수가 소수가 아니라는 것을 표시
			}
		}
		
		for (int i = M; i < N+1; i++) {
			if (A[i] != 0) {  // A 배열에서 소수인 값 
				System.out.println(A[i]);
			}
		}

	}

}
