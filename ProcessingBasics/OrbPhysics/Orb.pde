public class Orb{
  float x,y;
  float xSpeed,ySpeed;
  float radius;
  color c;
  float SPRING_CONSTANT, SPRING_LENGTH, SPRING_DAMPEN;
  public Orb(float x_,float y_,float xSpeed_, float ySpeed_, float radius_, float constant, float len, float dampen ){
    x = x_;
    y = y_;
    xSpeed = xSpeed_;
    ySpeed = ySpeed_;
    radius = radius_;
    c = color(random(255),random(255),random(255));
    
    SPRING_CONSTANT = constant;
    SPRING_LENGTH = len;
    SPRING_DAMPEN = dampen;
  }


  void display(){
    fill(c);
    ellipse(x, y, radius, radius);
    line(x, y, x + 5 * xSpeed, y + 5 * ySpeed);
  }

  void move(){  
    x += xSpeed;
    y += ySpeed;
  }
  
  void bounce(){
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
    float gravity = 0.15;
    ySpeed += gravity;
  }
  
  void attractSpring(Orb other){
     float d = dist(x, y, other.x, other.y);
     float x_dist = (other.x - x);
     float y_dist = (other.y - y);
     
     float force = SPRING_CONSTANT * (d - SPRING_LENGTH);
     
     other.xSpeed += force * -x_dist / (d * d);
     other.ySpeed += force * -y_dist / (d * d);
     
     other.xSpeed *= SPRING_DAMPEN; 
     other.ySpeed *= SPRING_DAMPEN; 
  }
  void attract(Orb other){
    float d = dist(x, y, other.x, other.y);
    other.xSpeed += (x - other.x) / (d * d) * 20;  
    other.ySpeed += (y - other.y) / (d * d) * 20;
  }
  
  
}
