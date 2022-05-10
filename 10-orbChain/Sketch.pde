
  static int SPRING = 2;
  static float SPRING_LENGTH = 50;
  static float SPRING_DAMPEN = 0.990;
  static float SPRING_CONSTANT = 0.015;
  static int MODE = SPRING;
  static float GRAVITY = 0.35
  OrbList orbs;
    void setup() {
    size(1000, 800);
    orbs = new OrbList();
  }
  void mouseClicked() {
    orbs.add(new OrbNode(mouseX,mouseY,0,0,30,));
  }
  void draw() {
    background(255);
    orbs.processAll();
    orbs.display();
  }

  void keyPressed(){

    // '1' increases SPRING_CONSTANT
    // '2' decreases SPRING_CONSTANT
    // '3' increases SPRING_DAMPEN
    // '4' increases SPRING_DAMPEN
    // '5' increases SPRING_LENGTH
    // '6' increases SPRING_LENGTH
    // '7' increases GRAVITY
    // '8' increases GRAVITY


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
    }

  }
