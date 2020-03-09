package openway.task;

import lombok.extern.slf4j.Slf4j;
import openway.task.utils.DataProviders;
import openway.task.utils.ShellCommands;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@Slf4j
@SpringBootTest
public class Tests extends BasicTest {


    @Test(
            description = "Shell check. Command and command group are present in shell",
            groups = {"smoke", "positive"})
    public void smokeTest() {
        Map<String, MethodTarget> commands = shell.listCommands();
        MethodTarget commandTarget = commands.get("execute");
        Assert.assertEquals(commandTarget.getGroup(), "Function runner");
    }

    @Test(
            description = "Test integer input", groups = {"smoke", "positive"})
    public void integerTypeTest() {
        Assert.assertEquals(shell.evaluate(() -> "execute " + 5), 1 / 5.0);
    }

    @Test(
            description = "Test double input",
            groups = {"smoke", "positive"})
    public void doubleTypeTest() {
        Assert.assertEquals(shell.evaluate(() -> "execute " + 0.1), 1 / 0.1);
    }

    @Test(
            description = "Unit test method for incorrect string value",
            expectedExceptions = IllegalArgumentException.class,
            groups = {"extended", "negative", "unit"})
    public void illegalArgumentExceptionTest() {

        invoke(receiveMethodTarget(ShellCommands.EXECUTE.getCommand()), dataGenerators.generateRandomString());
    }

    @Test(
            description = "Test shell for incorrect string input",
            dataProviderClass = DataProviders.class, dataProvider = "expressionStringDataProvider",
            groups = {"extended", "negative"})
    public void stringExpressionTypeTest(String value) {
        Exception x = (Exception) shell.evaluate(() -> ShellCommands.EXECUTE.getCommand() + " " + value);
        Assert.assertEquals(x.getClass(), IllegalArgumentException.class);

    }


    @Test(
            description = "check random stream data",
            dataProviderClass = DataProviders.class, dataProvider = "fuzzDataProvider",
            groups = {"extended", "negative"})
    public void fuzzTest(String description, Object value, Object expectedValue) {

        Assert.assertEquals(shell.evaluate(() -> ShellCommands.EXECUTE.getCommand() + " " + value), expectedValue);
        log.debug(description + " " + value.getClass() + expectedValue.getClass().getTypeName());
    }


}
