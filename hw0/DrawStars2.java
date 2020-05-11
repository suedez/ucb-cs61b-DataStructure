public class DrawStars2 {
   public static void drawTriangle(int N) {
   	int size = N;
   	int rowN = 1;
   	while(rowN <= size) {
			int colN = 0;
			while(colN < rowN) {
				System.out.print("*");
				colN = colN + 1;
			}
			while(colN == rowN) {
				System.out.print("\n");
				colN = colN + 1;
			}
			rowN = rowN + 1;
   }
  }
  public static void main(String[] args){
  	drawTriangle(10);
  }
   
}