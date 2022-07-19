package client;

public class Pair {

    private String name = "";
    private String value = "";

    public Pair(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    private void setName(String name) {
        if (isNotValidString(name)) return;

        this.name = name;
    }

    private void setValue(String value) {
        if (isNotValidString(value)) return;

        this.value = value;
    }

    private boolean isNotValidString(String arg) {
        if (arg == null) return true;
        return arg.trim().isEmpty();
    }
}
