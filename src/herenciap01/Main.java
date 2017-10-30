/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herenciap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import modelo.Escuadron;
import modelo.Protoss;
import modelo.Terran;
import modelo.Zerg;

/**
 *
 * @author DAM
 */
public class Main {

    static List<Escuadron> misEscuadrones;

    public static void main(String[] args) throws IOException {
        misEscuadrones = new ArrayList<>();
        inicio();

    }

    public static void inicio() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = null;
        do {
            try {
                String linea = br.readLine();
                parts = linea.split(" ");
                if (parts[0].equalsIgnoreCase("a")) {
                    altaEscuadrones(parts);
                } else if (parts[0].equalsIgnoreCase("a")) {

                } else if (parts[0].equalsIgnoreCase("r")) {

                } else if (parts[0].equalsIgnoreCase("m")) {

                } else if (parts[0].equalsIgnoreCase("c")) {

                }
            } catch (IOException ex) {

            }

        } while (!parts[0].equalsIgnoreCase("s"));

    }

    public static void altaEscuadrones(String parts[]) {
        if (parts[1].equalsIgnoreCase("Terran")) {
            if (parts.length != 7) {
                System.out.println("ERROR 001: Nº ARGUMENTOS INVALIDO");

            } else {

                String nombre = parts[2];
                int ataque = Integer.parseInt(parts[3]);
                int defensa = Integer.parseInt(parts[4]);
                int edificio = Integer.parseInt(parts[5]);
                int tecnologia = Integer.parseInt(parts[6]);
                if (ataque < 1 || defensa < 1 || edificio < 1 || tecnologia < 1) {
                    System.out.println("ERROR 003: DATO INCORRECTO");

                } else if (existeEscuadron(nombre)) {
                    System.out.println("ERROR 007: YA EXISTE UN ESCUADRON CON ESE NOMBRE");
                } else {
                    Terran t = new Terran(edificio, tecnologia, nombre, 0, ataque, defensa);
                    misEscuadrones.add(t);
                    System.out.println("TERRAN DADO DE ALTA");
                }
            }
        } else if (parts[1].equalsIgnoreCase("Zerg")) {
            if (parts.length != 7) {
                System.out.println("ERROR 001: Nº ARGUMENTOS INVALIDO");
            } else {
                String nombre = parts[2];
                int ataque = Integer.parseInt(parts[3]);
                int defensa = Integer.parseInt(parts[4]);
                int esbirros = Integer.parseInt(parts[5]);
                int overlords = Integer.parseInt(parts[6]);

                if (ataque < 1 || defensa < 1 || esbirros < 1 || overlords < 1) {
                    System.out.println("ERROR 003: DATO INCORRECTO");

                } else if (existeEscuadron(nombre)) {
                    System.out.println("ERROR 007: YA EXISTE UN ESCUADRON CON ESE NOMBRE");
                } else {
                    Zerg z = new Zerg(esbirros, overlords, nombre, 0, ataque, defensa);
                    misEscuadrones.add(z);
                    System.out.println("ZERG DADO DE ALTA");
                }
            }
        } else if (parts[1].equalsIgnoreCase("Protoss")) {
            if (parts.length != 6) {
                System.out.println("ERROR 001: Nº ARGUMENTOS INVALIDO");
            } else {
                String nombre = parts[2];
                int ataque = Integer.parseInt(parts[3]);
                int defensa = Integer.parseInt(parts[4]);
                int pilones = Integer.parseInt(parts[5]);

                if (ataque < 1 || defensa < 1 || pilones < 1) {
                    System.out.println("ERROR 003: DATO INCORRECTO");

                } else if (existeEscuadron(nombre)) {
                    System.out.println("ERROR 007: YA EXISTE UN ESCUADRON CON ESE NOMBRE");
                } else {
                    Protoss p = new Protoss(pilones, nombre, 0, ataque, defensa);
                    misEscuadrones.add(p);
                    System.out.println("PROTOSS DADO DE ALTA");
                }
            }
        }
    }

    private static void registrarBatalla(String[] array) {
        String nombreEscuadron1 = array[1];
        String nombreEscuadron2 = array[2];
        Escuadron e1 = buscarEscuadron(nombreEscuadron1);
        Escuadron e2 = buscarEscuadron(nombreEscuadron1);
        int contadorj1 = 0;
        int contadorj2 = 0;
        int aleatorio = (int) (Math.random() * 9 + 0);
        int aleatorio2 = (int) (Math.random() * 9 + 0);
        if (e1 != null && e2 != null) {
            for (int asaltos = 5; asaltos != 0; asaltos--) {

                double j1 = aleatorio + e1.calcularAtaque() - e2.calcularDefensa();
                double j2 = aleatorio2 + e2.calcularAtaque() - e1.calcularDefensa();
                String gana = "";
                if (j1 > j2) {
                    System.out.println("J1 GANA UNA RONDA");
                    gana = nombreEscuadron1;
                    contadorj1++;
                } else if (j1 == j2) {
                    System.out.println("EMPATE");
                } else {
                    gana = nombreEscuadron2;
                    contadorj2++;
                }
                System.out.println("Asalto numero" + asaltos);
                System.out.println(" ");
                System.out.println("Ataca" + nombreEscuadron1 + "Nº ALEATORIO" + aleatorio + "VALOR DE SU ATAQUE" + j1);
                System.out.println("Ataca" + nombreEscuadron2 + "Nº ALEATORIO" + aleatorio2 + "VALOR DE SU ATAQUE" + j2);
                System.out.println(" ");
                System.out.println("Ganador del asalto " + gana);

            }
            if (contadorj1 > contadorj2) {
                System.out.println("GANADOR JUGADOR 1" + "PUNTUACION J1: " + contadorj1 + "VS PUNTUACION J2"+contadorj2);
            } else {
                System.out.println("GANADOR JUGADOR 2" + "PUNTUACION: " + contadorj2 + "VS PUNTUACION J2"+contadorj2);
            }

        }
    }

    public static boolean existeEscuadron(String nombre) {
        for (Escuadron e : misEscuadrones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }

    public static Escuadron buscarEscuadron(String nombre) {
        for (Escuadron e : misEscuadrones) {
            if (e.getNombre().equalsIgnoreCase(nombre)) {
                return e;
            }
        }
        return null;
    }
}
