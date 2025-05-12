package com.nrz.efj.chapter03.item17.pros_and_cons;

import java.math.BigInteger;

public class BigIntegerUtils {

    public static BigInteger safeInstance(BigInteger val){
        return val.getClass() == BigInteger.class ? val : new BigInteger(val.toByteArray());
    }

}
