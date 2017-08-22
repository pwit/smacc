package pl.pwit.smacc.sendgrid;

import org.json.JSONArray;
import org.json.JSONObject;

import pl.pwit.smacc.MailMedia;

/**
 * Mutable version
 * 
 * @author pawel
 *
 */
//TODO Make immutable
public class SendGridMedia implements MailMedia {
	private final JSONObject json;
	
	public SendGridMedia() {
		this.json = new JSONObject();
	}

	@Override
	public MailMedia from(String from) {
		this.json.put("from", email(from));
		
		return this;
	}

	@Override
	public MailMedia to(String to) {
		this.json.put("personalizations", new JSONArray().put(new JSONObject().put("to", new JSONArray().put(email(to)))));
		
		return this;
	}

	@Override
	public MailMedia subject(String subject) {
		this.json.put("subject", subject);
		
		return this;
	}

	@Override
	public MailMedia content(String content) {
		this.json.put("content", new JSONArray().put(new JSONObject().put("type", "text/plain").put("value", content)));
		
		return this;
	}
	
	private JSONObject email(String email) {
		return new JSONObject().put("email", email);
	}
	
	public String json() {
		return this.json.toString();
	}
}
