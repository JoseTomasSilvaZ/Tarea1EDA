import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'calcularFase' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING pInicial
     *  2. STRING pActual
     */

    public static int calcularFase(String pInicial, String pActual) {
    char[] initialPositions = new char[4];
            char[] actualPositions= new char[4];
            char[] auxPositions;
            for(int i=0; i<4; i++){
                initialPositions[i]=pInicial.charAt(i);
                actualPositions[i]=pActual.charAt(i);
            }
            auxPositions=initialPositions;
            char prevFirstBackPosition;
            char prevSecondBackPosition;
            int counter=0;

            if(Arrays.equals(initialPositions, actualPositions)){
                counter=1;
            }
            else{
                for(int i=0; i<3; i++){
                    prevFirstBackPosition=auxPositions[2];
                    prevSecondBackPosition=auxPositions[3];
                    auxPositions[2]=auxPositions[0];
                    auxPositions[3]=auxPositions[1];
                    auxPositions[0]=prevSecondBackPosition;
                    auxPositions[1]=prevFirstBackPosition;
                    boolean equals= Arrays.equals(auxPositions, actualPositions);
                    if(equals){
                        counter=i+2;
                    }
                }
            }
            if(counter==0){
                return -1;
            }
            else{
                return counter;
            }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String inicial = bufferedReader.readLine();

        String actual = bufferedReader.readLine();

        int resFase = Result.calcularFase(inicial, actual);

        bufferedWriter.write(String.valueOf(resFase));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}

