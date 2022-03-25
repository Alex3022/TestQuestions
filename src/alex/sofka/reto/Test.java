package alex.sofka.reto;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    private ArrayList<Question> questions;
    private int allPoints;
    private int actuallyQuestion;

    public Test(){
        questions = new ArrayList<>();
        allPoints = 0;
        actuallyQuestion = 0;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public int getAllPoints() {
        return allPoints;
    }

    public int getActuallyQuestion() {
        return actuallyQuestion;
    }

    public Question nextQuesion(){

        Question q = questions.get(actuallyQuestion);

        if(q!=null) {
            actuallyQuestion++;
        }

        return q;
    }

    public void replayTest(){
        actuallyQuestion = 0;
        allPoints = 0;
    }

    public void loadData(String file) throws FileNotFoundException, IOException{

        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        Question q;
        ArrayList<Answer> answers = new ArrayList<>();
        String textQuestion = "";
        int pointsQuestion = 0, rightOption = 0;
        boolean question = false, answer = false, points = false;

        while ((line = br.readLine()) != null){

            try {

                if(line.startsWith(";P;")){
                    textQuestion = line.substring(3);
                    question = true;
                }else if (question && line.startsWith(";R;")){
                    rightOption = Integer.parseInt(line.substring(3).trim());
                    answer = true;
                } else if(answer) {
                    pointsQuestion = Integer.parseInt(line.trim());
                    points = true;
                } else if (question){
                    answers.add(new Answer(line));

                    if (answers.size()>4){
                        throw new Exception();
                    }
                }

                if(question && answer && points && (answers.size() >= 2 && answers.size() <=4)){
                    answers.get(rightOption - 1).setRight(true);

                    q = new Question(textQuestion, answers, pointsQuestion);

                    questions.add(q);

                    question = false;
                    answer = false;
                    points =false;
                    answers = new ArrayList<>();
                }

            } catch (Exception ex) {
                question = false;
                answer = false;
                points =false;
                answers = new ArrayList<>();
            }

        }

        br.close();
    }

    public void makeTest(){

        if (questions.isEmpty()){
            System.out.println("No hay preguntas");
        }
        else {
            int i = 0;
            Question q;
            int answer;
            Scanner write = new Scanner(System.in);

            while (i<questions.size()){
                q = questions.get(i);
                q.showQuestion();

                System.out.println("Introduce la respuesta");
                answer = write.nextInt();
                answer = answer <= 4 ? answer : 4;

                if (q.checkAnswer(answer)){
                    System.out.println("Has acertado");
                    allPoints+=q.getPoints();
                }
                else {
                    System.out.println("Fallaste!!!");
                    break;
                }

                i++;
            }
        }

        System.out.println("has obtenido " + allPoints + "puntos");

    }
}
