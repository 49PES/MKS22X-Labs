 int x,y;
  int MODE;
  void setup(){
     size(800,800);
     MODE = 1;
     x = width/2;
     y = height/2;
  }
  void draw(){
       background(255);
       x = change(x);
       y = change(y);
       avatar(x,y);
       avatar(mouseX, mouseY);
  }
  
  void mouseClicked(){
    MODE = (MODE % 3) + 1; // Loop around at Mode 3, increment by 1
  }
  void avatar(int x, int y){
  ellipse(x, y, 250, 300); // Face
  ellipse(x - 50 , y - 20, 50, 50); // Left eye
  ellipse(x + 50 , y - 20, 50, 50);  // Right eye
  ellipse(x , y + 75, 100, 50);  // Mouth


}

  int change(int value){
    /**
     mode 1: return a random location on the screen.
     mode 2: change value by +1, 0, or -1 randomly
     mode 3: change value by +1 , but if it goes past the end of the screen ,
           wrap back around to the other end of the screen.
    */

    switch(MODE){
     case 1:
       return (int) random(800);
     case 2:
       return value + ((int) random(3) - 1);    // (0, 1, 2) - 1 -> (-1, 0, +1), to be added with
     case 3:
       if(value < 800){
         return value + 1;
       }
       return 0;
     default:
       return width/2;
    }
  }
