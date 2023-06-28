import java.util.*;
public class Main
{
    public static int[][] twoSum(int[] arr, int target)
    {   
        HashMap<Integer,Integer> hm = new HashMap<>();
        List<int[]> res = new ArrayList<>();
        for(int i=0;i<arr.length;i++)
        {
            if(hm.containsKey(target-arr[i]))
            res.add(new int[]{arr[i],target-arr[i]});

            else
            hm.put(arr[i],i);
        }
        return res.toArray(new int[0][]);
    }

    public static int[] merSort(int[][] arrays)
    {
        List<Integer> merged = new ArrayList<>();
for (int[] array : arrays) {
for (int num : array) {
merged.add(num);
}
}
int[] mergedArray = new int[merged.size()];
for (int i = 0; i < merged.size(); i++) {
mergedArray[i] = merged.get(i);
}
Arrays.sort(mergedArray);
return mergedArray;

    }

    public static int[][] combinations(int[] merged, int twice)
    {
        List<int[]> com = new ArrayList<>();
        combination(merged,twice,new ArrayList<>(), com, 0);
        return com.toArray(new int[0][]);
    }

    public static void combination(int[] arr, int target, List<Integer> curr, List<int[]> com, int start)
    {
        if(target==0){
        com.add(curr.stream().mapToInt(Integer::intValue).toArray());
        return;}


        if(target<0){
        for(int i=start;i<arr.length;i++)
        {       curr.add(arr[i]);
                combination(arr,target-arr[i],curr,com,i);
                curr.remove(curr.size()-1);}


        }
    }



 

    
    public static void main(String[] args) {
        int[] arr = {1,3,2,2,-4,-6,-2,8};
        int target = 4;

        int[][] pairs = twoSum(arr,target);

        System.out.println("First Combination for \""+target+"\": ");
        for(int[] pair : pairs)
        System.out.println(Arrays.toString(pair));

        int[] merged = merSort(pairs);
        System.out.println("Merged into a single Array: ");
        System.out.println(Arrays.toString(merged));

        int twice = target*2;
        int[][] com = combinations(merged,twice);
        System.out.println("Second Combination for \""+twice+"\": ");
        for(int[] combination : com)
        {
            System.out.println(Arrays.toString(combination));
        }
    }
    
}

