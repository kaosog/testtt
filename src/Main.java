import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 * This assignment combines two projects
 * <p>
 * First being FindMedian which uses Quicksort partition
 * method to make a faster quicksort that only sorts the first half in order to find the median
 * <p>
 *  Second being Stopwatch and ThreeSumFast which are used to record time data based on input
 *  with this data a power law and double hypothesis equation is calculated
 * @author Tallon Pelikan, Kevin Relich
 * //@bugs none
 **/

public class Main{
    public static void main(String[] args) {
//        //test array for FindMedian
//        int[] array = {6,5,4,7,3,1,7,8,9,5,7,5,3,2,4,6,9,1,2,3,4,5,6,7,8};
//        System.out.println(FindMedian.findMedian(array));


        //Attaches a test file to write data to such file which will then be used by ThreeSumFast
        File file = new File("test.txt");
        try {
            PrintWriter fileOut = new PrintWriter(file);
            for(int i =0; i<1000000;i++){

                fileOut.println(i);
            }
            fileOut.close();
        }catch(Exception y){System.out.println("nope");}
    }
}