package magicbinary.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Leet2215 {

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> ansList = new ArrayList<>();

        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());

        ansList.add(set1.stream().filter(e -> !set2.contains(e)).collect(Collectors.toList()));
        ansList.add(set2.stream().filter(e -> !set1.contains(e)).collect(Collectors.toList()));
        return ansList;
    }

    public static void main(String[] args) {

    }
}
