import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Random rand = new Random();
        Scanner in = new Scanner(System.in);

        int[] dataPoints = new int[100];

        for (int i = 0; i < dataPoints.length; i++) {
            dataPoints[i] = rand.nextInt(100) + 1;
        }

        for (int i = 0; i < dataPoints.length; i++) {
            System.out.printf("%d | ", dataPoints[i]);
        }

        int average = 0;
        int sum = 0;

        for (int i = 0; i < dataPoints.length; i++) {
            sum = sum + dataPoints[i];
        }
        average = sum / dataPoints.length;

        System.out.println("\nThe sum of the values in the array is: " + sum);
        System.out.println("The average of the values in the array is: " + average);

        int userNumber = Main.getRangedInt(in, "What value are you looking for?", 0, 100);


        int occurrences = 0;
        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] == userNumber) {
                occurrences = occurrences + 1;
            }
        }
        System.out.println("Your number appears " + occurrences + " times.");

        int userNumber2 = Main.getRangedInt(in, "What other value are you looking for?", 0, 100);

        boolean found = false;
        int index=0;
        for(int i = 0;i< dataPoints.length;i++){

            if (dataPoints[i] == userNumber2) {
                found = true;
                index = i;
                break;
            }
        }            if (found){
            System.out.printf("%n%d exists at index %d",userNumber2,index);
        }   if (!found){
            System.out.println("The number you are looking for is not in the array");
        }

        int maxNumber = Integer.MIN_VALUE;

        for (int i = 0; i < dataPoints.length; i++) {
            if (dataPoints[i] > maxNumber) {
                maxNumber = dataPoints[i];
            }
        }
        System.out.println();
        System.out.println("The maximum number in the loop is:" + maxNumber);


        int minNumber = Integer.MAX_VALUE;

        for (int dataPoint : dataPoints) {
            if (dataPoint < minNumber) {
                minNumber = dataPoint;

            }
        }
        System.out.println("The minimum number in the loop is:" + minNumber);

        System.out.println("Average of dataPoints is: " + getAverage(dataPoints));



    }
    public static double getAverage(int[] values){
        double sum = 0;
        double average = 0;
        for (int i = 0; i < values.length; i++) {
            sum = sum + values[i];
        }
        average = sum / values.length;

        return average;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high){
        int retVal = 0;
        String trash;
        boolean done=false;

        do{
            System.out.println("\n" + prompt);
            if(pipe.hasNextInt()){
                retVal = pipe.nextInt();
                pipe.nextLine(); //Clear the buffer

                if(retVal >= low && retVal<=high){
                    done = true;
                }else{
                    System.out.println("\n The number is out of range [" +low + "-" + high +"]:" + retVal);
                }

            }else{
                trash=pipe.nextLine();
                System.out.println("You must enter an integer! You entered : " + trash);
            }
        }while(!done);
        return retVal;
    }



}