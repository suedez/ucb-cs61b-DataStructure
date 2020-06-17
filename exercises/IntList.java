public class IntList {
	public int first;
	public IntList rest;

	public IntList(int f, IntList r) {
		first = f;
		rest = r;
	}

	/** Return the size of the list using... recursion! */
	public int size() {
		if(this.rest == null){
			return 1;
		}
		else {
			return 1 + this.rest.size();
		}
	}

	/** Return the size of the list using no recursion! */
	public int iterativeSize() {
		int i = 0;
		IntList l = this;
		while(l != null ){
			l = l.rest;
			i += 1;
		}
		return i;
	}

	/** Returns the ith value in this list.*/
	public int get(int i) {
		if(i == 1){
			return this.first;
		}
		else {
			i -= 1;
			return this.rest.get(i);
		}
	}

	/* to test part above. Comment it to achieve further exercises
	public static void main(String[] args) {
		IntList L = new IntList(15, null);
		L = new IntList(10, L);
		L = new IntList(5, L);

		System.out.println(L.iterativeSize());
		System.out.println(L.size());
	}
	**/
}