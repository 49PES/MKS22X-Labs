import java.util.ArrayList;
import java.util.Arrays;

public class Preliminary{
  public static int partition ( int [] data, int start, int end){
    /**
    * CREATES A LOWER AND GREATER ARRAYLIST - 2, 3 TIMES MORE INEFFICIENT THAN NEED BE
    * SHOULD BE IMPROVED UPON LATER
    **/
    int midIndex = (start + end) / 2;
    
    ArrayList<Integer> less = new ArrayList<Integer>();
    ArrayList<Integer> greater = new ArrayList<Integer>();
    
    int partition = data[midIndex];
    for(int i = start; i < end + 1; i++){
      if(data[i] < partition) {less.add(data[i]); }
      else if(data[i] > partition) { greater.add(data[i]); }
    // ASSUMPTION THAT EACH VALUE IS UNIQUE - ENSURE THAT CODE IS COMPATIBLE WITH REPEATED VALUES LATER
    }

    int index = start;
    for(int i = 0; i < less.size(); i++){
      data[index] = less.get(i);
      index++;
    }

    data[index] = partition; index++;
    for(int j = 0; j < greater.size(); j++){
      data[index] = greater.get(j);
      index++;
    }
    return start + less.size();
  }

  public static void main(String[] args){
    int[] foo = new int[] {999,999,999,4,3,2,1,0,999,999,999};
    // System.out.println(Arrays.toString(foo) );
    System.out.println(partition(foo, 4, 7));
    // System.out.println(Arrays.toString(foo) );
  }
}
/*
import java.util.Arrays;

public class Main
{
    public static int[] partition ( int [] data, int start, int end){
        int[] temp = new int[end - start + 1];
        int partition = data[(start + end) / 2];
        
        int leftBound = start;
        int rightBound = end;                
        System.out.println("Original:" + Arrays.toString(temp));
        
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
                    insertLeft = !insertLeft;
                }
                else{
                    temp[rightBound] = data[i];
                    rightBound--;
                    insertLeft = !insertLeft;
                }
            }
            }
            
        }
        
        temp[leftBound] = partition;
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
		System.out.println("Hello World");
		int[] bob = new int[] {7, 4, 2, 3, 1, 8, 6};
		System.out.println( Arrays.toString(partition(bob, 0, 6)) );
	}
}
*/
