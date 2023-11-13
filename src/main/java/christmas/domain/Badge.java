package christmas.domain;

public enum Badge {
    STAR("별", new Price(5000)),
    TREE("트리", new Price(10000)),
    SANTA("산타", new Price(20000));

    private String badgeName;
    private Price acquiredCondition;

    Badge(String badgeName, Price acquiredCondition) {
        this.badgeName = badgeName;
        this.acquiredCondition = acquiredCondition;
    }

    public String getBadgeName() {
        return badgeName;
    }
}
