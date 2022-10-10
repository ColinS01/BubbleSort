import java.io.FileWriter;
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        boolean active = true;
        while(active){
            System.out.println("Bubble sorter");
            System.out.println("Enter 1 to Write the Array to the data.txt file");
            System.out.println("Enter 2 to Read data from data.txt");
            System.out.println("Enter 3 to use bubble sort algorithm to sort the array");
            System.out.println("Enter a number 1-3 or 0 to Quit: ");
            String choice = input.nextLine();
    
            String filename = "C:\\Users\\Colin.Smith\\Personal Projects\\BubbleSort\\BubbleSort\\src\\data.txt"; 
            int [] nums = random_ints(10);

            if (choice.equals("1")){
                writeArrayToFile(nums, filename);
    
            }
            else if (choice.equals("2")){
                nums = readFileToArray(filename);
    
            }
            else if (choice.equals("3")){
                bubbleSort(nums);
    
            }

            else if (choice.equals("0")){
                active = false;
            }
        }
        

        
        input.close();

    }

    public static int[] random_ints(int arrayLength){
        Random rand = new Random();
        int[] nums = new int[arrayLength];
        
        for( int i = 0; i < arrayLength; i++){
            nums[i] = rand.nextInt(100);
        }

        return nums;
    }

    public static void writeArrayToFile(int[] array, String filename) throws Exception{
        FileWriter writer = new FileWriter(filename);
        int len = array.length;
        int nums[] = array;
        for(int i = 0; i < len; i++){
            writer.write(nums[i] + "\n");
        }
        writer.close();

    }

    public static int[] readFileToArray(String filename){
        File file = new File(filename);
        Scanner myReader;
        int nums[] = new int[10];
        try {
            myReader = new Scanner(file);
            while(myReader.hasNextLine()){
                for(int i = 0; i< nums.length; i++)
                    {String data = myReader.nextLine();
                    nums[i] = Integer.parseInt(data);}
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return nums;

    }

    public static void bubbleSort(int[] array){
        int n = array.length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n - i - 1; j++)
                if(array[j] > array[j + 1]){
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
        for(int x = 0; x < n; x++){
            System.out.println(array[x]);
        }
    }
}
