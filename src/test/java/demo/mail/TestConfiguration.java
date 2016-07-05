package demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.subethamail.wiser.Wiser;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Configuration
public class TestConfiguration {


    @Autowired
    private Wiser wiser;

    @Value("${spring.mail.host}")
    String smtpHost;

    @Value("${spring.mail.port}")
    int smtpPort;

    @Bean
    public Wiser provideWiser() {
        Wiser wiser = new Wiser();
        return wiser;
    }

    @PostConstruct
    public void initializeMailServer() {
        wiser.setHostname(smtpHost);
        wiser.setPort(smtpPort);
        wiser.start();
        System.out.println("asd");
    }

    @PreDestroy
    public void shutdownMailServer() {
        wiser.stop();
    }


}
