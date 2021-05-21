package heap;
/**
 * *********************************************IMPORTANT******************************************
 * //problem link : https://practice.geeksforgeeks.org/problems/rearrange-characters5322/1/?track=SPC-Heap&batchId=154
 */



import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class RearrangeStringToNonConsecutive {
    public static void main(String[] args) {
        System.out.println(rearrangeCharacters("geeksforgeeks"));
    }
    static class data{
        Character ch;
        int freq;
        public data( Character ch,int freq ){
            this.ch =ch;
            this.freq =freq;
        }
        public void update(){
            freq--;
        }
    }
    //time complexity o(nlogn)
    // approach : use max heap, take out 2 maximum occurring character and append to a new string , do this untill the pq size is <2
    // now heap either contains 0 character ot 1 character , if 0 then we are done , if 1 then check its frequency , if >1 then return false
    // now if the new string size == given string return true
    static boolean rearrangeCharacters(String str) {
        Map<Character , Integer> map = new HashMap<>();
        for(int i = 0;i<str.length();i++){
            Character c = str.charAt(i);
            if(map.containsKey(c))map.put(c , map.get(c)+1);
            else map.put(c ,1);
        }
        PriorityQueue<data> pq = new PriorityQueue<>(new Comparator<data>() {
            @Override
            public int compare(data d1, data d2) {
                return d2.freq-d1.freq;
            }
        });
        for(Character ch : map.keySet())
            pq.add(new data(ch , map.get(ch)));
        StringBuilder temp = new StringBuilder();
        while(pq.size()>=2){
            data d1 = pq.poll();
            data d2 = pq.poll();
            temp.append(d1.ch).append(d2.ch);
            d1.update();
            d2.update();;
            if(d1.freq>0)
                pq.add(d1);
            if(d2.freq>0)
                pq.add(d2);
            System.out.println(temp);

        }
        if(pq.size()==1){
          data d = pq.poll();
          if(d.freq>1)return false;
          else
              temp.append(d.ch);
        }
        return temp.length()==str.length();


    }
}

