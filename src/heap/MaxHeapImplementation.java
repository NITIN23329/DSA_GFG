package heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class MaxHeap{
    int last;
    int[] maxHeapArray;
    public MaxHeap(int size){
        maxHeapArray = new int[size];
        last = -1;
    }
    public void insert(int data){           //log(n)
        last++;
        maxHeapArray[last] = data;
        pushUp(last);
    }
    private void pushUp(int child){
        if(child==0)return;
        int parent = (child-1)/2;
        if(maxHeapArray[parent]< maxHeapArray[child]){
            swap(parent , child);
            pushUp(parent);
        }
    }
    private void swap(int a , int b){
        int temp = maxHeapArray[a];
        maxHeapArray[a] = maxHeapArray[b];
        maxHeapArray[b] = temp;
    }
    public int getMax(){
        if(last==-1)return -1;
        return maxHeapArray[0];
    }
    public int delete(){       //log(n)
        int max = maxHeapArray[0];
        swap(0 , last);
        last--;
        pushDown(0);
        return max;
    }
    private void pushDown(int parent){
        int leftChild = 2*parent+1;
        int rightChild  = 2*(parent+1);
        if(leftChild>last && rightChild>last)return;
        if(rightChild>last){
            if(maxHeapArray[parent]< maxHeapArray[leftChild])
                swap(parent,leftChild);
            return;
        }
        if(maxHeapArray[leftChild]> maxHeapArray[rightChild] && maxHeapArray[parent]< maxHeapArray[leftChild]){
            swap(parent , leftChild);
            pushDown(leftChild);
        }
        else if(maxHeapArray[parent]< maxHeapArray[rightChild]){
            swap(parent,rightChild);
            pushDown(rightChild);
        }

    }
    public void decrease(int index , int newValue){  //log(n)
        maxHeapArray[index] = newValue;
        pushDown(index);
    }

}
    /**
     * build heap takes O(n) time; not O(nlogn)
     * arr is a given random array , convert it to max heap array.
     *  void buildHeap(int arr[], int n)
     *     {
     *         for(int i =(n-2)/2 ; i>=0;i--) // i = (last-1)/2 would also work
     *             pushDown(arr , i , n-1);
     *
     *     }
      */


public class MaxHeapImplementation {
    public static void main(String[] args) {
        int[] array=new int[]{50,30,20,15,10,8,16 ,60,8,20,15};
        int n = array.length;
        MaxHeap maxHeap = new MaxHeap(n);
        int i = 0;
        while (i<n){
            maxHeap.insert(array[i]);
            i++;
        }
        System.out.println(Arrays.toString(maxHeap.maxHeapArray));
        maxHeap.decrease(4,5);
        System.out.println(Arrays.toString(maxHeap.maxHeapArray));
        while (n-->0){
            System.out.println(maxHeap.delete());
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return 0;
            }
        });
        int[] arr = new int[]{1,2};


    }

}
