/*
@Author: Anmol Kumar Sharma

Problem Statement: 
Given a array arr[] of N element where each element represents the weight of the stone. We need to perform following operations:
* Pick the two largest stone from the array and remove these stone if they are equal else remove them and add the adsolute difference of these stone into the array.
* Perform the above operations utill the array has one or no stone in it. 
* If the array has only one stone left then return that stone, else return 0;

Approach Used: Max Heap
Time Complexity: O(N), where N is the number of stones in the array initially.
Space Complexity: O(N)

Similar Problem: https://www.geeksforgeeks.org/last-element-remaining-by-deleting-two-largest-elements-and-replacing-by-their-absolute-difference-if-they-are-unequal/

*/

import java.util.*;

public class LastRemainStone {

    public static int checkLastStone(int[] arr) {
        // if of empty array
        if(arr == null) return 0;

        int n = arr.length;
        //creating max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        //adding element to the maxHeap
        for(int item: arr) {
            maxHeap.add(item);
        }

        while(maxHeap.size() > 1) {
            int item1 = maxHeap.poll();
            int item2 = maxHeap.poll();

            //if largest two elements are not same
            //then their absolute difference to heap
            if(item1 != item2) {
                maxHeap.add(Math.abs(item1-item2));
            }
            //if both are same then continue
        }

        //check the for the last element and return if exist else return 0
        return ((maxHeap.size() == 1) ? maxHeap.poll() : 0);

    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter No. of element: ");
        int n = scan.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements: ");
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }

        //calling and print the result of the checkLastStone() method
        System.out.println(checkLastStone(arr));
    }
}
