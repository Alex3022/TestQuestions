package alex.sofka.reto;

import java.io.*;

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

        int acumulate = 0;

        try(BufferedReader br = new BufferedReader(new FileReader("scores/"+nickname+".txt"))){
            String line;
            while ((line = br.readLine()) != null){
                acumulate+=Integer.parseInt(line);
            }

            System.out.println("El acumulado de premios que tienes es: " + acumulate);

        } catch (FileNotFoundException e) {
            System.out.println("No se tiene registro de tus premios, por favor juega primero");
        } catch (IOException e) {
            System.out.println("Hubo un error comunicate con alexbby");
        }

    }
}
