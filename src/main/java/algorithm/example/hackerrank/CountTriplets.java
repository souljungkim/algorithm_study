package algorithm.example.hackerrank;


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

public class CountTriplets {

    // Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
        /** Method A **/
        // long count = 0;
        // int length = arr.size();
        // for (int i=0; i<length; i++){
        //     for (int j=i+1; j<length; j++){
        //         if ((arr.get(i)*r) != arr.get(j))
        //             continue;
        //         for (int k=j+1; k<length; k++){
        //             if ((arr.get(j)*r) != arr.get(k))
        //                 continue;
        //             count++;
        //         }
        //     }
        // }
        // return count;

        /** Method B **/
        long count = 0;
        int length = arr.size();
        Map<Long, Long> potential = new HashMap<>();
        Map<Long, Long> counter = new HashMap<>();
        for (int i=0; i<length; i++) {
            long value = arr.get(i);
            long key = value / r;
            //Punch
            if (counter.containsKey(key) && value % r == 0){
                count += counter.get(key);
            }
            //Second Step
            if (potential.containsKey(key) && value % r == 0){
                long c = potential.get(key);
                counter.put(value, counter.getOrDefault(value, 0L) + c);
            }
            // Every number can be the start of a triplet.
            potential.put(value, potential.getOrDefault(value, 0L) + 1);
        }
        return count;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Long::parseLong)
                .collect(toList());

        long ans = countTriplets(arr, r);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
