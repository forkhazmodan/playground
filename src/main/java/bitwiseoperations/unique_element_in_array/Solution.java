package bitwiseoperations.unique_element_in_array;

//Finding the Single Non-Repeated Element in an Array
public class Solution {

    public static void main(String[] args) {


        int[] arr = new int[]{2,2,3,4,3,5,6,6,5};
        int unique = arr[0];
        for (int i = 1; i < arr.length; i++) {
            unique = unique ^ arr[i];
        }

        System.out.println(unique);

    }
}
