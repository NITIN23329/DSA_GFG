package greedy;
//problem link ;https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1/?track=SPC-Greedy&batchId=154
import java.util.Arrays;


class Item {
    int value, weight;
    Item(int x, int y){
        this.value = x;
        this.weight = y;
    }
}
public class FractionsKnapSack {
    // we need to compare V1/W1 and V2/W2 or we can compare V1*W1 and V2*W2
    double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr,(a,b)->(b.value*a.weight - a.value*b.weight));
        double profit = 0;
        int i=0;
        while(W>0 && i<n){
            if(arr[i].weight<=W){
                profit+=arr[i].value;
                W-=arr[i].weight;
            }else{
                profit += (arr[i].value/(arr[i].weight+0d)) * W;
                W = 0;
            }
            i++;
        }
        return profit;
    }
}
