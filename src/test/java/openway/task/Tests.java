package openway.task;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.shell.MethodTarget;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Map;

@SpringBootTest
public class Tests extends BasicTest {

    @Test(description = "smoke")
    public void smokeTest() {
        Map<String, MethodTarget> commands = shell.listCommands();
        MethodTarget commandTarget = commands.get("execute");
        Assert.assertEquals(commandTarget.getGroup(), "Function runner");
        System.out.println(commandTarget.getGroup());
        //Assert.assertEquals(shell.evaluate(()-> command + "1"), 1);

    }

}
