package openway.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import io.qameta.allure.Step;

@Slf4j
@SpringBootTest
@Import(TestAppRunner.class)
public class BasicTest extends AbstractTestNGSpringContextTests {


    @Autowired
    ApplicationContext context;

    @Autowired
    Shell shell;

    @BeforeSuite
    void beforeSuiteActions(){
        //Generate test data
    }

    @BeforeTest
    void beforeTestActions(){
        //Generate XML before test run
    }


    @BeforeMethod
    void beforeMethodAction(){
        //Check that shell is available
        //Log availability
    }

    @AfterMethod
    void closeShell() {
        //imitate shell close
        log.debug("Shell closed");
    }

    @AfterTest
    void afterClassActions(){
        //attach report
    }

    @AfterSuite
    void afterSuiteActions(){
        //Delete file
    }

}
