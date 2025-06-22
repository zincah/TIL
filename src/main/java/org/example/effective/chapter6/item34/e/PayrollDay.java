package org.example.effective.chapter6.item34.e;

/**
 * 상수를 추가할때 잔업수당 전략을 선택하도록 함
 * private 중첩 열거 타입을 생성하여 열거타입 생성자에서 적당한 것을 선택하게끔 함
 * switch 문보다 복잡하지만 안전하고 유연함
 * 상수별 동작을 구현하는대는 switch문이 적합하지 않음
 */

public enum PayrollDay {
    MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY),THURSDAY(PayType.WEEKDAY),FRIDAY(PayType.WEEKDAY)
    ,SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
    private final PayType payType;

    PayrollDay(PayType payType) {
        this.payType = payType;
    }

    enum PayType {
        WEEKDAY {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked <= MINS_PER_SHIFT ? 0 : (minsWorked - MINS_PER_SHIFT) * payRate / 2;
            }
        },
        WEEKEND {
            int overtimePay(int minsWorked, int payRate) {
                return minsWorked * payRate / 2;
            }
        };
        abstract int overtimePay(int minsWorked, int payRate);
        private static final int MINS_PER_SHIFT = 8 * 60;

        int pay(int minsWorked, int payRate) {
            int basePay = minsWorked * payRate;
            return basePay + overtimePay(minsWorked, payRate);
        }
    }
}
