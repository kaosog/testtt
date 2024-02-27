import edu.princeton.cs.algs4.StdRandom;
import java.util.*;
/**
 * Used to test the speed results from modified quicksort and typical sort to ensure the speed is faster by only sorting half the array
 *  Timing is completed using system.time;
 * @author Tallon Pelikan, Kevin Relich
 * //@bugs none
 **/
public class FindMedianTest {
    public static void main (String [] args) throws Throwable {
        double result;

        //first set of tests which will be completed using basic sort
        int[] size = {10, 50, 1000000, 5000000};
        // Sort and print a few small arrays to make certain the sort works
        SortandMedian(size[0], size[1], 10);
        // Sort and time larger arrays
        SortandMedian(size[2], size[3], 1000000);
        // Sort and time larger arrays
        SortandMedian(size[2]+1, size[3]+1, 1000000);

        //second set of tests which will be completed using our modified sort
        System.out.println("\nSECOND TESTING");
        int[] size2 = {10, 50, 1000000, 5000000};
        // Sort and print a few small arrays to make certain the sort works
        SortandMedianModified(size2[0], size2[1], 10);
        // Sort and time larger arrays
        SortandMedianModified(size2[2], size2[3], 1000000);
        // Sort and time larger arrays
        SortandMedianModified(size2[2]+1, size2[3]+1, 1000000);

    }

    /**
     * First timed test which will use Arrays.sort;
     * @param start beginning of array
     * @param end ending of array
     * @param inc the amount of numbers in array
     * @throws Throwable due to createRandomArray throwing a error possibly
     */
    public static void SortandMedian(int start, int end, int inc) throws Throwable
    {
        double result;
        for (int size = start; size<=end; size+=inc) {
            int [] array = createRandomArray(size);
            System.gc();
            long startTime = System.nanoTime();
            //Instructor's implementation of sort
            Arrays.sort(array); // You will call findMedian method from FindMedian class
            result = array[array.length/2];
            long endTime = System.nanoTime();
            System.out.println ("Array size = " + size +
                    "\tMedian = " + result +
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
        }
    }

    /**
     * Second timed test which will use Our modified sorting method;
     * @param start beginning of array
     * @param end ending of array
     * @param inc the amount of numbers in array
     * @throws Throwable due to createRandomArray throwing a error possibly
     */
    public static void SortandMedianModified(int start, int end, int inc) throws Throwable
    {
        double result;
        for (int size = start; size<=end; size+=inc) {
            int [] array = createRandomArray(size);
            System.gc();
            long startTime = System.nanoTime();
            //Instructor's implementation of sort
             // You will call findMedian method from FindMedian class
            result = FindMedian.findMedian(array);;
            long endTime = System.nanoTime();
            System.out.println ("Array size = " + size +
                    "\tMedian = " + result +
                    "\tSearch time = " +
                    (endTime-startTime)/1000000000.0 + " seconds");
        }
    }
    // This method reads creates an array of random integers
    public static int[] createRandomArray(int size) throws Throwable {
        Random r = new Random(50);
        int [] array = new int [size];
        for (int i=0; i<size; i++) {
            array[i] = StdRandom.uniform(100000);
        }
        return array;
    }
}
