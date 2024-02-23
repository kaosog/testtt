public class FindMedian {
//    public static double findMedian(int[] array){
//        double x = array.length/2;
//        if(x%2==0){
//
//        }else{
//            return array[x];
//        }
//    }

        public static void main(String[] args){
                int[] array = {1,2,3,4,5,6,7,8,9};
                Stopwatch timer = new Stopwatch();
                System.out.println(findMedian(array));
                System.out.println(timer.elapsedTime());

        }

        public static double findMedian(int[] array){
                int medIndex = array.length / 2; // Where the index of the median is expected
                if (array.length % 2 == 0){  //Array has an even number of elements
                        //Need two middle values and take average
                        int firstMiddle = modQuickSort(array, 0, array.length -1, medIndex);
                        int secondMiddle = modQuickSort(array, 0, array.length - 1, medIndex -1);
                        return (double) (firstMiddle + secondMiddle)/2; //Find average and return
                }
                //For odd sized arrays
                else return modQuickSort(array, 0, array.length - 1, medIndex);
        }

        public static int modQuickSort(int[] array, int lo, int hi, int medIndex){
                if(hi <= lo)
                        return array[lo]; // If pivot is median

                int partitionIndex = partition(array, lo, hi);

                if(medIndex < partitionIndex)
                        return modQuickSort(array, lo, partitionIndex - 1, medIndex); //Search left subarray
                else if (medIndex > partitionIndex)
                        return modQuickSort(array,partitionIndex + 1, hi, medIndex); //Search right subarray
                else
                        return array[partitionIndex]; // Partition index is at the expected medIndex
        }
        public static int partition(int[] a, int lo, int hi) {
                int i = lo;
                int j = hi + 1;
                int v = a[lo];
                while (true) {

                        // find item on lo to swap
                        while (less(a[++i], v)) {
                                if (i == hi) break;
                        }

                        // find item on hi to swap
                        while (less(v, a[--j])) {
                                if (j == lo) break;      // redundant since a[lo] acts as sentinel
                        }

                        // check if pointers cross
                        if (i >= j) break;

                        exch(a, i, j);
                }

                // put partitioning item v at a[j]
                exch(a, lo, j);

                // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
                return j;
        }
        private static void exch(int[] a, int i, int j) {
                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
        }

        private static boolean less(int v, int w) {
                if (v == w) return false;   // optimization when reference equals
                return v < w;
        }
}
