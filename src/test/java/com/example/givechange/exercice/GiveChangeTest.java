package com.example.givechange.exercice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class GiveChangeTest {

    @Test
    public void test_should_return_result(){
        GiveChange giveChange = new GiveChange();

        assertEquals("Je dois rendre: 0 billets de 50, 0 billets de 20, 0 billets de 10, 1 billets de 5, 0 pièces de 2, 1 pièces de 1, 0 pièces de 50 centimes, 0 pièces de 20 centimes, 0 pièces de 10 centimes, 0 pièces de 5 centimes, 0 pièces de 2 centimes, 0 pièces de 1 centime", giveChange.processValue(6.0));
    }

}
