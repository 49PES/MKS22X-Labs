import java.util.Arrays;
public class Quick{

  // Helper method for partition - takes in index parameters + int array
  public static void swap(int[] data, int index1, int index2){
   int temp = data[index1];
   data[index1] = data[index2];
   data[index2] = temp;
  }

  public static int partition(int[] data, int start, int end){
    // Swap a random element from start to end, inclusive, with the start element
    swap(data, (int) ( Math.random() * (end - start + 1) ) + start, start);
    int rightBound = end;
    // Assign the value of the pivot for checking purposes
    int pivot = data[start];
    for(int i = start + 1; i <= rightBound; i++){
      if(data[i] >= pivot){
        swap(data, i, rightBound);
        rightBound--;
        i--; // If you swap, you want to keep the leftBound the same, so decrement to compensate for the increment
      }
    }
    swap(data, start, rightBound);
    return rightBound;
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
      else{break;}
    }
    return data[partitionIndex];
  }

  // Wrapper method
  public static void quicksort(int[] data){
    quicksort(data, 0, data.length - 1);
  }

  // Helper method
  public static void quicksort(int[] data, int lo, int hi){
    if(lo >= hi) {return;}
    int partition = partition(data, lo, hi);
    quicksort(data, lo, partition - 1);
    quicksort(data, partition + 1, hi);
  }


  // public static boolean check(int[] data){
  //   for(int i = 0; i < data.length - 2; i++){
  //     if(data[i] > data[i + 1]) return false;
  //   }
  //   return true;
  // }

  public static void main(String[] args){
    int[] bob = new int[1000000];
    for(int i = 0; i < 1000000; i++){
      bob[i] = (int) (Math.random() * 100000);
    }

    if(args.length > 0){
      bob = new int[Integer.parseInt(args[0]) ];
      for(int i = 0; i < Integer.parseInt(args[0]); i++){
        bob[i] = (int) (Math.random() * 100000);
      }
    }
    quicksort(bob);
    // System.out.println(check(bob) );


  }


}
