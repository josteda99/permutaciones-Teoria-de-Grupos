package permutaciones;

import java.util.ArrayList;
import java.util.LinkedList;

public class Permutaciones {

    static ArrayList<String> test = new ArrayList<>();

    public static void main(String[] args) {

        LinkedList<Character> conjunto = new LinkedList<>();
        conjunto.add('1');
        conjunto.add('2');
        conjunto.add('3');
        conjunto.add('4');
        conjunto.add('5');

        escribir("", conjunto);
        /*
         char[] f = {'3', '2', '1'};
         char[] g = {'2', '1', '3'};
         composicion(f, g);
         
         //char[] f = test.get(0).toCharArray();
         for (int i = 0; i < test.size(); i++) {
         System.out.println(i + " " + test.get(i));
         }
         */
        int tam = factorial(conjunto.size()) + 1;

        String[][] matriz = new String[tam][tam];
        //System.out.println(matriz.length);

        for (int i = 1; i < matriz.length; i++) {
            matriz[0][i] = test.get(i - 1);
        }

        for (int i = 1; i < matriz.length; i++) {
            matriz[i][0] = test.get(i - 1);
        }

        //rellenar
        for (int i = 1; i < matriz.length; i++) {
            for (int j = 1; j < matriz.length; j++) {
                char[] f = matriz[0][j].toCharArray();
                char[] g = matriz[i][0].toCharArray();
                matriz[i][j] = composicion(f, g);
            }
        }

        //imprimir
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                System.out.print(matriz[i][j] + " ");;
            }
            System.out.println("");
        }

    }

    public static int factorial(int numero) {
        if (numero == 0) {
            return 1;
        } else {
            return numero * factorial(numero - 1);
        }
    }

    public static void escribir(String a, LinkedList<Character> conjunto) {
        ArrayList<Character> t = new ArrayList<>();
        if (conjunto.size() == 1) {
            //System.out.println(a + conjunto.get(0));
            //t.add(conjunto.get(0));
            test.add(a + conjunto.get(0));
        }

        for (int i = 0; i < conjunto.size(); i++) {
            Character b = conjunto.remove(i);
            escribir(a + b, conjunto);
            conjunto.add(i, b);
        }

    }

    public static String composicion(char[] f, char[] g) {
        char[] comp = new char[f.length];
        char[] num = {'1', '2', '3', '4', '5'};

        int posi;

        for (int i = 0; i < f.length; i++) {
            for (int j = 0; j < f.length; j++) {

                if (num[i] == f[j]) {
                    posi = (j + 1);
                    //System.out.println(posi);

                    for (int k = 0; k < f.length; k++) {
                        //System.out.println(Character.getNumericValue(g[k]) + " " + posi);
                        if (Character.getNumericValue(g[k]) == posi) {
                            //System.out.println(k+1);
                            int temp = k + 1;
                            comp[i] = (char) (temp + '0');
                        }
                    }
                }

            }
        }
        return String.valueOf(comp);
    }
}
