import java.util.Scanner;

public class BJ1541 {

	public static void main(String[] args) {
		
		Scanner SC = new Scanner(System.in);
		
		//'-'�� ����
		String[] strArr = SC.nextLine().split("-");		
	
		//'-'�� ���е� ���� ����Ѵ�.
		for (int i = 0; i < strArr.length; i++) {
			int tempSum = 0;
			String[] tempArr =  strArr[i].split("\\+");
			//'+'��� �ݺ���
			for (int j = 0; j < tempArr.length; j++) {
				tempSum += Integer.parseInt(tempArr[j]);
			}
			strArr[i] = Integer.toString(tempSum);
		}
		
		//���� ���� ���̳ʽ�(-)���ش�.
		int iValue = 0;
		for (int i = 0; i < strArr.length; i++) {
			if(i==0) //ù��°�� �÷���(+)�ؾ���
				iValue += Integer.parseInt(strArr[i]);
			else
				iValue -= Integer.parseInt(strArr[i]);
		}
		System.out.println(iValue);

	}

}
