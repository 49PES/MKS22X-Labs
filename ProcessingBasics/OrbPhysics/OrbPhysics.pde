ArrayList<Orb>orbList;
  Orb omega;
  boolean backgroundMode = true;
  int MODE;
  
  boolean GRAVITY_MODE;
  
  final int GRAVITY = 0;
  final int ORBIT = 1;
  final int SPRING = 2;
  float SPRING_CONSTANT = 0.15;
  float SPRING_LENGTH = 100;
  float SPRING_DAMPEN = 0.995;
  
  void setup() {
    size(1000, 800);
    orbList = new ArrayList<Orb>();
    omega = new Orb(500, 400, 0, 0 , 20,  SPRING_CONSTANT, SPRING_LENGTH, SPRING_DAMPEN);
    MODE = 0;
    GRAVITY_MODE = true;
  }
  void mouseClicked() {
    orbList.add(new Orb(mouseX, mouseY, 5, 0, 20, 0, 0, 0));
  }
  void draw() {
    
    if(backgroundMode) {
      background(255);
    }
    if(GRAVITY_MODE){
      text("GRAVITY (ACCELERATION)", 40, 150);
      for(Orb o : orbList) o.gravity();
    }
    else{
      text("NO GRAVITY (ACCELERATION)", 40, 150);
    }
    omega.display();
    for (Orb o : orbList) {
      o.move();
      o.display();
    }
    
    switch(MODE){
      case GRAVITY:
        for (Orb o : orbList) {
         o.bounce();
        } 
        fill(0, 0, 0);
        text("GRAVITY", 40, 120);
        break;
       case ORBIT:
        for(Orb o : orbList){
          omega.attract(o);
        }
        fill(0, 0, 0);
        text("ORBIT", 40, 120);
        break;
      case SPRING:
        for(Orb o : orbList){
          omega.attractSpring(o);
        }
        fill(0, 0, 0);
        text("SPRING", 40, 120);
        break;
    }
      
    fill(0);
    text(frameRate,20,20);
    text(orbList.size(),20,40);
  }
  
  void keyPressed(){

   switch(key){
     case BACKSPACE:
       orbList = new ArrayList<Orb>(); 
       break;
     case 'b':
      backgroundMode = !backgroundMode;
      break;
     case ' ':
       MODE = (MODE + 1) % 3;
       break;
     case 'g':
       GRAVITY_MODE = !GRAVITY_MODE;
       break;
   }
  }
