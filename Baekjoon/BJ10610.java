import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class BJ10610 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		// N�� �ִ� 10��5�°��� ���ڷ� �����Ǿ������Ƿ�
		// String Ÿ������ ���� �� �ۿ� ����.
		String N = SC.next();
		// ���� ���ڸ� ���� Integer �迭
		Integer[] Arr = new Integer[N.length()];
		
		int sum = 0;
		
		// String���� ���� ���ڸ� Integer�迭�� ����ش�.
		for (int i = 0; i < Arr.length; i++) {
			Arr[i] = Integer.parseInt(N.substring(i, i+1));
			sum += Arr[i];
		}
		
		// �������� ����
		Arrays.sort(Arr, Collections.reverseOrder());
		
		//1. ������ �ڸ����� 0�� �ƴϸ� 30�� ����� �� �� ����.
		//2. ��� �ڸ����� ���� 3�� ����� �ƴϸ� 30�� ����� �� �� ����.
		if (Arr[Arr.length-1] != 0 || sum % 3 != 0) {
			System.out.println("-1");
			return;
		}
		
		// ���
		for (int i = 0; i < Arr.length; i++) {
			System.out.print(Arr[i]);
		}

	}

}
