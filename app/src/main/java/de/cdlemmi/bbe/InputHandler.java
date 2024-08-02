package de.cdlemmi.bbe;

public class InputHandler {
	

	int posX;
	int posY;
	
	boolean clicked;
	int button;
	int action;


	
	public MouseClickEvent getMouseEvent() {
		if(clicked) {
			clicked = false;
			try {
				return new MouseClickEvent(button, action, posX, posY);
			} catch(IllegalArgumentException e) {
				System.err.println("mouse button / action not recognized");
				return null;
			}
			} else {
			return null;
		}
	}


	
	public void handleMouseMove(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void handleClick(int button, int action) {
		this.button = button;
		this.action = action;
		clicked = true;
	}
	
	
	public InputHandler() {
		posX = 0;
		posY = 0;
	}
	
}