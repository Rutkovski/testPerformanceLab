import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect
public class Value {
    private int id;
    private String value;

    public Value() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
