package de.cdlemmi.bbe;

class MouseClickEvent {

	final int posX;
	final int posY;

	MouseButton button;
	MouseAction action;



	MouseClickEvent(int button, int action, int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.button = switch(button) {
			case 0 -> MouseButton.LEFT;
			case 1 -> MouseButton.RIGHT;
			default -> throw new IllegalArgumentException("unable to parse mouse button int to enum");
		};
		this.action = switch(action) {
			case 0 -> MouseAction.UP;
			case 1 -> MouseAction.DOWN;
			default -> throw new IllegalArgumentException("unable to parse mouse action int to enum");
		};
	}

	@Override
	public String toString() {
		return String.format("MouseClickEvent(button=%s;action=%s;posX=%d;posY=%s)", button, action, posX, posY);
	}
	
}