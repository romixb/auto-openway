package openway.task;

import lombok.extern.slf4j.Slf4j;
import openway.task.utils.DataProviders;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.convert.ConversionException;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.shell.MethodTarget;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;
@Slf4j
@SpringBootTest
public class Tests extends BasicTest {


    @Test(description = "Shell check. Command and command group are present in shell", groups = {"smoke", "positive"})
    public void smokeTest() {

        Map<String, MethodTarget> commands = shell.listCommands();
        MethodTarget commandTarget = commands.get("execute");
        Assert.assertEquals(commandTarget.getGroup(), "Function runner");
    }

    @Test(description = "Test integer input", groups = {"smoke", "positive"})
    public void integerTypeTest(){
        Assert.assertEquals(shell.evaluate(()-> "execute " + 5), 1/5.0);
    }

    @Test(description = "Test double input",groups = {"smoke", "positive"})
    public void doubleTypeTest(){
        Assert.assertEquals(shell.evaluate(()-> "execute " + 0.1), 1/0.1);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "stringDataProvider", groups = {"extended", "negative"})
    public void stringTypeTest(String value){

           Assert.assertThrows(NumberFormatException.class, () -> shell.evaluate(()-> "execute " + value));
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "fuzzDataProvider", groups = {"extended", "negative"})
    public void fuzzTest(String description, Object value, Object expectedValue) {

        Assert.assertEquals(shell.evaluate(()-> "execute " + value), expectedValue);
        log.debug(description + " "+ value.getClass() + expectedValue.getClass().getTypeName());
    }


}
