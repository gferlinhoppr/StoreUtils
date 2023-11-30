package com.example.givechange.solution.enums;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum ChangeValuesEnum {

    FIFTY(50, ChangeValueType.CASH),
    TWENTY(20, ChangeValueType.CASH),
    TEN(10, ChangeValueType.CASH),
    FIVE(5, ChangeValueType.CASH),
    TWO(2, ChangeValueType.UNIT_COIN),
    ONE(1, ChangeValueType.UNIT_COIN),
    FIFTY_CENT(0.50, ChangeValueType.CENT_COIN),
    TWENTY_CENT(0.20, ChangeValueType.CENT_COIN),
    TEN_CENT(0.10, ChangeValueType.CENT_COIN),
    FIVE_CENT(0.05, ChangeValueType.CENT_COIN),
    TWO_CENT(0.02, ChangeValueType.CENT_COIN),
    ONE_CENT(0.01, ChangeValueType.CENT_COIN);

    final BigDecimal bigDecimalValue;
    final ChangeValueType changeValueType;
    ChangeValuesEnum(double value, ChangeValueType changeValueType) {
        this.bigDecimalValue = BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_EVEN);
        this.changeValueType = changeValueType;

    }

    public BigDecimal getBigDecimalValue(){
        return bigDecimalValue;
    }

    public ChangeValueType getChangeValueType() {
        return changeValueType;
    }
}
