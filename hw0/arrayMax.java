/** extract the max value from an int array using while*/
public class arrayMax {
	public static int max(int[] m){
		int indexMax = m.length - 2;
		int index = 0;
		while(index <= indexMax) {
			if(m[index] > m[index + 1]){
				m[index + 1] = m[index];
			}
			index = index + 1;
		}
		return(m[m.length - 1]);
	}
	public static void main(String[] args){
		int[] m = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max(m));
	}
}