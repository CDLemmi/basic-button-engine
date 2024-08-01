package de.cdlemmi.bbe

import spock.lang.Specification

class InputHandlerSpec extends Specification {

    def "inputHandler should return default mouse move event"() {
        given:
        def inputHandler = new InputHandler()

        when:
        def result = inputHandler.getMouseEvent()

        then: 
		result.posX == 4
		result.posY == 3
		
		
    }
}
