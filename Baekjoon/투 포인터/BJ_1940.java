import java.util.*;
public class BJ_1940 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // ����� ����
		int M = sc.nextInt(); // ������ ����µ� �ʿ��� ��
		int[] A = new int[N]; // ���迭
		
		for (int i = 0; i < N; i++) { // ���迭�� ��Ḧ �Է¹���
			A[i] = sc.nextInt();
		}
		
		Arrays.sort(A); // ���迭 �������� ����
		
		int i = 0;      // ������Ĺ迭 ù��°�ε��� 
		int j = N-1;    // ������Ĺ迭 �������ε��� 
		int count = 0;  // ���ʻ��� ����
		
		while(i < j) {  // i��j�� ũ�ν� �ϱ������� �ݺ�
			if (A[i] + A[j] < M) {        // ���� M���� �۴ٸ� ��ū ���� ���� �� �ֵ��� i++
				i++;
			} else if (A[i] + A[j] > M) { // ���� M���� ũ�ٸ� ���� ���� ���� �� �ֵ��� j--;
				j--;
			} else {                      // ���� M�� ���ٸ� ������ ������ �� �����Ƿ�
				count++;                  // count++, ���� ������ �̵�
				i++;
				j--;
			}
		}
		
		System.out.println(count);

	}

}
