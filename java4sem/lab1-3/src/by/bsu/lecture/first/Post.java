package by.bsu.lecture.first;

public class Post <K extends Number, V>{
    private K postId;
    private V message;
    public V getMessage() {
        return message;
    }
    public void setMessage(V message){
        this.message = message;
    }
}
