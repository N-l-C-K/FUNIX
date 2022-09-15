image = new SimpleImage("golden-gate-red.jpg");

for (pixel: image) {
  // Your code here
  pixel.setGreen(pixel.getRed());
  pixel.setBlue(pixel.getRed());
}

print(image);