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
     * Complete the 'maxDias' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER N
     *  2. INTEGER p
     *  3. INTEGER q
     *  4. INTEGER r
     */

    public static int maxDias(int N, int p, int q, int r) {
        //hago un array bidimensional, donde la primera row son los dias
        //el siguiente row son los dias cuando pide la empresa A. '1' es que pide, '0' es que no pide.
        //el siguiente row son los dias que pide la empresa B.
        //el siguiente row son los dias que pide la empresa C.
        //si al sumar el comportamiento de las 3 empresas en el mismo dia da algo distinto de 1, implica que no se 
        //puede utilizar ese dia
        int[][]calendar = new int[4][N];
        int counter=0;
        for(int i=0; i<N; i++){
            calendar[0][i]=i+1;
            if((i+1)%p==0){
                calendar[1][i]=1;
            }
            if((i+1)%q==0){
                calendar[2][i]=1;
            }
            if((i+1)%r==0){
                calendar[3][i]=1;
            }
            if(calendar[1][i]+calendar[2][i]+calendar[3][i]== 1){
                counter++;
            }
        }
        return counter;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, T).forEach(TItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int dias = Integer.parseInt(firstMultipleInput[0]);

                int A = Integer.parseInt(firstMultipleInput[1]);

                int B = Integer.parseInt(firstMultipleInput[2]);

                int C = Integer.parseInt(firstMultipleInput[3]);

                int resultado = Result.maxDias(dias, A, B, C);

                bufferedWriter.write(String.valueOf(resultado));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

