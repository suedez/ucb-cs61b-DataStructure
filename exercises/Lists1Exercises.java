public class Lists1Exercises {
    /** Returns an IntList identical to L, but with
      * each element incremented by x. L is not allowed
      * to change. */
    public static IntList incrList(IntList L, int x) {
        if(L == null) {
            return L;
        }
        else {
            IntList r = incrList(L.rest, x);
            IntList newL = new IntList(L.first + x, r);
            return newL;
        }           
    }

    /** Returns an IntList identical to L, but with
      * each element incremented by x. Not allowed to use
      * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        if(L == null) {
            return L;
        }
        else {
            L.first = L.first + x;
            dincrList(L.rest, x);
            return L;
        }
        /*using iteration
        IntList l = L;
       while(l != null) {
        l.first = l.first + x;
        l = l.rest;
       }
       return L;
       **/
    }

    public static void main(String[] args) {
        /* testing **/
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
        
        IntList L2 = new IntList(15, null);//if you use old L, with the change of L happened through dincrList, the result from inceList will be changed.ss
        L2 = new IntList(10, L2);
        L2 = new IntList(5, L2);

        System.out.println(L.get(3));
        System.out.println(L2.get(3));
        System.out.println(L.size());
        System.out.println(L.iterativeSize()); 
        System.out.println(dincrList(L,2).get(3));
        System.out.println(incrList(L2,2).get(3));    
    }
}
