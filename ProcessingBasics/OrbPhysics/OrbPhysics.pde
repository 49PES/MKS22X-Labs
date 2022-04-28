ArrayList<Orb>orbList;
boolean backgroundMode;
int MODE;
int GRAVITY = 0;
int ORBIT = 1;
Orb Omega;
    void setup() {
      size(1000, 800); // 1
      Omega = new Orb(500, 400, 0, 0, 20); // 2
      orbList = new ArrayList<Orb>();
      backgroundMode = true;
      MODE = 0;
    }
    void mouseClicked() {
      //add a new Orb to the orbList, constructed as follows:
      //The x and y positions are the same as the mouse
      //the radius should be between in the range [20.0,70.0)
      //the xSpeed and ySpeed should be in the range [-3.0,3.0)
      orbList.add(new Orb(mouseX, mouseY, 3, 0,  20)); // 3
    }
    void draw() {
      if(backgroundMode) { // 6
        background(255);
      }
      for (Orb o : orbList) {
        o.move();
        // Omega.attract(o);
        o.display();
      }
      
      if(MODE == GRAVITY){
        for(Orb o : orbList){
          o.move();
          o.gravity();
        }
      }
      fill(0);
      text(frameRate,20,20);
      text(orbList.size(),20,40);
    }

    void keyPressed(){
      switch(key){
        case(BACKSPACE):
          orbList = new ArrayList<Orb>(); // 4
          break;
        case('b'):
          backgroundMode = !backgroundMode; // 5
          break;
        case(' '):
          MODE = (MODE + 1) % 2;
          break;
      }
      
    }
