package org.example.effective.chapter4.item17;

import java.util.Date;

final class TimePeriod {
    private final Date start;
    private final Date end;

    public TimePeriod(Date start, Date end) {
        // 방어적 복사
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
    }

    public Date getStart() {
        return new Date(start.getTime()); // 방어적 복사
    }

    public Date getEnd() {
        return new Date(end.getTime()); // 방어적 복사
    }
}