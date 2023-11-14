package christmas.validation;

import static christmas.constant.ErrorMessage.INVALID_INPUT;

public class VisitDateValidation {

    public static boolean validateVisitDate(String visitDate) {
        int date;
        try {
            date = Integer.parseInt(visitDate);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(INVALID_INPUT);
        }
        if (date < 1 || date > 32) {
            throw new IllegalArgumentException(INVALID_INPUT);
        }
        return false;
    }
}
