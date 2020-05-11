/** extract the max value from an int array using for */
public class arrayMax2{
	public static int max2(int[] m){
		int indexMax = m.length - 1;
		int max = m[0];
		for(int i = 0; i <= indexMax; i = i+1){
			if(max < m[i]){
				max = m[i];
			}
		}
		return(max);
	}
	public static void main(String[] args){
		int[] m = new int[]{9, 2, 15, 2, 22, 10, 6};
		System.out.println(max2(m));
	}
}