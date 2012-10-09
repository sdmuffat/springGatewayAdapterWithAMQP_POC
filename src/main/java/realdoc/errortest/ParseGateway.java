package realdoc.errortest;

import org.springframework.integration.Message;

public interface ParseGateway {
    public Message<?> send(Message<String> message);
}
