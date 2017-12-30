package engineTestser;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import renderEngine.Renderer;
import renderEngine.displayManager;

public class MainGameLoop {

	public static void main(String[] args) {

		displayManager.createDisplay();
		
		//Loader loader = new Loader();
		//ModelTexture texture = new ModelTexture(loader.loadTexture("stallTexture"));
		//StaticShader shader = new StaticShader();
		//Renderer renderer = new Renderer(shader);
		
		//ModelData data = OBJFileLoader.loadOBJ("stall");
		
		//TexturedModel texturedmodel = new TexturedModel(data,texture); 	
		
		//Entity entity = new Entity(texturedmodel, new Vector3f(0,0,-60), 0, 0, 0, 1.5f);
		
		//Camera camera = new Camera();
		Renderer r = new Renderer();
		while(!Display.isCloseRequested()) {
			//camera.move(shader);
			//renderer.prepare();
			//shader.start();
			//shader.loadViewMatrix(camera);
			//renderer.render(entity,shader);
			//shader.stop();
			
			float[] color= {(float)Math.sin(System.currentTimeMillis()/100) * 0.5f + 0.5f, (float) Math.cos(System.currentTimeMillis()/100) * 0.5f + 0.5f, 0.0f, 1.0f};
			GL11.glClearColor(color[0], color[1], color[2],color[3]);
			r.render();
			displayManager.updateDisplay();
		}
		//shader.cleanUp();
		//loader.cleanUp();
		displayManager.closeDisplay();
	}

}
