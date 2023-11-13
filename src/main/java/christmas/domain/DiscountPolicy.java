package christmas.domain;

public interface DiscountPolicy {
    Price discount(Integer visitDate, December december);
}
