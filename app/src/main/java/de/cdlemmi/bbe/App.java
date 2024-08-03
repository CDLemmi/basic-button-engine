package de.cdlemmi.bbe;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;


public class App {
	
    private long window;

    InputHandler inputHandler;
    Screen screen;

    public void run() {
        init();

        loop();

        // Free the window callbacks and destroy the window
        Callbacks.glfwFreeCallbacks(window);
        GLFW.glfwDestroyWindow(window);

        // Terminate GLFW and free the error callback
        GLFW.glfwTerminate();
    }



    private void loop() {
        // This line is critical for LWJGL's interoperation with GLFW's
        // OpenGL context, or any context that is managed externally.
        // LWJGL detects the context that is current in the current thread,
        // creates the GLCapabilities instance and makes the OpenGL
        // bindings available for use.


        // Run the rendering loop until the user attempts to close the window
        while (!GLFW.glfwWindowShouldClose(window)) {

            var e = inputHandler.getMouseEvent();
            if(e != null) {
                //System.out.println(e);
                screen.handleClick(e);
            }

            screen.render();


            // Poll for window events. The key callback above will only be
            // invoked during this call.
            GLFW.glfwPollEvents();
        }
    }

    private void init() {
        // Set up an error callback. The default implementation will print the error message in System.err.
        GLFWErrorCallback.createPrint(System.err).set();

        // Initialize GLFW. Most GLFW functions will not work before doing this.
        if (!GLFW.glfwInit()) {
            throw new IllegalStateException("Unable to initialize GLFW");
        }

        // Configure GLFW
        GLFW.glfwDefaultWindowHints(); // optional, the current window hints are already the default
        GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GLFW.GLFW_FALSE); // the window will stay hidden after creation
        GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, GLFW.GLFW_FALSE); // the window will be resizable

        // Create the window
        window = GLFW.glfwCreateWindow(800, 600, "Basic Button Engine", 0, 0);
        if (window == 0) {
            throw new RuntimeException("Failed to create the GLFW window");
        }

        // Center the window
        org.lwjgl.glfw.GLFWVidMode vidmode = GLFW.glfwGetVideoMode(GLFW.glfwGetPrimaryMonitor());
        GLFW.glfwSetWindowPos(
                window,
                (vidmode.width() - 800) / 2,
                (vidmode.height() - 600) / 2
        );

        // Make the OpenGL context current
        GLFW.glfwMakeContextCurrent(window);

        // Enable v-sync
        GLFW.glfwSwapInterval(1);


        inputHandler = new InputHandler();
        GLFW.glfwSetCursorPosCallback(window, (_, x, y) -> inputHandler.handleMouseMove((int) x, (int) y));
        GLFW.glfwSetMouseButtonCallback(window, (_, b, a, _) -> inputHandler.handleClick(b, a));

        screen = new Screen(window);

        // Make the window visible
        GLFW.glfwShowWindow(window);

    }

    public static void main(String[] args) {
        try {
            System.out.println("Hello World");
            new App().run();
            System.out.println("program finished");
        } catch(Exception e) {
            //noinspection CallToPrintStackTrace
            e.printStackTrace();
        }
    }

}
