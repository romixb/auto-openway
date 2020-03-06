package openway.task;

import io.qameta.allure.Attachment;
import lombok.extern.slf4j.Slf4j;
import openway.task.utils.DataGenerators;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.shell.Shell;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.io.IOException;

import static openway.task.utils.Utils.deleteTestDataSetToXml;
import static openway.task.utils.Utils.testDataSetToXmlAndAttach;

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

        DataGenerators dataGenerators = new DataGenerators();

        log.debug("Start DataFillUp");
        dataGenerators.fillUpCurrentTestDataContainer();
        log.debug("TestData list filled up with " + DataGenerators.testDataList.size() + " TestDataObjects");
    }


    @BeforeMethod
    void beforeMethodAction(){
        if (shell==null){
            throw new SkipException("Shell init failed");
        }
    }

    @AfterMethod
    void closeShell() {
        //imitate shell close
        log.debug("Shell closed");
    }

    @AfterTest
    void afterClassActions() throws IOException {
        testDataSetToXmlAndAttach();

    }

    @AfterSuite
    void afterSuiteActions(){
        deleteTestDataSetToXml();
    }

}
