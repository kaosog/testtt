/**
 * FindMedian uses Quicksort partition in order to sort only the first half of the array and then return the median
 * method to make a faster quicksort that only sorts the first half in order to find the median
 * @author Tallon Pelikan, Kevin Relich
 * //@bugs none
 **/
public class FindMedian {

        /**
         * Takes an input array which will then be sent to modQuickSort based on whether it has an even or odd amount of integers
         * @param array input array which will be sorted
         * @return the median of the array
         */
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

        /**
         * Modified version of QuickSort from Algs4 which will sort only half the array
         * @param array input array to be sorted
         * @param lo the lowest access point in the array
         * @param hi the highest access point of the array
         * @param medIndex used to determine if the partition has reached the medIndex which will always be the same in this recurssive method
         * @return the int which is at the median
         */
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

        /**partition the subarray a[lo..hi] so that a[lo..j-1] <= a[j] <= a[j+1..hi]
         * and return the index j.
         * @param a input array
         * @param lo lowest index of array
         * @param hi highest index of array
         * @return the integer which was partitioned
         */
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

        /**
         * exchange a[i] and a[j]
         * @param a input array
         * @param i index which will be exchanged with j
         * @param j index which will be exchanged with i
         */
        private static void exch(int[] a, int i, int j) {
                int swap = a[i];
                a[i] = a[j];
                a[j] = swap;
        }

        /**
         * Compares two numbers to see if one is smaller or equal
         * @param v compared with w
         * @param w compared with v
         * @return true or false based on whether v is smaller than w
         */
        private static boolean less(int v, int w) {
                if (v == w) return false;   // optimization when reference equals
                return v < w;
        }


}
