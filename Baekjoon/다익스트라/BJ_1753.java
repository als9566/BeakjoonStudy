import java.io.*;
import java.util.*;

public class BJ_1753 {
	public static int V,E,K; // V : 정점의 개수, E : 간선의 개수, K : 시작정점의 번호
	public static int distance[]; // 다익스트라 알고리즘을 사용할 거리배열
	public static boolean visited[]; // 방문체크 배열
	public static ArrayList<Edge> list[]; // 그래프 정보를 저장하는 인접리스트
	public static PriorityQueue<Edge> q = new PriorityQueue<Edge>(); 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		distance = new int[V+1];
		visited = new boolean[V+1];
		list = new ArrayList[V+1];
		for (int i = 1; i <= V; i++) 
			list[i] = new ArrayList<Edge>(); // 인접 리스트 초기화
		for (int i = 0; i <= V; i++) {
			distance[i] = Integer.MAX_VALUE; // 거리배열 최대로 큰수로 초기화
		}
		for (int i = 0; i < E; i++) { // 가중치가 있는 인접 리스트 초기화하기
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Edge(v, w));
		}
		q.add(new Edge(K, 0)); // K를 시작점으로 설정
		distance[K] = 0; // 거리배열 시작점 인덱스를 0으로 초기화
		while(!q.isEmpty()) { // 큐가 빌때까지
			Edge current = q.poll();
			int c_v = current.vertex;
			if (visited[c_v]) continue; //이미 방문한 노드는 건너뜀
			visited[c_v] = true; // 방문하지 않은 노드는 방문배열 true로 변경
			for (int i = 0; i < list[c_v].size(); i++) { // 현재 선택 노드의 에지 개수만큼 반복
				Edge tmp = list[c_v].get(i);
				int next = tmp.vertex;
				int value = tmp.value;
				if (distance[next] > distance[c_v] + value) { // 최소값으로 거리배열 업데이트
					distance[next] = value + distance[c_v];
					q.add(new Edge(next, distance[next]));
				}
			}}
		for (int i = 1; i <= V; i++) { // 거리배열 출력
			if (visited[i])
				System.out.println(distance[i]);
			else
				System.out.println("INF");
		}}}
class Edge implements Comparable<Edge> {
	int vertex, value;
	Edge(int vertex, int value) {
		this.vertex = vertex;
		this.value = value;
	}
	public int compareTo(Edge e) {
		if (this.value > e.value) return 1;
		else return -1;
	}
}
