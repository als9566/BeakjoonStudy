import java.util.*;

public class BJ_1016 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long Min = sc.nextLong(); // �ִ�
		long Max = sc.nextLong(); // �ּҰ�
		// �ִ񰪰� �ּڰ��� ���̸�ŭ �迭 ����
		boolean[] Check = new boolean[(int) (Max - Min + 1)];
		// 2�� �������� 4���� Max���� �۰ų� ���� ������ �ݺ�
		for (long i = 2; i * i <= Max; i++) {  // �ܼ� Ž���� �ƴ� ������ ���·� ����
			long pow = i * i;               // ������
			long start_index = Min / pow;
			if (Min % pow != 0)
				start_index++; // �������� ������ 1�� ���ؾ� Min���� ū ���������� ����
			for (long j = start_index; pow * j <= Max; j++) { // �������� true�� ����
				Check[(int) ((j * pow) - Min)] = true;  
			}
		}
		int count = 0;
		for (int i = 0; i <= Max - Min; i++) {
			if (!Check[i]) { // ������ �ƴ϶��
				count++;     // count++
			}
		}
		System.out.println(count);
	}
}
