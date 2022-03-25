package alex.sofka.reto;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Player {

    private String nickname;
    private int points;

    public Player(String nickname, int points) {
        this.nickname = nickname;
        this.points = points;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void writeScore(){

        try(FileWriter fw = new FileWriter("scores/"+nickname+".txt", true);) {

            fw.write(points+"\n");

        } catch( Exception ex){
            System.out.println("se puteo");
        }
    }

    public void showAcumulateScore(){

    }
}
