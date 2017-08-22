package pl.pwit.smacc.sendgrid;

import static org.junit.Assert.*;

import org.junit.Test;

public class SendGridMediaTest {
	
	@Test
	public void testFrom() {
    	SendGridMedia media = new SendGridMedia();
    	
    	media.from("from1");
    	
    	assertEquals("{\"from\":{\"email\":\"from1\"}}", media.json());
	}
	
	@Test
	public void testTo() {
    	SendGridMedia media = new SendGridMedia();
    	
    	media.to("to1");
    	
    	assertEquals("{\"personalizations\":[{\"to\":[{\"email\":\"to1\"}]}]}", media.json());
	}
	
	@Test
	public void testSubject() {
    	SendGridMedia media = new SendGridMedia();
    	
    	media.subject("subject1");
    	
    	assertEquals("{\"subject\":\"subject1\"}", media.json());
	}
	
	@Test
	public void testContent() {
    	SendGridMedia media = new SendGridMedia();
    	
    	media.content("content1");
    	
    	assertEquals("{\"content\":[{\"type\":\"text/plain\",\"value\":\"content1\"}]}", media.json());
	}
}
