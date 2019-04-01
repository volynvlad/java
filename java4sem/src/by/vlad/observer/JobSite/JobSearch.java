package by.vlad.observer.JobSite;

public class JobSearch {
    public static void main(String[] args) {
        JavaDeveloperJobSite jobSite = new JavaDeveloperJobSite();
        final String FJP = "First Java Position";
        final String SJP = "Second Java Position";
        final String TJP = "Third Java Position";
        final String FS = "Vlad Volynets";
        final String SS = "Dima Kozak";
        final String TS = "Pasha Kerilov";

        jobSite.addVacancy(FJP);
        jobSite.addVacancy(SJP);

        Observer firstSubscriber = new Subscriber(FS);
        Observer secondSubscriber = new Subscriber(SS);
        Observer thirdSubscriber = new Subscriber(TS);

        jobSite.addObserver(firstSubscriber);
        jobSite.addObserver(secondSubscriber);

        jobSite.addVacancy(TJP);
        jobSite.removeVacancy(FJP);

        jobSite.removeObserver(secondSubscriber);
        jobSite.addObserver(thirdSubscriber);

        jobSite.addVacancy(FJP);
        jobSite.removeVacancy(SJP);
    }
}
