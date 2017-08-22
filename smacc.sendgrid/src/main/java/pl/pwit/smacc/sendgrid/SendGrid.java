package pl.pwit.smacc.sendgrid;

import java.io.IOException;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.ContentType;

import pl.pwit.smacc.Mail;
import pl.pwit.smacc.MailPlatform;

public class SendGrid implements MailPlatform {
	private final String key;
	private final String uri;
	
	/**
	 * Ctor
	 * @param apiKey SendGrid api key
	 * @param uri uri of SendGrid service
	 */
	public SendGrid(String apiKey, String uri) {
		this.key = apiKey;
		this.uri = uri;
	}
	
	@Override
	public void send(Mail mail) {
		SendGridMedia m = new SendGridMedia();
		mail.makeMedia(m);
		
		try {
			Response resp = Request.Post(uri).addHeader("Authorization", "Bearer " + key).bodyString(m.json(), ContentType.APPLICATION_JSON).execute();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
