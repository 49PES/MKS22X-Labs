String[]names;
Kernel[]kernels;
int currentKernel;

void setup(){
  size(1450,500);
  currentKernel = 0;
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
   names = new String[]{
    "Identity", "Blur", "Sharpen",
    "Outline", "Left Sobel", "Right Sobel",
    "Top Sobel", "Emboss"
  };

  kernels = new Kernel[] {
      new Kernel( new float[][] {
        {0, 0, 0},
        {0, 1, 0},
        {0, 0, 0}
      }) ,
      new Kernel( new float[][] {
        {.111, .111, .111},
        {.111, .111, .111},
        {.111, .111, .111}
      }) ,
      new Kernel( new float[][] {
        {0, -1, 0},
        {-1, 5, -1},
        {0, -1, 0}
      }) ,
      new Kernel( new float[][] {
        {-1, -1, -1},
        {-1, 8, -1},
        {-1, -1, -1}
      }) ,
      new Kernel( new float[][] {
        {1, 0, -1},
        {2, 0, -2},
        {1, 0, -1}
      }) ,
      new Kernel( new float[][] {
        {-1, 0, 1},
        {-2, 0, 2},
        {-1, 0, 1}
      }) ,
      new Kernel( new float[][] {
        {1, 2,  1},
        {0, 0, 0},
        {-1, -2, -1}
      }),
      new Kernel( new float[][] {
        {-2, -1,  0},
        {-1, 1, 1},
        {0, 1, 2}
      })
     };
  kernels[currentKernel].apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
void draw(){
  PImage car = loadImage("redcar.png");
  PImage output = car.copy();
  kernels[currentKernel].apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
  fill(0);
  text(names[currentKernel], 10, 10);
}
void keyPressed(){
  currentKernel++;
  currentKernel %= kernels.length;
}
