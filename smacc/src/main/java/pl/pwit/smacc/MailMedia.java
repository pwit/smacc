package pl.pwit.smacc;

public interface MailMedia {
	MailMedia from(String from);
	MailMedia to(String to);
	MailMedia subject(String subject);
	MailMedia content(String content);
}
