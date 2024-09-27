package telran.interview;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InterviewTasksTest {
    
    @Test
    void hasSumTwoTest() {
        int sum = 26;
        int[] array1 = {17, 9};
        int[] array2 = {17};
        int[] array3 = {17, 6, 3};
        int[] array4 = {17, 19};
        assertTrue(InterviewTasks.hasSumTwo(array1, sum));
        assertFalse(InterviewTasks.hasSumTwo(array2, sum));
        assertFalse(InterviewTasks.hasSumTwo(array3, sum));
        assertFalse(InterviewTasks.hasSumTwo(array4, sum));
    }
}
