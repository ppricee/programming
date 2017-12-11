public class MergeSort<T extends Comparable> implements ISort<T> {
    public void sort(T[] in) {
        T[] temporary = (T[]) new Comparable[in.length];
        temporary = Merger(in);
        for(int i = 0; i< in.length;i++){
            in[i] = temporary[i];
        }
    }

    public T[] Merger(T[] in) {
        if (in.length <= 1) {
            //base case for recursive call
            return in;
        }
        int mid = in.length / 2;
        //Creates 2 temporary arrays
        T[] temp1 = (T[]) new Comparable[mid];
        T[] temp2 = (T[]) new Comparable[mid+(in.length%2)];
        int counter = 0;
        //Splits the inputted list into two subLists
        for (int i = 0; i < in.length; i++) {
            if (i < mid) {
                //left subList
                temp1[i] = in[i];
            }

            else {
                //right subList
                temp2[counter] = in[i];
                counter++;
            }
        }
        //Recursive call
        temp1 = Merger(temp1);
        temp2 = Merger(temp2);
        return merge(temp1, temp2);
        }



    public T[] merge(T[] temp1, T[] temp2) {
        //temp integer is length of merged array
        int temp = temp1.length + temp2.length;
        System.out.println(temp);
        T[] merged = (T[]) new Comparable[temp];
        //keeps track of index for temp1 array
        int counter1 = 0;
        //keeps track of index for temp2 array
        int count2 = 0;

        for (int i = 0; i < temp; i++) {
            //Sorts the values in the array
            if (counter1 >= temp1.length) {
                System.out.println("temp1 list done...Adding to merged with temp2");
                //If left list is merged
                merged[i] = temp2[count2];
                count2++;
            } else if (count2 >= temp2.length) {
                System.out.println("temp2 list complete");
                //if right list is merged
                merged[i] = temp1[counter1];
                counter1++;
            } else if (temp1[counter1].compareTo(temp2[count2]) < 0) {
                System.out.println("Temp1 Compared to Temp2");

                //If temp1 value is less than temp2 value insert temp1 value in merged array
                merged[i] = temp1[counter1];
                counter1++;
            } else if (temp2[count2].compareTo(temp1[counter1]) < 0) {
                System.out.println("Comparing Temp2 to temp1");
                //If temp2 value is less than temp1 value insert temp2 value in merged array
                merged[i] = temp2[count2];
                count2++;
            }
        }
        return merged;

    }

    public String sortName() {
        return "Merge Sort";
    }
}