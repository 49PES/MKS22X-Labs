void setup(){
      size(1450,500);
      PImage car = loadImage("redcar.png");

      //Kernel k = new Kernel( new float[][] {
      //  {-1, -1, -1},
      //  {-1, 8, -1},
      //  {-1, -1, -1}
      //} );

      Kernel k = new Kernel( new float[][] {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0}
      } );


      Kernel k2 = new Kernel( new float[][] {
        {.11, .11, .11},
        {.11, .11, .11},
        {.11, .11, .11}
      } );
      PImage output = new PImage(car.width, car.height);
      k.apply(car,output);
      image(car,0,0);
      image(output,car.width,0);
    }
