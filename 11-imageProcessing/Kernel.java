
class Kernel {
  float[][]kernel;

  /**Constructor takes the kernel that will be applied to the image
  *This implementation only allows 3x3 kernels
  */
  public Kernel(float[][]init) {
    kernel = init;
  }

  /**If part of the kernel is off of the image, return black, Otherwise
  *Calculate the convolution of r/g/b separately, and return that color\
  *if the calculation for any of the r,g,b values is outside the range
  *     0-255, then clamp it to that range (< 0 becomes 0, >255 becomes 255)
  */
  color calcNewColor(PImage img, int x, int y) {
    //Hint: start by always returning black.
    //This will let you test your apply method right away!
  if(x - 1 < 0 || x + 1 > width || y - 1 < 0 || y + 1 > height){
    return color(0); // Out of bounds
  }
  float redSum = 0, greenSum = 0, blueSum = 0;
  for(int row = y - 1; row <= y + 1; row++){
    for(int col = x - 1; col <= x + 1; col++){
      redSum += red(img.get(row, col)) * kernel[row + 1 - y][col + 1 - x];
      greenSum += green(img.get(row, col)) * kernel[row + 1 - y][col + 1 - x];
      blueSum += blue(img.get(row, col)) * kernel[row + 1 - y][col + 1 - x];
    }
   }
   redSum = corrector(redSum);
   blueSum = corrector(blueSum);
   greenSum = corrector(greenSum);
   return color(redSum, greenSum, blueSum);
  }
  /** HELPER **/
  float corrector(float val){
    if(val < 0) 
      val = 0;
    if(val > 255) 
      val = 255;
    return val;
  }
  /**You must write this method that applies the kernel to the source,
    *and saves the data to the destination.*/
  void apply(PImage source, PImage destination) {
  }

}
