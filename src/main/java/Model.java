import java.math.BigInteger;
import java.util.Collections;

public class Model {

    private String total="";

    Model() {
        reset();
    }

    public void reset() {
        total = new String("");
    }

    public void add(Polinom p1 , Polinom p2){
        Polinom rez=new Polinom();

        p1.getPolinom().forEach((m1)-> {
            rez.getPolinom().add(m1);
        });
        p2.getPolinom().forEach((m2)-> {
            rez.getPolinom().add(m2);
        });
        Collections.sort(rez.getPolinom());
        int index=0;
        while(index<rez.getPolinom().size()-1 && rez.getPolinom().size()>1) {
            Monom mo1=rez.getPolinom().get(index);
            Monom nextM = rez.getPolinom().get(index + 1);
            if (mo1.compareTo(nextM) == 0) {
                mo1.setCoef(mo1.getCoef() + nextM.getCoef());
                rez.getPolinom().remove(nextM);
            }
            else {
                index += 1;
            }
        }
        rez.getPolinom().forEach(mo->{total+=mo.toString();});
    }

    public void substract(Polinom p1, Polinom p2){
        Polinom rez=new Polinom();

        p1.getPolinom().forEach((m1)-> {
            rez.getPolinom().add(m1);
        });
        p2.getPolinom().forEach((m2)-> {
            m2.setCoef(-m2.getCoef());
            rez.getPolinom().add(m2);
        });
        Collections.sort(rez.getPolinom());
        int index=0;
        while(index<rez.getPolinom().size()-1 && rez.getPolinom().size()>1) {
            Monom mo1=rez.getPolinom().get(index);
            Monom nextM = rez.getPolinom().get(index + 1);
            if (mo1.compareTo(nextM) == 0) {
                mo1.setCoef(mo1.getCoef() + nextM.getCoef());
                rez.getPolinom().remove(nextM);
            }
            else {
                index += 1;
            }
        }
        rez.getPolinom().forEach(mo->{total+=mo.toString();});
    }

    public void mul(Polinom p1, Polinom p2){
        Polinom rez=new Polinom();

        p1.getPolinom().forEach(m1->{
            p2.getPolinom().forEach(m2->{
                Monom partial=new Monom(m1.getGrad()+m2.getGrad(),m1.getCoef()*m2.getCoef());
                rez.getPolinom().add(partial);
            });
        });

        rez.getPolinom().forEach(mo->{total+=mo.toString();});
    }

    public void derivate(Polinom p1){
        Polinom rez=new Polinom();

        p1.getPolinom().forEach(m->{
            Monom partial=new Monom(m.getGrad()-1,m.getCoef()*m.getGrad());
            if(partial.getGrad()<0) {
                partial.setCoef(0);
                partial.setGrad(0);
            }
            rez.getPolinom().add(partial);
        });
        rez.getPolinom().forEach(mo->{total+=mo.toString();});
    }

    public void integrate(Polinom p1) {
        Polinom rez=new Polinom();

        p1.getPolinom().forEach(m->{
            Monom partial=new Monom(m.getGrad()+1,m.getCoef()/(m.getGrad()+1));

            rez.getPolinom().add(partial);
        });
        rez.getPolinom().forEach(mo->{total+=mo.toString();});
    }

    public void setValue(String value) {
        total = new String(value);
    }

    public String getValue() {
        return total;
    }
}

