import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  private Frontier frontier;

  public boolean done(){
    return (frontier.size() == 0);
  }

  public static boolean isTree(int[][] map, int x, int y){
     return ((0 <= x && x < map.length) && (0 <= y && y < map.length) && map[x][y] == TREE);
   }

  public void tick(){
    int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    Frontier newFrontier = new Frontier();
    while(frontier.size() > 0){
        int[] fire = frontier.remove();
        for(int[] direction : directions){
          int x = fire[0] + direction[0], y = fire[1] + direction[1];
          if(isTree(map, x, y)){
            map[x][y] = FIRE;
            newFrontier.add(x, y);
          }

          map[fire[0]][fire[1]] = ASH;
        }
    }

    frontier = newFrontier;
    ticks++;
  }


  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     frontier = new Frontier();
     start();
  }



  public void start(){
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        frontier.add(i, 0);
      }
    }
  }



    public static void main(String[]args){
      int REPETITION = 100;
      int DIMENSION = 100;
      double DENSITY_INCREMENT = 0.05;
      double LOWER_BOUND = 0.0;
      double UPPER_BOUND = 1.0;

      if(args.length > 4){
        REPETITION = Integer.parseInt(args[0]);
        DIMENSION = Integer.parseInt(args[1]);
        DENSITY_INCREMENT = Double.parseDouble(args[2]);
        LOWER_BOUND = Double.parseDouble(args[3]);
        UPPER_BOUND = Double.parseDouble(args[4]);
      }

      double[][] densityTime = new double[(int) ((UPPER_BOUND - LOWER_BOUND) / DENSITY_INCREMENT) + 1][2];
      int index = 0;

      for(double i = LOWER_BOUND; i <= UPPER_BOUND; i += DENSITY_INCREMENT){
        double avg = 0;
        for(int j = 0; j < REPETITION; j++){
          BurnTrees test = new BurnTrees(DIMENSION, DIMENSION, i);
          avg += test.run();
        }
        avg /= REPETITION;

        densityTime[index][0] = i;
        densityTime[index][1] = avg;

        index++;
      }

      for(double[] row : densityTime){
        System.out.println("| " + row[0] + " |\t " + row[1] + " |");
      }

    }




  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
