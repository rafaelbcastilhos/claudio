public class Configuration {
    String type;
    String size;
    String method;
    String from;
    String to;

    public Configuration(String type, String size, String method, String from, String to) {
        this.type = type;
        this.size = size;
        this.method = method;
        this.from = from;
        this.to = to;
    }

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public String getMethod() {
        return method;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }
}
