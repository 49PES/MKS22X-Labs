import java.util.Queue;
import java.util.ArrayDeque;

public class Frontier{
  private Queue<int[]> frontier;
  public Frontier(){
    frontier = new ArrayDeque<int[]>();
  }

  public int size(){
    return frontier.size();
  }

  public int[] remove(){
    return frontier.remove();
  }

  public void add(int[] location){
    frontier.add(location);
  }

  public void add(int x, int y){
    frontier.add(new int[] {x, y});
  }

}
