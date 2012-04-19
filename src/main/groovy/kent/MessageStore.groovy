package kent

import groovy.sql.Sql

import org.joda.time.DateTime

@Singleton(lazy = true)
class MessageStore {

	private db
	
	private MessageStore() {
		
		println 'Connecting to DB'
		
		db = Sql.newInstance('jdbc:mysql://localhost:3306/rmas_server?autoReconnect=true', 'rmas', 'rmas',
			'com.mysql.jdbc.Driver')
		
	}
	
	void addMessage(Message msg) {
		
		println "Storing message [${msg}] in DB"
		
		db.execute 'insert into messages (rmas_id, type, content, received) values (?, ?, ?, ?)',
			[msg.rmasId, msg.type, msg.content, msg.received.toDate()]
	}
	
	List<String> getMessagesAfter(DateTime timestamp) {
		
		def messages = []
		
		db.eachRow('select content from messages where received > ? order by received ASC', [timestamp.toDate()]) { row ->
			
			messages << row['content']
		}
		
		return messages
	}
}













