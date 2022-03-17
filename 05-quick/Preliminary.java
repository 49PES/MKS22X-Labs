import java.util.Arrays;
public class Preliminary{
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
	public static void main(String[] args) {
		int[] bob = new int[] {3, 4, 2, 3, 1, 8, 6};
    // System.out.println(Arrays.toString(bob) );
    System.out.println( partition(bob, 0, 6) );
    // System.out.println(Arrays.toString(bob) );
	}
}
