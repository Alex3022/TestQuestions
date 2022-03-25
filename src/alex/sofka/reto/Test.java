package alex.sofka.reto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {

    private final ArrayList<Question> questions;
    private int allPoints;
    private int actuallyQuestion;

    public Test(){
        questions = new ArrayList<>();
        allPoints = 0;
        actuallyQuestion = 0;
    }

    public List<Question> getQuestions() {
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

    public void loadData(String file) throws IOException{

        String line;
        Question q;
        ArrayList<Answer> answers = new ArrayList<>();
        String textQuestion = "";
        int pointsQuestion = 0;
        int rightOption = 0;
        boolean question = false;
        boolean answer = false;
        boolean points = false;

        try(BufferedReader br = new BufferedReader(new FileReader(file))) {

        while ((line = br.readLine()) != null){



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

                if(question && answer && points && answers.size() >= 2 ){
                    answers.get(rightOption - 1).setRight(true);

                    q = new Question(textQuestion, answers, pointsQuestion);

                    questions.add(q);

                    question = false;
                    answer = false;
                    points =false;
                    answers = new ArrayList<>();
                }

            }
        }catch (Exception ex) {
            question = false;
            answer = false;
            points =false;
            answers = new ArrayList<>();
        }
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

                System.out.println("Introduce el numero de la respuesta (1 - 4) o 0 para salir");
                answer = write.nextInt();

                if( !(answer >= 1 && answer <= 4)){
                    System.out.println("Has abandonado te vas con tu premio");
                    break;
                } else if (q.checkAnswer(answer)){
                    System.out.println("Has acertado");
                    allPoints+=q.getPoints();
                } else {
                    System.out.println("Fallaste!!!");
                    allPoints = 0;
                    break;
                }

                i++;
            }
        }

        System.out.println("has obtenido " + allPoints + " puntos");

    }
}
