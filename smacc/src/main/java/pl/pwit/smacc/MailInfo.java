package pl.pwit.smacc;

public class MailInfo implements Mail {
	private final String to;
	private final String from;
	private final String subject;
	private final String message;
	
	public MailInfo(String to, String from, String subject, String message) {
		this.to = to;
		this.from = from;
		this.subject = subject;
		this.message = message;
	}
	
	@Override
	public void makeMedia(MailMedia media) {
		media.to(this.to)
			.from(this.from)
			.subject(this.subject)
			.content(this.message);
	}
}
