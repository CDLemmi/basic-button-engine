package de.cdlemmi.bbe;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL;

import java.util.ArrayList;

import static org.lwjgl.opengl.GL11.*;

public class Screen {

    private long window;

    private ArrayList<Button> buttons = new ArrayList<>();



    void handleClick(MouseClickEvent event) {
        for(Button button : buttons) {
            button.handleClick(event);
        }
    }




    void render() {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT); // clear the framebuffer

        for(Button button : buttons) {
            button.render();
        }

        GLFW.glfwSwapBuffers(window); // swap the color buffers
    }





    Screen(long window) {
        this.window = window;

        buttons.add(new Button("top",200,100,400,100));
        buttons.add(new Button("mid",200,250,400,100));
        buttons.add(new Button("bot",200,400,400,100));

        GL.createCapabilities();
        glClearColor(0.0F, 0.0F, 1.0F, 0.0F);
    }

}
