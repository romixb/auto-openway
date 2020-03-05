package openway.task.console;

import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class FunctionRunner {

    @ShellMethod(value = "Calculate result of f(x)=1/x", group = "Function runner")
    public int execute(int x) {
        return  1/x;
    }

}
