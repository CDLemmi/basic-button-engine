package de.cdlemmi.bbe;

class MouseClickEvent extends MouseMoveEvent {
	
	MouseButton button;
	
	MouseClickEvent(MouseButton button, int posX, int posY) {
		super(posX, posY);
		this.button = button;
	}
	
}