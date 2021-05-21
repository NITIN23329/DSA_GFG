package sorting;
// This is the randomized quick sort algorithm
public class QuickSort {
    public static void quickSort(int[] arr,int l,int r){
        if(l>=r)return; // base case when 1 or 0 elements are there
        int mid = partition(arr,l,r);
        // recursively do this for left and right half of pivot.
        quickSort(arr,l,mid-1);
        quickSort(arr,mid+1,r);
    }
    // this function put pivot element in it correct place and return its index
    private static int partition(int[] arr,int l,int r){
        // randomly take any index in rangle[l,r] as pivot index
        int pivot = (int)((r-l+1)*Math.random() + l);
        int i = l;
        int j = r;
        while(true){
            while(i < pivot && arr[i]<=arr[pivot])i++;
            while(j>pivot && arr[j]>arr[pivot])j--;
            if(i<pivot && j>pivot){
                // case: we have 1 > element on left and 1 <= element on right
                // swap them so both goto their correct half.
                swap(arr,i,j);
                i++;j--;
            }
            else break;
        }
        if(j>pivot){
            // case: we have <= on right and no > element on left.
            int bound = pivot;
            while(bound<j){
                if(arr[j]>arr[pivot])j--;
                else {
                    bound++;
                    swap(arr,bound,j);
                }
            }
            swap(arr,bound,pivot);
            pivot = bound;
        }else if(i<pivot){
            //case we have > element on left and no <= element on right.
            int bound = pivot;
            while(i<bound){
                if(arr[i]<=arr[pivot])i++;
                else{
                    bound--;
                    swap(arr,bound,i);
                }
            }
            swap(arr,bound,pivot);
            pivot = bound;
        }
        return pivot;
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
