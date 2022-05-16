
public class OrbList {
  OrbNode first, last;

  //create a fixed orb
  OrbList() {
    first = new FixedOrbNode(0, height/5);
    last = new FixedOrbNode(width, height/5);
    //link them to eachother
    first.next = last;
    last.prev = first;
  }

  /**
  *complete this method
  */
  void add(OrbNode orb){
    //insert orb at the end of the list before the last node.
    last.prev.next = orb; // The link after the previous orb now points to this orb
    orb.prev = last.prev; // Thing before now comes before the new orb

    orb.next = last; // Connect the new orb to the end
    last.prev = orb; // Connect the end to the new orb
  }

  void add(int xcor, OrbNode toBeAdded){
    OrbNode current = first;
    while(current.x < xcor){
      current = current.next;
    }
    toBeAdded.prev = current.prev;
    toBeAdded.next = current;
    current.prev.next = toBeAdded;
    current.prev = toBeAdded;

  }


  void delete(OrbNode target){
    if(target == null) return;
    target.prev.next = target.next;
    target.next.prev = target.prev;
  }
  /**
  *complete this method
  *process all nodes by running move.
  */
  void processAll() {
    OrbNode current = first;
    while(current != null){
      current.move();
      current = current.next;
    }
    //advance current to next until it is null, move() each of the nodes
  }

  OrbNode getNodeAt(int x, int y){
    OrbNode current = first;
    current = current.next;
    while(current != null){
      float distance = dist(x, y, current.x, current.y);
      if(distance <= current.radius) return current;
      current = current.next;
    }
    return null;
  }
  /**
  *complete this method
  *Display all nodes by running their display().
  */
  void display() {
    OrbNode current = first;
    while(current != null){
      current.display();
      current = current.next;
    }
    //advance current to next until it is null, display() each of the nodes
  }
}
