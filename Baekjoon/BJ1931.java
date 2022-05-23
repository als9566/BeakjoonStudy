import java.util.Scanner;
import java.util.Arrays;
import java.util.Comparator;
 
public class BJ1931 {
 
	public static void main(String[] args) {
 
		Scanner SC = new Scanner(System.in);
		
		int N = SC.nextInt();
		
		int[][] time = new int[N][2];		
		
		for(int i = 0; i < N; i++) {
			time[i][0] = SC.nextInt();	// ���۽ð� 
			time[i][1] = SC.nextInt();	// ����ð� 
		}
		
		
		// ������ �ð��� �������� �����ϱ� ���� compare ������
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				// ����ð��� ���� ��� ���۽ð��� ���������� ����
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		
		int CNT = 0;
		int temp_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			// ���� ����ð��� ���� ȸ�� ���� �ð����� �۰ų� ���ٸ� ���� 
			if(temp_end_time <= time[i][0]) {
				temp_end_time = time[i][1]; // �����ܰ迡�� ���۽ð��� ���ϱ����� ����ð��� ������ ����ش�. 
				CNT++;
			}
		}
		
		System.out.println(CNT);
	}
 
}