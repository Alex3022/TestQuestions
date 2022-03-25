package alex.sofka.reto;

public class Answer {

    private String answer;
    private boolean right;

    public Answer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Answer='" + answer + '\'';
    }
}
