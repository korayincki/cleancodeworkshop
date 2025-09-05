public enum CustomerType{
    CUSTOMERTYPE1(1,0),
    CUSTOMERTYPE2(2,0.07),
    CUSTOMERTYPE3(3,0.15),
    CUSTOMERTYPE4(4,0.10);
    private final int value;
    private final double rate;

    public String getValue() {
        return value;
    }

    public String getRate(int value) {
        return rate;
    }

    public static double getRateByType(int type) {
        for (MyEnum value : MyEnum.values()) {
            if (value.getType().equalsIgnoreCase(type)) {
                return value.getRate();
            }
        }
        return null;
    }
}
