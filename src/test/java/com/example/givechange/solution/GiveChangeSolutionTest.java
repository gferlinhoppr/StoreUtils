package com.example.givechange.solution;

import static org.junit.jupiter.api.Assertions.*;

import com.example.givechange.solution.constants.ChangeConstants;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class GiveChangeSolutionTest {

    @Test
    public void test_decimal_entry_should_return_cash_coins_and_cents(){

        String expectedSb = ChangeConstants.CHANGE_MESSAGE + String.format("    - 1 billet(s) de 5 euros%n") +
                String.format("    - 1 pièce(s) de 2 euros%n") +
                String.format("    - 1 pièce(s) de 1 euros%n") +
                String.format("    - 1 pièce(s) de 0,50 centimes%n") +
                String.format("    - 1 pièce(s) de 0,20 centimes%n") +
                String.format("    - 1 pièce(s) de 0,05 centimes%n") +
                String.format("    - 2 pièce(s) de 0,02 centimes%n");

        assertEquals(expectedSb, GiveChangeSolution.getChangeDetailForCustomer(BigDecimal.valueOf(8.79)));
    }

    @Test
    public void test_negative_decimal_should_return_info_message(){
        assertEquals(ChangeConstants.NOT_ENOUGH_MONEY_INFO_MESSAGE,
                GiveChangeSolution.getChangeDetailForCustomer(BigDecimal.valueOf(-1.53)));

    }

    @Test
    public void test_zero_should_return_info_message(){
        assertEquals(ChangeConstants.NO_CHANGE_TO_GIVE_INFO_MESSAGE,
                GiveChangeSolution.getChangeDetailForCustomer(BigDecimal.valueOf(0.0)));

    }

}
