package pl.pwit.smacc.mailgun;

import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.fluent.Form;

import pl.pwit.smacc.MailMedia;

/**
 * Mutable version
 * 
 * @author pawel
 *
 */
//TODO Make immutable
public class MailgunMedia implements MailMedia {
	private final Form form;
	
	public MailgunMedia() {
		this.form = Form.form();
	}

	@Override
	public MailMedia from(String from) {
		this.form.add("from", from);
		
		return this;
	}

	@Override
	public MailMedia to(String to) {
		this.form.add("to", to);
		
		return this;
	}

	@Override
	public MailMedia subject(String subject) {
		this.form.add("subject", subject);
		
		return this;
	}

	@Override
	public MailMedia content(String content) {
		this.form.add("text", content);
		
		return this;
	}
	
	public List<NameValuePair> form() {
		return this.form.build();
	}
}
