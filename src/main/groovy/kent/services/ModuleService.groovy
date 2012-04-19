package kent.services

interface ModuleService {

	/**
	 * Push an event to the RMAS application. The message should be a well-formed
	 * RMAS-CERIF message of an appropriate type for this module.
	 * @param message The RMAS-CERIF XML message
	 * @return True if the message was accepted and pulled into the RMAS system, 
	 * 	false if there was a problem
	 */
	boolean pushEvent(String message)
	
	/**
	 * Get a list of all RMAS events that have occured since the provided date and time.
	 * @param dateTime An ISO-8601 formatted datetime string (e.g. 2011-12-25T08:00:00Z)
	 * @return A list of RMAS-CERIF XML messages
	 */
	List<String> getEvents(String timestamp)
}
