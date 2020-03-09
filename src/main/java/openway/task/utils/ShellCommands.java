package openway.task.utils;


public enum ShellCommands {
    EXECUTE("execute"), STACKTRACE("stacktrace");

    private String command;

    ShellCommands(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

}
