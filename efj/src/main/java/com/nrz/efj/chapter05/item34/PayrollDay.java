package com.nrz.efj.chapter05.item34;

import static com.nrz.efj.chapter05.item34.PayrollDay.PayType.WEEKDAY;
import static com.nrz.efj.chapter05.item34.PayrollDay.PayType.WEEKEND;

/**
 * PayrollDay -> PayType 계산 메서드를 위임하여 switch 문 없이 안전하고 유연하게 구현 가능
 * */
public enum PayrollDay {
    MONDAY(WEEKDAY), TUESDAY(WEEKDAY), WEDNESDAY(WEEKDAY),
    THURSDAY(WEEKDAY), FRIDAY(WEEKDAY),
    SATURDAY(WEEKEND), SUNDAY(WEEKEND);

    private final PayType payType;

    PayrollDay(PayType payType){this.payType = payType;}

    int pay(int minutesWorked, int payRate){
        return payType.pay(minutesWorked, payRate);
    }

    enum PayType{
        WEEKDAY{
            int overtimePay(int minsWorked, int payRate){
                return minsWorked <= MINS_PER_SHIFT ? 0 :
                    (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND{
            int overtimePay(int minsWorked, int payRate){
                return minsWorked * payRate / 2;
            }
        };

        abstract int overtimePay(int mins, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate){
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
