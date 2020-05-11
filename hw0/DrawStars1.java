public class DrawStars1 {
	public static void main (String[] args) {
		int size = 5;
		int rowN = 1;
		while(rowN <= size) {
			int colN = 0;
			while(colN < rowN) {
				System.out.print("*");
				colN = colN + 1;
			}
			while(colN == rowN) {
				System.out.print('\n');
				colN = colN + 1;
			}
			rowN = rowN + 1;
		}
	}
}