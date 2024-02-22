public class FindMedian {
//    public static double findMedian(int[] array){
//        double x = array.length/2;
//        if(x%2==0){
//
//        }else{
//            return array[x];
//        }
//    }

        public static Comparable findMedian(Comparable[] array){
                int medIndex = array.length / 2; // Where the index of the median is expected
                if (array.length % 2 == 0){  //Array has an even number of elements
                        //Need two middle values and take average
                        Comparable firstMiddle = modQuickSort(array, 0, array.length -1, medIndex);
                        Comparable secondMiddle = modQuickSort(array, 0, array.length - 1, medIndex -1);
                        return ((int)firstMiddle + (int)secondMiddle)/2; //Find average and return
                }
                //For odd sized arrays
                else return modQuickSort(array, 0, array.length - 1, medIndex);
        }

        public static Comparable modQuickSort(Comparable[] array, int lo, int hi, int medIndex){
                if(hi <= lo)
                        return array[lo]; // If pivot is median

                int partitionIndex = QuickSort.partition(array, lo, hi);

                if(medIndex < partitionIndex)
                        return modQuickSort(array, lo, partitionIndex - 1, medIndex); //Search left subarray
                else if (medIndex > partitionIndex)
                        return modQuickSort(array,partitionIndex + 1, hi, medIndex); //Search right subarray
                else
                        return array[partitionIndex]; // Partition index is at the expected medIndex
        }
}
