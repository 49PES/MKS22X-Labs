public class LakeMaking{
  public static void stomp(int[][] elevations, int[][] instructions){
    for(int[] instruction : instructions){
      int x = instruction[0], y = instruction[1], amt = instruction[2];
      int max = 0;
      for(int i = instruction[0]; i < instruction[0] + 2; i++){
        for(int j = instruction[1]; j < instruction[1] + 2; j++){
          if(elevations[i][j] > max) max = elevations[i][j];
        }
      }
      int minMax = max - amt;
      if(minMax < 0){minMax = 0;}
      for(int i = instruction[0]; i < instruction[0] + 2; i++){
        for(int j = instruction[1]; j <  instruction[0] + 2; j++){
          if (elevations[i][j] > minMax){elevations[i][j] = minMax;}
        }
      }
    }
  }

}
