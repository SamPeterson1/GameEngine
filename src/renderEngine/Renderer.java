package renderEngine;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL20;

public class Renderer {
	int program = 0;
	String vertexShadder = "#version 320 core;"
			+ "\n "
			+ "void main(void){\n"
			+ "gl_Position = vec4(0.0, 0.0, 0.5, 1.0);\n"
			+ "}\n";
	
	String fragmentShadder = "blrrfngd";
	
	public Renderer() {
		program = this.createShader();
	}
	
	public void render() {	
		
		GL20.glUseProgram(program);
		GL11.glDrawArrays(GL11.GL_POINT, 0, 1);
		GL11.glPointSize(40.0f);
		
	}
	
	public int createShader() {
		int vertexShader = GL20.glCreateShader(GL20.GL_VERTEX_SHADER);
		GL20.glShaderSource(vertexShader, vertexShadder);
		GL20.glCompileShader(vertexShader);
		System.out.println(GL20.glGetShaderSource(vertexShader, 100000));
		if (GL20.glGetShaderi(vertexShader, GL20.GL_COMPILE_STATUS) == GL11.GL_FALSE) {
            System.err.println("Error creating shader");
        }
		
		int fragmentShader = GL20.glCreateShader(GL20.GL_FRAGMENT_SHADER);
		GL20.glShaderSource(fragmentShader, "NOPE");
		GL20.glCompileShader(fragmentShader);
		
		int program = GL20.glCreateProgram();
		GL20.glAttachShader(program, vertexShader);
		GL20.glAttachShader(program, fragmentShader);
		GL20.glLinkProgram(program);
		
		
		
		return program;
	}
}
