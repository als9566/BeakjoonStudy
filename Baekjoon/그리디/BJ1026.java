import java.util.*;

public class BJ1026 {

	public static void main(String[] args) {
		
		/* A정렬, B역순정렬 A[n]*B[n]으로한 방법 
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int[] A = new int[N];
		Integer[] B = new Integer[N];
		
		for (int i = 0; i < N; i++) {
			A[i] = SC.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = SC.nextInt();
		}
		
		Arrays.sort(A);
		Arrays.sort(B, Comparator.reverseOrder());
		
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += A[i]*B[i];
		}
		
		System.out.println(S);
		  A정렬, B역순정렬 A[n]*B[n]으로한 방법 */
		
		
		/* B에있는 수는 재배열하면 안된다는 조건의 방법 */
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int[] A = new int[N];
		int[] B = new int[N];
		int[] reArray = new int[N];
		
		
		
		for (int i = 0; i < N; i++) {
			A[i] = SC.nextInt();
		}
		for (int i = 0; i < N; i++) {
			B[i] = SC.nextInt();
		}
		
		Arrays.sort(A);
		
		// 0도입력 받을 수 있기 때문에 reArray = -1으로 값 변경
		for (int i = 0; i < N; i++) {
			reArray[i] = -1;
		}
		
		for (int i = 0; i < N; i++) {			
			int max = -1;
			int maxIndex = 0;
			// 최대값 인덱스를 찾는다.
			for (int j = 0; j < N; j++) {
				if (reArray[j] != -1) { // 배치가 끝난 최대값은 지나감.
					continue;
				}
				if(B[j] > max) {
					max = B[j];
					maxIndex = j;
				}
			}
			// 최대값 인덱스로 A최소값이 들어간다
			reArray[maxIndex] = A[i];
		}
		
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += reArray[i]*B[i];
		}
		System.out.println(S);
	}

}
