import java.util.Arrays;

public class Merge{

        public static int [] merge(int [] left, int[] right){
          int[] mergedArray = new int[left.length + right.length];
          int i = 0, j = 0; // i = left, j = right
          for(int k = 0; k < mergedArray.length; k++){
            if(i >= left.length){
              mergedArray[k] = right[j];
              j++;
            }
            else if(j >= right.length){
              mergedArray[k] = left[i];
              i++;
            }

            else if(left[i] <= right[j]){
              mergedArray[k] = left[i];
              i++;
            }

            else{
              mergedArray[k] = right[j];
              j++;
            }
          }
          System.out.println(Arrays.toString(left) + " + " + Arrays.toString(right) + " => " + Arrays.toString(mergedArray) );
          return mergedArray;
        }

        public static void mergesort(int [] data){
          int[] temp  = mergesortH(data);
          data = temp;
        }

        public static int[] mergesortH(int[] data){
          int[] temp = data;
          if(data.length > 1){
            int leftLength = data.length / 2;
            int[] left = new int[leftLength];
            int[] right = new int[data.length - leftLength];
            int k = 0;
            for(int i = 0; i < left.length; i++){
              left[i] = data[k]; k++;
            }

            for(int j = 0; j < right.length; j++){
              right[j] = data[k]; k++;
            }

            mergesortH(left);
            mergesortH(right);
            temp = merge(left, right);
          }
          return temp;
        }
        public static void main(String[] args){
          int[] data = new int[10];
          for(int i = 0; i < 10; i++){
            data[i] = (int) (Math.random() * 1000);
          }
          System.out.println(Arrays.toString(data));
          mergesort(data);
          System.out.println(Arrays.toString(data));
        }
}
