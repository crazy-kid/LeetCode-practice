package JAVA.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.ArrayList;

public class test {

    public static void main(String[] args) {
        int[] list = { 1, 2, 3, 4, 5, 6, 7 };
        HashSet<List<Integer>> map = new HashSet<List<Integer>>();
        List<Integer> l1 = new ArrayList<Integer>();
        l1.add(1);
        l1.add(2);
        map.add(l1);
        List<Integer> l2 = new ArrayList<Integer>();
        l2.add(1);
        l2.add(2);
        System.out.println(l1.hashCode());
        System.out.println(l2.hashCode());
        System.out.println(map.contains(l2));

        String a = "abc";
        String b = "abc";
        System.out.println(a.hashCode() == b.hashCode());
    }
}
