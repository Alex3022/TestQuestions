package alex.sofka.reto;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    private static final String[] banco_de_preguntas = {"geografia.txt", "historia.txt", "matematica.txt", "fisica.txt","politica.txt"};

    public static void main(String[] args) {

        boolean play = true;
        Scanner in = new Scanner(System.in);
        int opt;

        while (play){
            imprimirMenu();
            opt = in.nextInt();
            switch (opt){
                case 1:
                    playTest();
                    break;
                case 2:
                    play = false;
                    System.out.println("Hasta pronto, vuelve!!");
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta");
                    break;
            }
        }

    }

    public static void imprimirMenu(){
        System.out.println("Bienvenido A preguntas y Respuestas");
        System.out.println("1. Jugar");
        System.out.println("2. Exit");
        System.out.println("Selecciona una opcion:");

    }

    public static void playTest(){
        Test t = new Test();

        System.out.println("Ingresa tu nickname:");
        Scanner in = new Scanner(System.in);
        String nickname = in.next();
        Player player = new Player(nickname, 0);

        try{
            t.loadData(banco_de_preguntas[(int) Math.floor(Math.random()*(4 +1)+0)]);
            t.makeTest();
            player.setPoints(t.getAllPoints());
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }

        player.writeScore();
    }

}
