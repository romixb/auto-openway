package openway.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.Step;

@Slf4j
@SpringBootTest
@Import(TestAppRunner.class)
public class BasicTest extends AbstractTestNGSpringContextTests {


    @Autowired
    ApplicationContext context;

    @Autowired
    Shell shell;

    @Step("User opens shell")
    @BeforeMethod
    void openShell() {
        log.debug("Shell ready for work");
    }

    @AfterMethod()
    void closeShell() {
        log.debug("Shell closed");
    }
}
