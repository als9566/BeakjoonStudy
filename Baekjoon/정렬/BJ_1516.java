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
		
		int[] indegree = new int[N+1]; // 진입 차수 배열
		int[] selfBuild = new int[N+1];// 자기 자신을 짓는 데 걸리는 시간 배열
		
		for (int i = 1; i < N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			selfBuild[i] = Integer.parseInt(st.nextToken()); // 각 건물을 짓는데 걸리는 시간
			while(true) {
				int preTemp = Integer.parseInt(st.nextToken());
				if(preTemp == -1)
					break;
				A.get(preTemp).add(i);
				indegree[i]++; // 진입차수 배열 초기화하기
			}
		}
		
		//위상정렬
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
				//시간 업데이트하기
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
