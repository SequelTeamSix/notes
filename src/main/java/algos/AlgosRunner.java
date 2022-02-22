package algos;

/*
Selection sort:
We maintain a minimum search index, starting at 0
for each item in the array array:{
    using a for loop traversal:{
        we find the minimum value *after* the minimum index
        after traversal, we swap the minimum with what is contained in the minimum index
        we increment the minimum index
    }
}
what does this lead to?
the section of the array that is sorted 'grows' from the beginning of the array, because we are finding
the value that belongs in a particular spot, starting at 0
O(n^2)
 */

public class AlgosRunner {
    public static void main(String[] args){
        Integer[] arr = {5, 4,23, 6, 25,67, 0, 8 , 6 ,40 };
        arr = selectionSort(arr);
        binarySearch(arr, 9);
        binarySearchRecursive(arr, 4);

    }
    public static Integer[] selectionSort(Integer[] arr){
        for(int k = 0; k < arr.length-1; k++){
            System.out.print(arr[k]+", ");
        }
        System.out.println(arr[arr.length-1]);
        for(int i = 0; i < arr.length-1; i++){
            int smallestIndex = i;
            //purpose of inner for: find the smallest value after min index
            for(int j = i+1; j < arr.length; j++){
                if(arr[j]<arr[smallestIndex]){
                    smallestIndex = j;
                    System.out.println("The smallest number is now "+arr[smallestIndex] + " at "+smallestIndex);
                }
                System.out.println("Comparing "+arr[i] + " at " +i + " to "+arr[j] + " at "+ j);
            }
            int temp = arr[i];
            arr[i] = arr[smallestIndex];
            arr[smallestIndex] = temp;

            for(int k = 0; k < arr.length-1; k++){
                System.out.print(arr[k]+", ");
            }
            System.out.println(arr[arr.length-1]);
        }
        return arr;
    }

    public static int binarySearch(Integer[] arr, int val){
//        binary search?
        int minIndex = 0;
        int maxIndex = arr.length;
        while(minIndex <= maxIndex
        ){
            int midIndex = (minIndex+maxIndex) /2;

            System.out.println("Searching mid index: " + midIndex + "("+arr[midIndex]+")");
            if(arr[midIndex]==val) {
                return midIndex;
            }else if(arr[midIndex] > val){
//                the number must be less than arr midindex - so, we search for everything between max and mid
                maxIndex = midIndex-1;
            }else if(arr[midIndex] < val) {
//                the number must be greater than arr midindex - so, we search for everything between min and mid
                minIndex = midIndex+1;
            }
        }
        return -1;
    }

    public static int binarySearchRecursive(Integer[] arr, int val){
        return binarySearchRecursiveHelper(arr, val, 0, arr.length);
    }
    public static int binarySearchRecursiveHelper(Integer[] arr, int val, int minIndex, int maxIndex){
        int midIndex = (minIndex+maxIndex) /2;
        if(minIndex>maxIndex){
            return -1;
        }else if(arr[midIndex]==val) {
            return midIndex;
        }else if(arr[midIndex] > val){
//                the number must be less than arr midindex - so, we search for everything between max and mid
            maxIndex = midIndex-1;
        }else if(arr[midIndex] < val) {
//                the number must be greater than arr midindex - so, we search for everything between min and mid
            minIndex = midIndex+1;
        }
        System.out.println("Calling a new recursion: min "+minIndex + " max "+maxIndex);
        return binarySearchRecursiveHelper(arr, val, minIndex, maxIndex);
    }

}
