
public class Orb{
  float x,y;
  float xSpeed,ySpeed;
  float radius;
  color c;

  public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_ ){
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    c = color(random(255),random(255),random(255));
  }


  void display(){
    fill(c);
    ellipse(x, y, radius, radius);
  }

  void move(){  
    x += xSpeed;
    y += ySpeed;
    if(x < 0 || x > width){
      xSpeed *= -1;
      x += xSpeed;
    }
    if(y < 0 || y > height){
      ySpeed *= -1;
      y += ySpeed;
    }
  }
  
  void gravity(){
    float gravity = 0.2;
    ySpeed += gravity;
  }
  
  void attract(Orb other){
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += (other.x - x) / d;
    other.ySpeed += (other.y - y) / d;
  }
}
