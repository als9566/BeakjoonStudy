import java.util.*;

public class BJ_1744 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // ī�� ������ �� ����
		// ����� �������� ����
		PriorityQueue<Integer> plusPq = new PriorityQueue<>(Collections.reverseOrder()); 
		PriorityQueue<Integer> minusPq = new PriorityQueue<>();
		int one = 0;
		int zero = 0;
		
		for (int i = 0; i < N; i++) { // 4���� �׷����� �и��� �����ϱ�
			int data = sc.nextInt();
			if (data > 1) {
				plusPq.add(data);
			} else if (data == 1) {
				one++;
			} else if (data == 0) {
				zero++;
			} else {
				minusPq.add(data);
			}
		}
		int sum = 0;
		// ��� ó���ϱ�
		while (plusPq.size() > 1) {
			int first = plusPq.remove();
			int second = plusPq.remove();
			sum += first * second;
		}
		if (!plusPq.isEmpty()) {
			sum += plusPq.remove();
		}
		// ���� ó���ϱ�
		while (minusPq.size() > 1) {
			int first = minusPq.remove();
			int second = minusPq.remove();
			sum += first * second;
		}
		if (!minusPq.isEmpty()) {
			if (zero == 0) {
				sum += minusPq.remove();
			}
		}
		// 1 ó���ϱ�
		sum += one;
		System.out.println(sum);

	}

}
