package pl.pwit.smacc.mailgun;

import org.apache.http.HttpHost;
import org.apache.http.client.fluent.Executor;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;

import pl.pwit.smacc.Mail;
import pl.pwit.smacc.MailPlatform;

public class Mailgun implements MailPlatform {
	private final Executor executor;
	private final String uri;
	
	/**
	 * Ctor
	 * @param apiKey Mailgun api key
	 * @param uri uri of Mailgun service
	 * @param host Mailgun host name
	 */
	public Mailgun(String apiKey, String uri, String host) {
		this.executor = Executor.newInstance().auth(new HttpHost(host), "api", apiKey);
		this.uri = uri;
	}
	
	@Override
	public void send(Mail mail) {
		MailgunMedia m = new MailgunMedia();
		mail.makeMedia(m);
		
		try {
			Response resp = this.executor.execute(Request.Post(uri).bodyForm(m.form()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
