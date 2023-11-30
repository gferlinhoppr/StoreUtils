package com.example.givechange.solution;

import com.example.givechange.solution.constants.ChangeConstants;
import com.example.givechange.solution.enums.ChangeValuesEnum;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class GiveChangeSolution {

    public static void main(String[] args) {

        final Scanner scanner = new Scanner(System.in);

        while(true) {
            try{
                System.out.println("Entrer le prix total: ");
                final BigDecimal totalDue = scanner.nextBigDecimal();

                System.out.println("Entrer le montant donné par le client: ");
                final BigDecimal moneyGivenByCustomer = scanner.nextBigDecimal();

                final BigDecimal changeDueToCustomer = moneyGivenByCustomer.subtract(totalDue);

                System.out.println(getChangeDetailForCustomer(changeDueToCustomer));
            }catch(InputMismatchException e){
                System.out.println("Le nombre entré n'est pas valide");
                scanner.next();
            }
        }
    }

    static String getChangeDetailForCustomer(BigDecimal totalRemaining) {

        final Map<ChangeValuesEnum, Integer> changeDetailOccurrenceByChangeValues = new LinkedHashMap<>();
        BigDecimal remaining = totalRemaining;

        final boolean notEnoughMoneyGiven = totalRemaining.doubleValue() < 0;
        final boolean noChangeToGive = totalRemaining.doubleValue() == 0;

        if(notEnoughMoneyGiven){
            return ChangeConstants.NOT_ENOUGH_MONEY_INFO_MESSAGE;
        }else if (noChangeToGive){
            return ChangeConstants.NO_CHANGE_TO_GIVE_INFO_MESSAGE;
        }

        for(ChangeValuesEnum changeValue: ChangeValuesEnum.values()){
            remaining = subtractAndCountChangeValueOccurrenceInRemaining(remaining, changeValue, changeDetailOccurrenceByChangeValues);
        }

        return getFormattedResultByChangeType(changeDetailOccurrenceByChangeValues);
    }

    private static BigDecimal subtractAndCountChangeValueOccurrenceInRemaining(BigDecimal remaining, ChangeValuesEnum changeValue, Map<ChangeValuesEnum, Integer> changeDetailOccurrenceByChangeValues) {

        int occurrenceOfChangeValueInRemaining = 0;
        final BigDecimal changeDecimalValue = changeValue.getBigDecimalValue();

        while(remaining.subtract(changeDecimalValue).doubleValue() >= 0){
            remaining = remaining.subtract(changeDecimalValue);
            occurrenceOfChangeValueInRemaining++;
        }

        changeDetailOccurrenceByChangeValues.put(changeValue, occurrenceOfChangeValueInRemaining);

        return remaining;
    }

    private static String getFormattedResultByChangeType(Map<ChangeValuesEnum, Integer> changeDetailByChangeValues){
        StringBuilder formattedMessageSb = new StringBuilder(ChangeConstants.CHANGE_MESSAGE);

        for(Map.Entry<ChangeValuesEnum, Integer> changeValue :changeDetailByChangeValues.entrySet()){
            int occurrenceChangeValueNumber = changeValue.getValue();
            if(occurrenceChangeValueNumber > 0){
                formattedMessageSb.append(getFormattedResultByChangeTypeAndNumberOccurrence(changeValue.getKey(), occurrenceChangeValueNumber));
            }
        }

        return formattedMessageSb.toString();
    }

    private static String getFormattedResultByChangeTypeAndNumberOccurrence(ChangeValuesEnum key, int occurrenceChangeValueNumber) {
        String stringToFormat = "";
        switch (key.getChangeValueType()){
            case CASH -> stringToFormat = "    - %d billet(s) de %.0f euros%n";
            case UNIT_COIN -> stringToFormat =  "    - %d pièce(s) de %.0f euros%n";
            case CENT_COIN -> stringToFormat = "    - %d pièce(s) de %.2f centimes%n";
        }

        return String.format(stringToFormat, occurrenceChangeValueNumber, key.getBigDecimalValue());
    }

}