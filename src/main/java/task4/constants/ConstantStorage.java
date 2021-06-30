package task4.constants;

public enum ConstantStorage {

    WEATHER_API_KEY("b385aa7d4e568152288b3c9f5c2458a5"),
    THESSALONIKI("Thessaloniki");

    private final String value;

    ConstantStorage(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
