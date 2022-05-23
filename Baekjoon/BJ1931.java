import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
public class BJ1931 {
 
	public static void main(String[] args) {
 
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int[][] time = new int[N][2];		
		
		for(int i = 0; i < N; i++) {
			time[i][0] = SC.nextInt();	// 시작시간 
			time[i][1] = SC.nextInt();	// 종료시간 
		}
		
		
		// 끝나는 시간을 기준으로 정렬하기 위해 compare 재정의
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// 종료시간이 같을 경우 시작시간이 빠른순으로 정렬
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		
		int CNT = 0;
		int temp_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신 
			if(temp_end_time <= time[i][0]) {
				temp_end_time = time[i][1]; // 다음단계에서 시작시간과 비교하기위해 종료시간을 변수로 담아준다. 
				CNT++;
			}
		}
		
		System.out.println(CNT);
	}
 
}