public enum CustomerType{
    THOUSAND(3,0.05),
    EIHGTHUNDRED(4,0.02),
    FIVEHUNDRED(1,0.03),
    private final int value;
    private final double rate;

    public String getValue() {
        return value;
    }

    public String getRate(int value) {
        return rate;
    }

    public static double getRateByType(int value) {
        for (MyEnum value : MyEnum.values()) {
            if (value.getValue().equalsIgnoreCase(value)) {
                return value.getRate();
            }
        }
        return null;
    }
}
