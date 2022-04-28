  ArrayList<Orb>orbList;
  Orb omega;
  void setup() {
    size(1000, 800);
    orbList = new ArrayList<Orb>();
    omega = new Orb(500, 400, 0, 0 , 20);
  }
  void mouseClicked() {
    //add a new Orb to the orbList, constructed as follows:
    //The x and y positions are the same as the mouse
    //the radius should be between in the range [20.0,70.0)
    //the xSpeed and ySpeed should be in the range [-3.0,3.0)
    orbList.add(new Orb(mouseX, mouseY, 5, 0, 20));
  }
  void draw() {
    background(255);
    for (Orb o : orbList) {
      o.move();
      o.display();
      o.gravity();
    }
    fill(0);
    text(frameRate,20,20);
    text(orbList.size(),20,40);
  }
