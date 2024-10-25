package telran.interview;

import java.time.LocalDate;
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
        HashSet<Integer> set = new HashSet<>();
        int i = 0;
        while (i < array.length && !set.contains(sum - array[i])) {
            set.add(array[i++]);
        }
        return i != array.length;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        int res = -1;
        for (int num : array) {
            res = set.contains(-num) ? Math.max(res, Math.abs(num)) : -1;
            set.add(num);
        }
        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        TreeMap<LocalDate, String> tree = new TreeMap<>();
        List<DateRole> res = new ArrayList<DateRole>();
        rolesHistory.stream().forEach(item -> tree.put(item.date(), item.role()));
        for (LocalDate date : dates) {
            String role = tree.floorKey(date) != null ? tree.get(tree.floorKey(date)) : null;
            DateRole dateRole = new DateRole(date, role);
            res.add(dateRole);
        }
        return res;
    }

    public static boolean isAnagram(String word, String anagram) {
        Map<Character, Integer> map = new HashMap<>();
        boolean res = word.equals(anagram) ? false : true;
        for (char l : word.toCharArray()) {
            map.put(l, map.getOrDefault(l, 0) + 1);
        }

        for (char l : anagram.toCharArray()) {
            map.put(l, map.getOrDefault(l, 0) - 1);
        }

        for (int i : map.values()) {
            if (i != 0) {
                res = false;
            }
        }
        return res;
    }
}
