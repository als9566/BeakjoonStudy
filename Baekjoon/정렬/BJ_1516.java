import java.io.*;
import java.util.*;

public class BJ_1516 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		ArrayList<ArrayList<Integer>> A = new ArrayList<>();
		for (int i = 0; i < N+1; i++) {
			A.add(new ArrayList<>());
		}
		
		int[] indegree = new int[N+1]; // ���� ���� �迭
		int[] selfBuild = new int[N+1];// �ڱ� �ڽ��� ���� �� �ɸ��� �ð� �迭
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken()); // �� �ǹ��� ���µ� �ɸ��� �ð�
			while(true) {
				int preTemp = Integer.parseInt(st.nextToken());
				if(preTemp == -1)
					break;
				A.get(preTemp).add(i);
				indegree[i]++; // �������� �迭 �ʱ�ȭ�ϱ�
			}
		}
		
		//��������
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i < N+1; i++) {
			if (indegree[i] == 0) {
				queue.offer(i);
			}
		}
		int[] result = new int[N+1];
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for (int next : A.get(now)) {
				indegree[next]--;
				//�ð� ������Ʈ�ϱ�
				result[next] = Math.max(result[next], result[now]+selfBuild[now]);
				if (indegree[next] == 0) {
					queue.offer(next);
				}
			}
		}
		for (int i = 1; i < N+1; i++) {
			System.out.println(result[i]+selfBuild[i]);
		}

	}

}
