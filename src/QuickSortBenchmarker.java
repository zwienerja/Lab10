/**
   The QuickSortBenchmarker class performs a 
	Quicksort on an int array. It keeps count 
	of the number of swaps made.
*/

public class QuickSortBenchmarker
{
   private int array[];  // The array to sort
   private int numSwaps; // To count the number of swaps made
   private int numComparisons; // To count the number of comparisons made
   private int numAssignments; // To count the number of assignments made
   
   /**
      Constructor
      @param a The array to sort.
   */
   
   public QuickSortBenchmarker(int a[])
   {
      array = a;
      numSwaps = 0;
      numComparisons = 0;
      numAssignments = 0;
      doQuickSort(array, 0, array.length - 1);
   }

   /**
      The doQuickSort method uses the QuickSort algorithm
      to sort the array.
      @param array The array to sort.
      @param start The starting subscript of the list to sort
      @param end The ending subscript of the list to sort
   */
   
   private void doQuickSort(int array[], int start, int end)
   {
      int pivotPoint;

      numComparisons++;
      if (start < end)
      {
         // Get the pivot point.
         pivotPoint = partition(array, start, end);
         numAssignments++;
         
         // Sort the first sub list.
         doQuickSort(array, start, pivotPoint - 1);
         
         // Sort the second sub list.
         doQuickSort(array, pivotPoint + 1, end);
      }
   }

   /**
      The partiton method selects a pivot value in an array
      and arranges the array into two sub lists. All the
      values less than the pivot will be stored in the left
      sub list and all the values greater than or equal to
      the pivot will be stored in the right sub list.
      @param array The array to partition.
      @param start The starting subscript of the area to partition.
      @param end The ending subscript of the area to partition.
      @return The subscript of the pivot value.
   */
   
   private int partition(int array[], int start, int end)
   {
      int pivotValue;    // To hold the pivot value
      int endOfLeftList; // Last element in the left sub list.
      int mid;           // To hold the mid-point subscript

      // Find the subscript of the middle element.
      // This will be our pivot value.
      mid = (start + end) / 2;
      numAssignments++;

      // Swap the middle element with the first element.
      // This moves the pivot value to the start of 
      // the list.
      swap(array, start, mid);

      // Save the pivot value for comparisons.
      pivotValue = array[start];
      numAssignments++;
      
      // For now, the end of the left sub list is
      // the first element.
      endOfLeftList = start;
      numAssignments++;
      
      // Scan the entire list and move any values that
      // are less than the pivot value to the left
      // sub list.
      numComparisons++;
      for (int scan = start + 1; scan <= end; scan++, numComparisons++)
      {
         numComparisons++;
         if (array[scan] < pivotValue)
         {
            endOfLeftList++;
            swap(array, endOfLeftList, scan);
         }
      }
      
      // Move the pivot value to end of the
      // left sub list.
      swap(array, start, endOfLeftList);
      
      // Return the subscript of the pivot value.
      return endOfLeftList;
   }

   /**
      The swap method swaps the contents of two elements
      in an int array.
      @param array containing the two elements.
      @param a The subscript of the first element.
      @param b The subscript of the second element.
   */
   
   private void swap(int[] array, int a, int b)
   {
      int temp;
      
      temp = array[a];
      array[a] = array[b];
      array[b] = temp;
      numAssignments = numAssignments + 3;
      numSwaps++;
   }

   /**
      The getNumSwaps method returns the number of
      swaps made.
      @return The number of swaps made.
   */
   public int getNumSwaps()
   {
      return numSwaps;
   }

   /**
    * returns the number of comparisons made
    * @return numComparisons
    */
   public int getNumComparisons()
   {
      return numComparisons;
   }

   /**
    * returns the number of assignments made
    * @return numAssignments
    */
   public int getNumAssignments() { return numAssignments; }
}