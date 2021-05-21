package avlTree;

import java.util.TreeMap;

public class TreeMapImplementation {
    public static void main(String[] args) {
        TreeMap<String , Integer> treeMap = new TreeMap<>();
        treeMap.put("five" , 5);
        treeMap.put("one",1);
        treeMap.put("four" , 4);
        treeMap.put("two",2);
        treeMap.put("three" , 3);
        System.out.println(treeMap);
        System.out.println(treeMap.keySet());
        System.out.println(treeMap.entrySet());
        System.out.println(treeMap.values());
        treeMap.replace("five" , 5 , 55);
        System.out.println(treeMap);
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.firstEntry());
        System.out.println(treeMap.lastEntry());
        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.ceilingKey("oneee"));
        System.out.println(treeMap.ceilingEntry("fivz"));
        System.out.println(treeMap.floorKey("tax"));
        System.out.println(treeMap.floorEntry("abcd"));
        System.out.println(treeMap.pollLastEntry());
        System.out.println(treeMap);
        System.out.println(treeMap.headMap("three"));
        System.out.println(treeMap.tailMap("fouz"));
        System.out.println(treeMap.subMap("five" , "three"));
    }
}
