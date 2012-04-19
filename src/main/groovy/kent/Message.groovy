package kent

import org.joda.time.DateTime

class Message {

	String rmasId
	String type
	String content
	DateTime received

	public Message(String rmasId, String type, String content, DateTime received) {
		this.rmasId = rmasId;
		this.type = type;
		this.content = content;
		this.received = received;
	}
	
	String toString() {
		"Message(${rmasId}, ${type}, ${received})"
	}
}
