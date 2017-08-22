package pl.pwit.smacc.mailgun;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.http.NameValuePair;
import org.junit.Test;

import pl.pwit.smacc.mailgun.MailgunMedia;

public class MailgunMediaTest {
	
	@Test
	public void testFrom() {
    	MailgunMedia media = new MailgunMedia();
    	List<NameValuePair> form;
    	
    	media.from("from1");
    	
    	form = media.form();
    	
    	assertEquals(1, form.size());
    	assertEquals("from", form.get(0).getName());
    	assertEquals("from1", form.get(0).getValue());
	}
	
	@Test
	public void testTo() {
		MailgunMedia media = new MailgunMedia();
    	List<NameValuePair> form;
    	
    	media.to("to1");
    	
    	form = media.form();
    	
    	assertEquals(1, form.size());
    	assertEquals("to", form.get(0).getName());
    	assertEquals("to1", form.get(0).getValue());
	}
	
	@Test
	public void testSubject() {
		MailgunMedia media = new MailgunMedia();
    	List<NameValuePair> form;
    	
    	media.subject("subject1");
    	
    	form = media.form();
    	
    	assertEquals(1, form.size());
    	assertEquals("subject", form.get(0).getName());
    	assertEquals("subject1", form.get(0).getValue());
	}
	
	@Test
	public void testContent() {
		MailgunMedia media = new MailgunMedia();
    	List<NameValuePair> form;
    	
    	media.content("content1");
    	
    	form = media.form();
    	
    	assertEquals(1, form.size());
    	assertEquals("text", form.get(0).getName());
    	assertEquals("content1", form.get(0).getValue());
	}
}
