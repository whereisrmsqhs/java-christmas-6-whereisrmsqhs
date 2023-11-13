package christmas.domain;

import christmas.constant.WeekDaysAndWeekEnds;

import static christmas.constant.WeekDaysAndWeekEnds.WEEK_DAYS;
import static christmas.constant.WeekDaysAndWeekEnds.WEEK_ENDS;

public enum DateOfTheWeek {
    MONDAY("월료일", WEEK_DAYS),
    TUESDAY("화요일", WEEK_DAYS),
    WEDNESDAY("수요일", WEEK_DAYS),
    THURSDAY("목요일", WEEK_DAYS),
    FRIDAY("금요일", WEEK_ENDS),
    SATURDAY("토요일", WEEK_ENDS),
    SUNDAY("일요일", WEEK_DAYS);

    private final String dayOfTheWeek;
    private final WeekDaysAndWeekEnds weekdayType;

    DateOfTheWeek(String dayOfTheWeek, WeekDaysAndWeekEnds weekdayType) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.weekdayType = weekdayType;
    }

    public boolean isSpecialDay(Integer day) {
        return (this.dayOfTheWeek.equals("일요일") || day == 25);
    }
}
