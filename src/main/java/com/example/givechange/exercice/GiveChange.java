package com.example.givechange.exercice;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class GiveChange {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true) {
        System.out.println("Entrer le prix total: ");
        Double value1 = scanner.nextDouble();
            System.out.println("Entrer le montant donné par le client: ");
          Double value2 = scanner.nextDouble();

            // Peut servir plus tard
//            System.out.println("Entrer les valeurs de monnaies manquantes dans la caisse: ");
//            Double value3 = scanner.nextString();

          System.out.println(processValue(value2 - value1));

        }
    }

    static String processValue(Double value) {
        // Note: Quand j'utilisais un double j'avais une boucle infinie sur le while
        // alors que mon nombre vaut 0, j'ai donc fait les calculs en int, à refacto plus tard
        Double newValue = (value*100);

        int valueInCent = newValue.intValue();
        int fifty = 0, twenty = 0, ten = 0, five = 0, two = 0, one = 0, fiftyCents = 0, twentyCents = 0, tenCents = 0, fiveCents = 0, twoCents = 0, oneCent = 0;

        while (valueInCent > 0){
            if(valueInCent - 5000 >= 0){
                valueInCent -= 5000;
                fifty++;
            }else if(valueInCent - 2000 >= 0){
                valueInCent -= 2000;
                twenty++;
            } else if (valueInCent - 1000 >= 0) {
                valueInCent -= 1000;
                ten++;
            } else if (valueInCent - 500 >= 0) {
                valueInCent -= 500;
                five++;
            } else if (valueInCent - 200 >= 0) {
                valueInCent -= 200;
                two++;
            } else if (valueInCent - 100 >= 0) {
                valueInCent -= 100;
                one++;
            } else if (valueInCent - 50 >= 0) {
                valueInCent -= 50;
                fiftyCents++;
            } else if (valueInCent - 20 >= 0) {
                valueInCent -= 20;
                twentyCents++;
            } else if (valueInCent - 10 >= 0) {
                valueInCent -= 10;
                tenCents++;
            } else if (valueInCent - 5 >= 0) {
                valueInCent -= 5;
                fiveCents++;
            } else if (valueInCent - 2 >= 0) {
                valueInCent -= 2;
                twoCents++;
            } else if (valueInCent - 1 >= 0) {
                valueInCent -= 1;
                oneCent++;
            }

        }

        return String.format("Je dois rendre: %d billets de 50, %d billets de 20, %d billets de 10, %d billets de 5, %d pièces de 2, %d pièces de 1, %d pièces de 50 centimes, %d pièces de 20 centimes, %d pièces de 10 centimes, %d pièces de 5 centimes, %d pièces de 2 centimes, %d pièces de 1 centime", fifty, twenty, ten, five, two, one, fiftyCents, twentyCents, tenCents, fiveCents, twoCents, oneCent);
    }


}