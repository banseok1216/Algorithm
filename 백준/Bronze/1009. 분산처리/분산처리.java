import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int a,b,r;
		for(int k=0;k<T;k++) {
			a=s.nextInt();
			b=s.nextInt();
			r=1;
			
			for (int j=0;j<b;j++) r=(r*a)%10;
			if(r==0) r=10;
			System.out.println(r);
		}
		s.close();
	}
}