import java.util.Arrays;
import java.util.Scanner;

public class BJ2217 {

	public static void main(String[] args) {
		Scanner SC = new Scanner(System.in);
		
		//������ ����
		int N = SC.nextInt(); 
		
		//������ ������ �� �� �ִ� ��ü�� �߷� �迭 
		int[] arr = new int[N];
		
		//N���� ���� �߷��� �Է¹���.
		for (int i = 0; i < N; i++) {
			arr[i] = SC.nextInt();
		}
		
		//������ ����
		Arrays.sort(arr);
		
		int maxKg = 0;
		
		/*
		������ �� �� �ִ� �߷����� ū ������ �Բ� ����ؾ� ū �߷��� �� �� �ִ�.
		for���� �Ųٷ� �����Ͽ���. 
		EX) 10 20 30 
		30���� ū �߷��� �����Ƿ� 30*1=30
		20���� ū �߷��� 30�� �����Ƿ� 20,30������ �̿��ϸ� 20*2=40
		10���� ū �߷��� 20,30�� �����Ƿ� 10,20,30������ �̿��ϸ� 10*3=30
		*/
		for (int i = N-1; i >= 0; i--) {
			if(maxKg < arr[i]*(N-i)) {
				maxKg = arr[i]*(N-i); 
			}
		}
		
		System.out.println(maxKg);

	}

}
