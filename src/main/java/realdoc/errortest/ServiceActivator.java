package realdoc.errortest;


public class ServiceActivator {

	private static final long SLEEP_TIME_MILLIS = 19000;


	public String serve(String request) throws Exception {
		System.out.println("ServiceActivator: service message: " + request);
		String retVal = null;
		if (request.equals("good"))
		{
			// simply pass through...all is good
			retVal = new String("good");
		}
		else if (request.equals("bad"))
		{
			throw new Exception("bad message");
		}
		else if (request.equals("slow"))
		{
			System.out.println("Slowly handling message...");
			Thread.sleep(SLEEP_TIME_MILLIS);
			System.out.println("...and DONE.");
			retVal = new String("slow");
		}
		else if (request.equals("null"))
		{
			retVal = null;
		}
		else if (request.equals("print"))
		{
			System.out.println ("\n========================================================="
					  + "\n    values to use:                                       "
					  + "\n           good   // creates a valid message that is processed quickly                                     "
					  + "\n           null   // returns a null value.  this is potentially a valid use case, but see timeout case                                    "
					  + "\n           bad    // throws an exception and it doesnt propagate.                                       "
					  + "\n           slow   // puts in a sleep of 10 seconds.  the gateway should respond with a null                                     "
					  + "\n           print  // reprints this message                                               "
					  + "\n                                                          "
					  + "\n=========================================================" );
			retVal = "print";
		}
		
		return retVal;
	}
	
//	public String nullReturned(String request) {
//		System.out.println("Good message returning null: " + request);
//
//		return null;
//	}
//	
//	public String nullReceived(String request) {
//		System.out.println("Did we receive a null?  " + request);
//		
//		return "nullReceived";
//	}
//	
//	public String bad(String request) throws Exception {
//		String message = "Bad message: *** " + request;
//		throw new Exception(message);
//	}
//	
//	public String slow(String request) throws InterruptedException {
//		System.out.println("Slowly handling message...");
//		Thread.sleep(SLEEP_TIME_MILLIS);
//		System.out.println("...and DONE.");
//		
//		return "slow";
//	}
//	
//	public void quiet(String request) {
//		System.out.println("Quietly handling message: " + request);
//		// don't do anything.  a void return.
//	}
//	
}
