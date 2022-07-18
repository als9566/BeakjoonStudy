import java.util.*;
public class BJ_1300 {

	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		long start = 1, end = K;
		long ans = 0;
		// ����Ž�� ����
		while (start <= end) {
			long middle = (start + end) / 2;
			long cnt = 0;
			// �߾Ӱ����� ���� ���� �� ������ ���
			for (int i = 1; i <= N; i++) {
				cnt += Math.min(middle / i, N); // ���� ���� ī����ϴ� �ٽ� ����
			}
			if (cnt < K) {
				start = middle + 1;
			} else {
				ans = middle;                   // ���� �ܰ��� �߾Ӱ��� ���� ������ ����
				end = middle - 1;
			}
		}
		System.out.println(ans);

	}

}
