package by.bsu.lecture.first;

// singleton class
public enum Role {
    // реализация через анонимный класс
    // для каждого объекта может быть своя реализация
    GUEST {
        @Override
        public void methodTwo() {

        }
    }, CLIENT(20) {
        @Override
        public void methodTwo() {

        }
    }, MODERATOR(4) {
        @Override
        public void methodTwo() {

        }
    }, ADMINISTRANOR(1) {
        @Override
        public void methodTwo() {

        }
    };
    private int currentUserNumber;

    Role() {
        //System.out.println(this.name());
    }

    Role(int currentUserNumber) {
        this.currentUserNumber = currentUserNumber;
    }

    public void method() {
        System.out.println("method" + this.name());
    }

    public int getCurrentUserNumber() {
        return currentUserNumber;
    }

    public void setCurrentUserNumber(int currentUserNumber) {
        this.currentUserNumber = currentUserNumber;
    }

    public abstract void methodTwo();
}
