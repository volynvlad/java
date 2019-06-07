package by.vlad.observer.JobSite;

import java.util.List;

public interface Observer {
    public void handleEvent(List<String> vacancies);
}
