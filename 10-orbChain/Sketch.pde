
  static int SPRING = 2;
  static float SPRING_LENGTH = 50;
  static float SPRING_DAMPEN = 0.990;
  static float SPRING_CONSTANT = 0.015;
  static int MODE = SPRING;
  static float GRAVITY = 0.35;
  static int MOUSE_MODE = 0;
  OrbList orbs;
    void setup() {
    size(1000, 800);
    orbs = new OrbList();
  }
  void mouseClicked() {
    switch(MOUSE_MODE){
      case 0:
       orbs.add(new OrbNode(mouseX,mouseY,0,0,30));
       break;
      case 1:
        orbs.add(mouseX, new OrbNode(mouseX,mouseY,0,0,30));
        break;
      case 2:
        orbs.delete(orbs.getNodeAt(mouseX, mouseY));
    }

  }
  void draw() {
    background(255);
    orbs.processAll();
    orbs.display();
    text("SPRING_CONSTANT: " + SPRING_CONSTANT, 10, 15);
    text("SPRING_DAMPEN: " + SPRING_DAMPEN, 10, 30);
    text("SPRING_LENGTH: " + SPRING_LENGTH, 10, 45);
    text("GRAVITY: " + GRAVITY, 10, 60);
    text("MODE: ", 10, 75);
    switch(MOUSE_MODE){
      case 0:
        text("ADD LAST", 55, 75);
        break;
      case 1:
        text("ADD", 55, 75);
        break;
      case 2:
        text("DELETE", 55, 75);
        break;
    }
    
  }

  void keyPressed(){
    switch(key){
      case '1':
        SPRING_CONSTANT += 0.005;
        break;
      case '2':
        SPRING_CONSTANT -= 0.005;
        break;
      case '3':
        SPRING_DAMPEN += 0.005;
        break;
      case '4':
        SPRING_DAMPEN -= 0.005;
        break;
      case '5':
        SPRING_LENGTH += 5;
        break;
      case '6':
        SPRING_LENGTH -= 5;
        break;
      case '7':
        GRAVITY += 0.05;
        break;
      case '8':
        GRAVITY -= 0.05;
        break;
      case ' ':
        MOUSE_MODE = (MOUSE_MODE + 1) % 3;
    }

  }
