import java.util.ArrayList;
import java.util.List;

public class Polinom {
    private List<Monom>polinom=new ArrayList<>();

    public List<Monom> getPolinom() {
        return polinom;
    }

    public Polinom(){

    }
    public Polinom(String string) {
        for (String val : string.split("(?=\\+|-)")) {
            int indexMinus = string.indexOf(val.charAt(0)) - 1; //verific daca coeficientul are semn inaintea lui in string
            if (indexMinus >= 0)
                if (string.charAt(indexMinus) == '-') //verific daca e "-"
                    val = "-" + val;
            polinom.add(new Monom(val));
        }
    }

}
