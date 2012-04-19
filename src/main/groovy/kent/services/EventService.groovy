package kent.services

import groovy.json.JsonSlurper
import kent.Message
import kent.MessageStore

import org.joda.time.DateTime
import org.joda.time.format.ISODateTimeFormat

class EventService implements ModuleService {
	
	boolean pushEvent(String message) {
		
		println "Event received: ${message}"
		
		def parsedMsg = new JsonSlurper().parseText(message)
		
		def msg = new Message(parsedMsg['message_id'], parsedMsg['message_type'], message, new DateTime())
		
		MessageStore.getInstance().addMessage(msg)
		
		return true
	}
	
	List<String> getEvents(String timestamp) {
		
		println "Poll received: ${timestamp}"
		
		DateTime dt = ISODateTimeFormat.dateTimeNoMillis().parseDateTime(timestamp)
		
		def messages = MessageStore.getInstance().getMessagesAfter(dt)
		
		println messages
		
		return messages
	}
}

















