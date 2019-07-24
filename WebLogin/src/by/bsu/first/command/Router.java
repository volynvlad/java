package by.bsu.first.command;
import static by.bsu.first.command.PagePath.INDEX;
public class Router {
    enum DispathType {
        FORWARD, REDIRECT
    }
    private String page = INDEX;
    private DispathType type = DispathType.FORWARD;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public DispathType getType() {
        return type;
    }

    public void setRedirect() {
        this.type = DispathType.REDIRECT;
    }
}
