import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.PrintWriter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main{
    public static void main(String[] args) {
        File file = new File("test.txt");
        QuickSortTests temp;

        Integer[] array = {6,5,4,7,3,1,7,8,9,};
        QuickSortTests.sortFirstHalf(array);
        int t = 0;
        try {
            PrintWriter fileOut = new PrintWriter(file);
            for(int i =0; i<16000;i++){

                fileOut.println(i);
            }

            fileOut.close();
        }catch(Exception y){System.out.println("nope");}

    }
}