int time;
void setup(){
  size(800,600);
  time = 0;
}
void draw(){
  background(255);
  // Default coordinates of the animated avatar face
  int xMover = 300;
  int yMover = 300;
 
  fill(255, 0, 0); // Red animated face
  avatar(xMover, yMover + int(100 * sin(time * 0.1))); // Oscillating motion :)
  // Extra fun without the * 0.1 :D
  time++;
 
  fill(0, 255, 0); // Light green avatar
  avatar(100,100);
  fill(0, 125, 125); // Dark green avatar
  avatar(600,300);
}

void avatar(int x, int y){
  //your code here
  // rect(x,y,100,100);
  ellipse(x, y, 250, 300); // Face
  ellipse(x - 50 , y - 20, 50, 50); // Left eye
  ellipse(x + 50 , y - 20, 50, 50);  // Right eye
  ellipse(x , y + 75, 100, 50);  // Mouth


}
