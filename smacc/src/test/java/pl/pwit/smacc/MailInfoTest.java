package pl.pwit.smacc;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

import pl.pwit.smacc.Mail;

public class MailInfoTest {
	private MailMedia mockMedia;
	
	@Before
	public void before() {
		mockMedia = mock(MailMedia.class);
		
		when(mockMedia.to(anyString())).thenReturn(mockMedia);
		when(mockMedia.from(anyString())).thenReturn(mockMedia);
		when(mockMedia.subject(anyString())).thenReturn(mockMedia);
		when(mockMedia.content(anyString())).thenReturn(mockMedia);
	}
	
	@Test
	public void testMakeMedia() {
		Mail m = new MailInfo("to", "from", "subject", "content");
		
    	m.makeMedia(mockMedia);
    	
    	verify(mockMedia, atLeastOnce()).to("to");
    	verify(mockMedia, atLeastOnce()).from("from");
    	verify(mockMedia, atLeastOnce()).subject("subject");
    	verify(mockMedia, atLeastOnce()).content("content");
	}
}
