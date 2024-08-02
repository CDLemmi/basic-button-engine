package de.cdlemmi.bbe

import spock.lang.Specification

class InputHandlerSpec extends Specification {


    def "inputHandler should return normal mouse event"() {
        given:
        def inputHandler = new InputHandler()
        inputHandler.handleMouseMove(240, 400)
        inputHandler.handleClick(0,1)

        when:
        def e = inputHandler.getMouseEvent()

        then:
        e.posX == 240
        e.posY == 400
        e.action == MouseAction.DOWN
        e.button == MouseButton.LEFT
    }



    def "inputHandler should return null if nothing happens"() {
        given:
        def inputHandler = new InputHandler();

        when:
        def e = inputHandler.getMouseEvent();

        then:
        e == null
    }

    def "inputHandler should return null if nothing happens after getting "() {
        given:
        def inputHandler = new InputHandler()
        inputHandler.handleMouseMove(240, 400)
        inputHandler.handleClick(0,0)
        inputHandler.getMouseEvent()

        when:
        def e = inputHandler.getMouseEvent();

        then:
        e == null
    }

}
