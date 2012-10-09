package realdoc.errortest;

import org.springframework.integration.Message;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;


public class ParseGatewayService  {

    private ParseGateway parseGateway;

    public ParseGatewayService(ParseGateway parseGateway) {
        this.parseGateway = parseGateway;
    	System.out.println (" ParseGatewayService constructor called with parseGateway parameter");

    }
    
    public Message<String> service(Message<String> message) {

        Message<?> response;
		StopWatch stopWatch = new StopWatch();

        try {
            System.out.println ("Entering parse gateway.");
    		stopWatch.start("submit");
            response = parseGateway.send(message);
    		stopWatch.stop();
        } catch (RuntimeException e) {
            System.err.println("Exception response received from gateway/exception: " + getClass() + "/" + e);
            System.err.println("Invoking exception handling process because: " + e.getCause());
            // send an exception somewhere?
            throw e;
        }

        System.out.println ("Time in ms: " + stopWatch.getLastTaskTimeMillis());
        
        if (response != null) {
            if (!(response.getPayload() instanceof String))
                throw new IllegalStateException("message payload wasn't a string!");
        } else {
            System.out.println("Null response received from gateway: " +  getClass());
            System.out.println ("Message request was: " + message);
            // send an exception somewhere???
//            throw new RuntimeException("some runtime exception");
            return null;
        }

        Assert.state(response.getPayload() instanceof String);
        return (Message<String>) response;
    }
}
