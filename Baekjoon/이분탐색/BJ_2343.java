import java.util.*;

public class BJ_2343 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] A = new int[N];
		int start = 0;
		int end = 0;
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
			if (start < A[i]) start = A[i]; // ���� �ִ��� ���� �ε����� ����
			end += A[i];               // ��� ������ ������ ���� �ε����� ����
		}
		while (start <= end) {
			int middle = (start + end) / 2;
			int sum = 0;
			int count = 0;
			for (int i = 0; i < N; i++) {
				if (sum + A[i] > middle) {
					count++;
					sum = 0;
				}
				sum += A[i];
			}
			if (sum != 0)             // Ž�� �� sum�� 0�� �ƴϸ� ��緹�̰� 1�� �� �ʿ�
				count++;
			if (count > M) 
				start = middle + 1;
			else
				end = middle - 1;
			//System.out.println(count);
		}
		System.out.println(start);

	}

}
