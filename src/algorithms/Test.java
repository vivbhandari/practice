package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    class Pair{
        int index;
        int value;
        public Pair(int i, int v){
            index = i;
            value = v;
        }
        public String toString(){
            return ""+value;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        Integer[]smaller = new Integer[nums.length];
        Arrays.fill(smaller, 0);
        Pair[] pairs = new Pair[nums.length];
        
        for(int i=0;i<nums.length;i++){
            pairs[i] = new Pair(i, nums[i]);
        }
        System.out.println(Arrays.toString(pairs));

        mergeSortHelper(pairs, smaller, 0, nums.length-1);
        System.out.println(Arrays.toString(pairs));
        return new ArrayList<Integer>(Arrays.asList(smaller));
    }

    private void mergeSortHelper(Pair[] pairs, Integer[] smaller, int l, int r){
        if(l<r){
            int m = (l+r)/2;
            mergeSortHelper(pairs, smaller, l, m);
            mergeSortHelper(pairs, smaller, m+1, r);        
            
            //merge
            int i=l;
            int j=m+1;
            int k=0;
            int right=0;
            Pair[] sorted = new Pair[r-l+1];
            while(k<r-l+1){
                System.out.println("i="+i+",j="+j+",m="+m+",k="+k);
                if(j == r+1 || i<=m && pairs[i].value < pairs[j].value){
                    sorted[k++] = pairs[i];
                    smaller[pairs[i].index] += right;
                    i++;
                }else{
                    sorted[k++] = pairs[j++];
                    right++;
                }
            }
            System.out.println(Arrays.toString(sorted));
            for(int s=l;s<=r;s++)
                pairs[s] = sorted[s-l];
            System.out.println(Arrays.toString(pairs));
        }
    }
    
    public static void main(String args[]){
    	System.out.println(new Test().countSmaller(new int[]{5,2,6,1}));
    }
}
