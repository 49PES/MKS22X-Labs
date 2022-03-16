import java.util.ArrayList;
import java.util.Arrays;

public class Preliminary{
  public static int[] partition ( int [] data, int start, int end){
      int[] temp = new int[end - start + 1];
      int partition = data[(start + end) / 2];

      int leftBound = start;
      int rightBound = end;

      boolean insertLeft = true;
      for(int i = start; i <= end; i++){
          if(i != (start + end) / 2){
          if(data[i] < partition){
            temp[leftBound] = data[i];
            leftBound++;
          }
          else if(data[i] > partition){
            temp[rightBound] = data[i];
            rightBound--;
          }
          else if(data[i] == partition){
            if(insertLeft){
              temp[leftBound] = data[i];
              leftBound++;
            }
            else{
                temp[rightBound] = data[i];
                rightBound--;
            }
              insertLeft = !insertLeft;
            }
          }

      }

      // temp[leftBound] = partition;
      for(int i = start; i <= end; i++){
          data[i] = temp[i - start];
      }
      return data;

  }

    public static void swap(int[] data, int index1, int index2){
        int temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

	public static void main(String[] args) {
		int[] bob = new int[] {7, 4, 2, 3, 1, 8, 6};
		System.out.println( Arrays.toString(partition(bob, 0, 6)) );
	}
}
