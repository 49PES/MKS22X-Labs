import java.util.Arrays;
public class Quick{

  public static int partition(int[] data, int start, int end) {
      int partition = data[end];
      int leftBound = start - 1;
      for (int index = start; index < end; index++) {
        if (data[index] <= partition) {
          leftBound++;
          swap(data, leftBound, index);
        }
      }
      swap(data, leftBound + 1, end);
      return leftBound + 1;
    }

  // Helper method for partition
  public static void swap(int[] data, int index1, int index2){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }

  public static int quickselect(int[] data, int k){
    int low = 0, high = data.length - 1;
    int partitionIndex = partition(data, low, high);
    while(true){
      if(partitionIndex < k){
        partitionIndex = partition(data, partitionIndex + 1, high);
      }
      else if(partitionIndex > k){
        partitionIndex = partition(data, low, partitionIndex - 1);
      }
      else{break;} // If partitionIndex == k, then you have located the k'th smallest value
    }
    return data[partitionIndex];
  }


  // WRAPPER METHOD
  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }

  // HELPER METHOD
  public static void quicksort(int[] data, int start, int end) {
    if (start >= end) return;
    int partition = partition(data, start, end);
    quicksort(data, start, partition - 1);
    quicksort(data, partition + 1, end);
  }


  public static void main(String[] args){
    // int[] bob = new int[15];
    // for(int i = 0; i < 14; i++){bob[i] = (int) (Math.random() * 20); }
    // System.out.println(Arrays.toString(bob) );
    // quicksort(bob);
    // System.out.println(Arrays.toString(bob) );
    int[] bob = {14, 19, 18, 16, 9, 11, 0, 7, 14, 18};
    partition(bob, 0, 9);
    System.out.println(Arrays.toString(bob));
  }
}
