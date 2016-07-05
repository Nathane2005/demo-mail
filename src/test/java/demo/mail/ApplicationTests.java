package demo.mail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.subethamail.wiser.Wiser;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class, TestConfiguration.class})
public class ApplicationTests {

	@Autowired
	MySender mailSender;

	@Autowired
	Wiser wiser;

	@Test
	public void testSendEmail() {
		mailSender.sendEmail();
		assertEquals(1, wiser.getMessages().size());
	}


}
