package de.cdlemmi.bbe;

import static org.lwjgl.opengl.GL11.*;

public class Button {

    String name;

    final int posX;
    final int posY;
    final int sizeX;
    final int sizeY;

    final double xStart;
    final double yStart;
    final double xEnd;
    final double yEnd;

    private boolean clicked;

    void handleClick(MouseClickEvent event) {

        if(event.button == MouseButton.LEFT) {
            if (event.posX > posX && event.posX < posX + sizeX && event.posY > posY && event.posY < posY + sizeY) {
                if (clicked) {
                    if (event.action == MouseAction.UP) {
                        clicked = false;
                        doClickAction();
                    }
                } else {
                    if (event.action == MouseAction.DOWN) clicked = true;
                }
            }
        }
    }

    void doClickAction() {
        System.out.println(String.format("button %s", name));
    }

    void render() {
        glBegin(GL_TRIANGLE_STRIP);
        glColor3d(1.0,0.0,0.0);
        glVertex2d(xStart,yStart);
        glVertex2d(xStart,yEnd);
        glVertex2d(xEnd,yStart);
        glVertex2d(xEnd,yEnd);
        glEnd();
    }

    Button(String name, int posX, int posY, int sizeX, int sizeY) {
        this.posX = posX;
        this.posY = posY;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.name = name;

        xStart = (double) posX          / 400.0 - 1.0;
        xEnd = (double)(posX + sizeX)   / 400.0 - 1.0;
        yStart = (double)posY           / -300.0 + 1.0;
        yEnd = (double)(posY + sizeY)   / -300.0 + 1.0;

    }




}
