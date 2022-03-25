package alex.sofka.reto;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Test t = new Test();

        try{
            t.loadData("preguntas-correcto.txt");
            t.makeTest();
        } catch (IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
