
public class Lab1Main {
	private static final int SUM=15; // for in-lab exercise

	public static void main(String[] args) {		
	    gameDemo();
	    //extraDemo();
	}
	
	
	public static void gameDemo() {	
	   // uncomment below to test your Game class
	   Game game = new Game();
	   game.play();
	}
	
	
	public static void extraDemo() {
		// In-lab assignments.
		// add method calls to test your in-lab questions.
		puzzleVersion1();
		puzzleVersion2();
	}
	
	// add methods for in-lab questions below
	
	private static void puzzleVersion1() {
		int a,b,c,d;
		int temp;
		int count = 0;
		for(int i=1000; i<10000 ;i++) {
			d = i%10;
			temp = (i-d) / 10;
			c = temp%10;
			temp = (temp-c) / 10;
			b = temp%10;
			temp = (temp-b) / 10;
			a = temp%10;
			if(a+b+c+d == 15) {
				if(a != b && a != c && a != d) {
					if(b != c && b != d && c != d) {
						if(d%2 == 1) {
							if(a == 3*c) {
								count++;
								System.out.printf("%d%d%d%d%n", a, b, c, d);
							}
						}
					}
				}
			}
		}
		
		System.out.printf("Number of Solutions %d%n", count);
	}
	
	private static void puzzleVersion2() {
		int count = 0;
		int loopCount = 0;
		for(int i=1 ; i<10 ; i++) {
			for(int j=0 ; j<10 ; j++) {
				if(j == i || i+j >= 15)  //eliminating impossible iterations
					continue;
				
				for(int k=0 ; k<10 ; k++) {
					if(3*k != i || k == j || i+j+k >= 15)	//eliminating impossible iterations
						continue;
					
					for(int l=1 ; l<10 ; l+=2) {
						loopCount++;
						if(l==i || l==j || l==k)
							continue;
						if(i+j+k+l == 15) {
							System.out.printf("%d%d%d%d%n", i, j, k, l);
							count++;
						}
					}
				}
			}
		}
		System.out.printf("Number of Solutions %d%n", count);
		System.out.printf("Innermost Loop body is executed %d times%n", loopCount);
	}
	
	private static boolean isValid(int a, int b, int c , int d) {
		if(a+b+c+d == 15) {
			if(a != b && a != c && a != d) {
				if(b != c && b != d && c != d) {
					if(d%2 == 1) {
						if(a == 3*c) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
}



















