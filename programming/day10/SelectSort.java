public class SelectSort<T extends Comparable> implements ISort<T>{
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public  void sort(T[] in) {
        T holder;
        for (int i = 0; i < in.length - 1; i++) {
            //CASE FOR IF ITS EQUAL TO
            int idx = i;
            for (int j = i + 1; j < in.length; j++) {
                if (in[j].compareTo(in[idx]) < 0) {
                    idx = j;
                }
            }
            holder = in[idx];
            in[idx] = in[i];
            in[i] = holder;
        }
    }

    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName(){
        return "Select Sort";
    }
}