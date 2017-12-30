package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

public class displayManager {
 
 private static final int WIDTH = 1560;
 private static final int HEIGHT = 740;
 private static final int FPS_CAP = 120;
 
 public static void createDisplay(){
  
  ContextAttribs attribs = new ContextAttribs(3,2).withForwardCompatible(true).withProfileCore(true);
  
  try {
   Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
   Display.create(new PixelFormat(), attribs);
   Display.setTitle("HI");
  } catch (LWJGLException e) {
   e.printStackTrace();
  }
  
  GL11.glViewport(0, 0, WIDTH, HEIGHT);
  GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
 }

 public static void updateDisplay(){
  
  Display.sync(FPS_CAP);
  Display.update();
  GL11.glClear(GL11.GL_COLOR_BUFFER_BIT);
 }
 
 public static void closeDisplay(){
  
  Display.destroy();
  
 }
 
}
