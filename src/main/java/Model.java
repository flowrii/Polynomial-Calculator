import javax.swing.*;
import java.math.BigInteger;
import java.util.Collections;

public class Model {

    private String total = "";

    Model() {
        reset();
    }

    public void reset() {
        total = new String("");
    }

    public Polinom add(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();

        p1.getPolinom().forEach((m1) -> {
            rez.getPolinom().add(m1);
        });
        p2.getPolinom().forEach((m2) -> {
            rez.getPolinom().add(m2);
        });
        Collections.sort(rez.getPolinom());
        int index = 0;
        while (index < rez.getPolinom().size() - 1 && rez.getPolinom().size() > 1) {
            Monom mo1 = rez.getPolinom().get(index);
            Monom nextM = rez.getPolinom().get(index + 1);
            if (mo1.compareTo(nextM) == 0) {
                mo1.setCoef(mo1.getCoef() + nextM.getCoef());
                rez.getPolinom().remove(nextM);
                if (mo1.getCoef() == 0)
                    rez.getPolinom().remove(mo1);
            } else {
                index += 1;
            }
        }
        if (rez.getPolinom().size() == 0)
            rez.getPolinom().add(new Monom(0, 0));
        rez.getPolinom().forEach(mo -> {
            total += mo.toString();
        });
        return rez;
    }

    public Polinom substract(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();

        p1.getPolinom().forEach((m1) -> {
            rez.getPolinom().add(m1);
        });
        p2.getPolinom().forEach((m2) -> {
            m2.setCoef(-m2.getCoef());
            rez.getPolinom().add(m2);
        });
        Collections.sort(rez.getPolinom());
        int index = 0;
        while (index < rez.getPolinom().size() - 1 && rez.getPolinom().size() > 1) {
            Monom mo1 = rez.getPolinom().get(index);
            Monom nextM = rez.getPolinom().get(index + 1);
            if (mo1.compareTo(nextM) == 0) {
                mo1.setCoef(mo1.getCoef() + nextM.getCoef());
                rez.getPolinom().remove(nextM);
                if (mo1.getCoef() == 0)
                    rez.getPolinom().remove(mo1);
            } else {
                index += 1;
            }
        }
        if (rez.getPolinom().size() == 0)
            rez.getPolinom().add(new Monom(0, 0));
        rez.getPolinom().forEach(mo -> {
            total += mo.toString();
        });
        return rez;
    }

    public Polinom mul(Polinom p1, Polinom p2) {
        Polinom rez = new Polinom();

        p1.getPolinom().forEach(m1 -> {
            p2.getPolinom().forEach(m2 -> {
                Monom partial = new Monom(m1.getGrad() + m2.getGrad(), m1.getCoef() * m2.getCoef());
                rez.getPolinom().add(partial);
            });
        });

        Polinom rezFinal = new Polinom();
        rezFinal = add(rez, new Polinom("0"));
        eliminaZerouri(rezFinal);
        this.reset();
        rezFinal.getPolinom().forEach(mo -> {
            total += mo.toString();
        });
        return rezFinal;
    }

    public Polinom derivate(Polinom p1) {
        Polinom rez = new Polinom();

        p1.getPolinom().forEach(m -> {
            Monom partial = new Monom(m.getGrad() - 1, m.getCoef() * m.getGrad());
            if (partial.getGrad() < 0) {
                partial.setCoef(0);
                partial.setGrad(0);
            }
            rez.getPolinom().add(partial);
        });
        rez.getPolinom().forEach(mo -> {
            total += mo.toString();
        });

        return rez;
    }

    public Polinom integrate(Polinom p1) {
        Polinom rez = new Polinom();

        p1.getPolinom().forEach(m -> {
            Monom partial = new Monom(m.getGrad() + 1, m.getCoef() / (m.getGrad() + 1));

            rez.getPolinom().add(partial);
        });
        rez.getPolinom().forEach(mo -> {
            total += mo.toString();
        });
        return rez;
    }

    public Polinom div(Polinom p1, Polinom p2) {
        Polinom deimpartit = p1;
        Polinom impartitor = p2;

        Polinom rez = new Polinom();

        Collections.sort(deimpartit.getPolinom());  eliminaZerouri(deimpartit);
        Collections.sort(impartitor.getPolinom());  eliminaZerouri(impartitor);

        if(impartitor.getPolinom().get(0).getCoef()==0)
            JOptionPane.showMessageDialog(new View(new Model()),"Impartire la 0!");
        else {
            while (deimpartit.getPolinom().get(0).getGrad() >= impartitor.getPolinom().get(0).getGrad() && deimpartit.getPolinom().get(0).getCoef() != 0) {
                //impart primul monom din deimpartit la primul din impartitor si il adaug la rezultat
                Monom partial = new Monom(deimpartit.getPolinom().get(0).getGrad() - impartitor.getPolinom().get(0).getGrad(), deimpartit.getPolinom().get(0).getCoef() / impartitor.getPolinom().get(0).getCoef());
                rez.getPolinom().add(partial);
                //tin minte monomul rezultat intr-un polinom pentru a-l putea folosi la calcule mai departe
                Polinom rezPartial = new Polinom();
                rezPartial.getPolinom().add(partial);

                //inmultesc rezultatul impartirii cu impartitorul
                this.reset();
                Polinom inmultire = mul(rezPartial, impartitor);

                //scad rezultatul inmultirii din actualul deimpartit, totalul fiind noul deimpartit
                this.reset();
                deimpartit = substract(deimpartit, inmultire);
            }
        }
        this.reset();
        rez.getPolinom().forEach(mo -> {
            total += mo.toString();
        });
        if (deimpartit.getPolinom().size() > 0) {
            total +="  REST:";
            deimpartit.getPolinom().forEach(mo -> {
                total += mo.toString();
            });
        }
        return rez;
    }

    public void eliminaZerouri(Polinom p){
        for(int i=0; i<p.getPolinom().size();i++)
        {
            if(p.getPolinom().get(i).getCoef()==0)
                p.getPolinom().remove(p.getPolinom().get(i));
        }
        if(p.getPolinom().size()==0)
            p.getPolinom().add(new Monom(0,0));
    }

    public void setValue(String value) {
        total = new String(value);
    }

    public String getValue() {
        if(total.equals(""))
            total+="0";
        return total;
    }
}

