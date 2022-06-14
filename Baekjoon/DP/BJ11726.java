import java.util.*;

public class BJ11726 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] way = new int[1001];
		
		way[0] = 0;
		way[1] = 1;
		way[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			way[i] = (way[i-2] + way[i-1])%10007;
		}
		
		
		System.out.println(way[n]);
		
		/*
		 *  ó���� ����Ʈ������ 10007 ���������� �Ѹ����� ������
		 *  Ʋ�ȴٰ� ���� �����غ��� way�迭�� intŸ���̶� ������ Ÿ���� �����ϰų�
		 *  10007������ ���� �־���� ������ ������.
		 *  [������ Ÿ�Կ� ���� �����ϱ�!!]
		 */

	}

}
