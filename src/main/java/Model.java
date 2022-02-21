import java.math.BigInteger;

public class Model {

    static final String INITIAL_VALUE = "0";

    private String m_total;

    Model() {
        reset();
    }

    public void reset() {
        m_total = new String(" ");
    }

    public void add(String operand1, String operand2){

    }

    public void substract(String operand1, String operand2){

    }

    public void setValue(String value) {
        m_total = new String(value);
    }

    public String getValue() {
        return m_total.toString();
    }
}

