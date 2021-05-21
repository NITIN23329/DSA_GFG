package heap;

import java.util.Arrays;

class MinHeap{
    private int last;
    private int[] arr;

    public MinHeap(int size) {
        last = -1;
        arr = new int[size];
    }

    public void insert(int x){
        last++;
        arr[last] = x;
        pushUp(last);
    }

    private void pushUp(int child){
        int parent = (child-1)/2;
        if(arr[parent]>arr[child]) {
            swap(child, parent);
            pushUp(parent);
        }
    }

    private void swap(int x,int y){
        int t = arr[x];
        arr[x] = arr[y];
        arr[y] =t;
    }

    public int delete(){
        int small = arr[0];
        swap(0,last);
        last--;
        pushDown(0);
        return small;
    }

    private void pushDown(int parent) {
        int leftChild = 2*parent+1;
        int rightChild =2*parent+2;
        if(rightChild<=last && arr[leftChild]>arr[rightChild] && arr[parent]>arr[rightChild]){
            swap(rightChild,parent);
            pushDown(rightChild);
        }
        else if(leftChild<=last && arr[parent]>arr[leftChild]){
            swap(leftChild,parent);
            pushDown(leftChild);
        }
    }

    public void increase(int i,int k){
        arr[i]=+k;
        pushDown(i);
    }

    public void decrease(int i,int k){
        arr[i]-=k;
        pushUp(i);
    }

    public int[] heapSortRev(int[] temp){
        buildHeap(temp);
        for(int i=0;i< arr.length;i++){
            delete();
        }
        return arr;
    }
    public void buildHeap(int[] temp){
        //time complexity : O(n)
        // we start from bottom most right most non leaf node, and go upto root
        this.arr = temp;
        last = arr.length-1;
        for(int i = (arr.length-2)/2;i>=0;i--){
            pushDown(i);
        }
    }
}
//[47, 40, 42, 39, 37, 30, 30, 29, 29, 26, 26, 21, 21, 15, 13, 11, 10, 7, 6, 2]
public class MinHeapImplementation {
    public static void main(String[] args) {
        int[] array=new int[]{50,30,20,15,10,8,16 ,60,8,20,15};
        int n = array.length;
        MinHeap minHeap = new MinHeap(n);
        minHeap.heapSortRev(array);
        System.out.println(Arrays.toString(array));
    }
    
}
