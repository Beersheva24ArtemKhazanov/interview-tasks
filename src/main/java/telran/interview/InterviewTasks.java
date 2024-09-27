package telran.interview;

import java.util.*;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprise of two numbers, summing of which gives
     *         the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        boolean res = false;
        if (array.length == 2) {
            res = Arrays.stream(array).sum() == sum;
        }
        return res;
    }
}
