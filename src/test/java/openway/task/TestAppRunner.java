package openway.task;

import lombok.extern.slf4j.Slf4j;
import org.jline.reader.ParsedLine;
import org.jline.reader.Parser;
import org.jline.reader.SyntaxError;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.JLineShellAutoConfiguration;

@Slf4j
@TestConfiguration
@EnableAutoConfiguration(exclude = { JLineShellAutoConfiguration.class })
public class TestAppRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args)  {
        log.info("run Tests");
    }

    @Bean
    public Parser parser() {
        return (var1, var2, var3) -> null;
    }

}
