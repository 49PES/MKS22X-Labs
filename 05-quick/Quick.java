import java.util.Arrays;
public class Quick{
  public static int partition (int[] data, int start, int end){

      swap(data, start, (start + end) / 2);
      int pivot = data[start];
      int leftBound = start + 1;
      int rightBound = end;
      boolean insertLeft = true;

      while(leftBound != rightBound){

        if(data[leftBound] < pivot){
            leftBound++;
        }

        else if(data[leftBound] > pivot){
          swap(data, leftBound, rightBound);
          rightBound--;
        }

        else{
          if(insertLeft){
            leftBound++;
          }
          else{
            swap(data, leftBound, rightBound);
            rightBound--;
          }
          insertLeft = !insertLeft;
        }
      }
      swap(data, start, leftBound - 1);
      return leftBound;
  }
  public static void swap(int[] data, int index1, int index2){
    int temp = data[index1];
    data[index1] = data[index2];
    data[index2] = temp;
  }

  public static int quickselect(int[] data, int k){
    int low = 0, high = data.length - 1;
    int partitionIndex = partition(data, low, high);
    while(true){
      System.out.println(Arrays.toString(data));
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

  public static void main(String[] args){
    int[] bob = new int[] {3, 4, 2, 3, 1, 8, 6};
    System.out.println(quickselect(bob, 5));
  }
}
