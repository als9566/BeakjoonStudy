import java.util.*;

public class BJ1026 {

	public static void main(String[] args) {
		
		/* A����, B�������� A[n]*B[n]������ ��� 
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
		  A����, B�������� A[n]*B[n]������ ��� */
		
		
		/* B���ִ� ���� ��迭�ϸ� �ȵȴٴ� ������ ��� */
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
		
		// 0���Է� ���� �� �ֱ� ������ reArray = -1���� �� ����
		for (int i = 0; i < N; i++) {
			reArray[i] = -1;
		}
		
		for (int i = 0; i < N; i++) {			
			int max = -1;
			int maxIndex = 0;
			// �ִ밪 �ε����� ã�´�.
			for (int j = 0; j < N; j++) {
				if (reArray[j] != -1) { // ��ġ�� ���� �ִ밪�� ������.
					continue;
				}
				if(B[j] > max) {
					max = B[j];
					maxIndex = j;
				}
			}
			// �ִ밪 �ε����� A�ּҰ��� ����
			reArray[maxIndex] = A[i];
		}
		
		int S = 0;
		for (int i = 0; i < N; i++) {
			S += reArray[i]*B[i];
		}
		System.out.println(S);
	}

}
