package alex.sofka.reto;

import java.util.ArrayList;

public class Question {

     private String question;
     private ArrayList<Answer> answers;
     private int points;

    public Question() {
    }

    public Question(String question, ArrayList<Answer> answers, int points) {
        this.question = question;
        this.answers = answers;
        this.points = points;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public int getPoints() {
        return points;
    }

    public void showQuestion(){
        System.out.println(question);

        int i=0;
        while(i<answers.size()){
            System.out.println("\t"+(i+1)+". "+answers.get(i));
            i++;
        }
    }

    public boolean checkAnswer(int answer){
        Answer r = answers.get(answer-1);

        if(r!= null){
            return r.isRight();
        }

        return false;
    }
}
