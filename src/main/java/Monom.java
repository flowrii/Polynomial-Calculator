import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Locale;

public class Monom implements Comparable<Monom> {
    private int grad;
    private double coef;

    public Monom(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
    }

    public Monom(String str) {
        str = str.toLowerCase();
        if (str.contains("x")) {
            if (!str.contains("*")) {
                if(str.substring(0, str.indexOf("x")).length()>0)
                    stringToCoef(str.substring(0, str.indexOf("x")));
                else
                    this.coef=1;
            } else {
                stringToCoef(str.substring(0, str.indexOf("*")));
            }
            if (!str.contains("^")) {
                this.grad = 1;
            } else {
                    stringToGrad(str.substring(str.indexOf("^") + 1));
            }
        } else {
            this.grad = 0;
            stringToCoef(str);
        }
    }

    public void stringToGrad(String str){
        try {
            this.grad = Integer.valueOf(str);
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Polinom invalid!");
        }
    }

    public void stringToCoef(String str){
        try {
            if (str.length() == 1) {
                if (str.charAt(0) == '-')
                    this.coef = -1;
                else if (str.charAt(0) == '+')
                    this.coef = 1;
                else
                    this.coef = Integer.valueOf(str);
            } else {
                if (str.charAt(0)=='+')             // "+2*x"
                    this.coef = Integer.valueOf(str.substring(1));
                else if (str.charAt(0) == '-')      // "-3*x"*/
                    this.coef = -Integer.valueOf(str.substring(1));
                else                                // "2*x"
                    this.coef = Integer.valueOf(str);
            }
        }
        catch (NumberFormatException ex){
            JOptionPane.showMessageDialog(null,"Polinom invalid!");
        }
    }

    public void setGrad(int grad) {
        this.grad = grad;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getGrad() {
        return grad;
    }

    public double getCoef() {
        return coef;
    }

    @Override
    public String toString() {
        String str;
        switch (grad) {
            case 0:
                if (coef > 0) {
                    str = "+" + coef;
                } else {
                    if(coef!=0)
                        str = String.valueOf(coef);
                    else
                        str="";
                }
                break;
            case 1:
                if (coef > 0) {
                    if(coef==1)
                        str = "+" + "x";
                    else
                        str = "+" + coef + "*x";
                } else {
                    if(coef==-1)
                        str = "-" + "x";
                    else
                        str = coef + "*x";
                }
                break;
            default:
                if (coef > 0) {
                    if(coef!=1)
                        str = "+" + coef + "*x^" + grad;
                    else
                        str = "+" + "x^" + grad;
                } else {
                    if(coef!=-1)
                        str = coef + "*x^" + grad;
                    else
                        str = "-" + "x^" + grad;
                }
                break;
        }
        return str;
    }

    public void print() {
        System.out.println(this.coef + " " + this.grad);
    }

    @Override
    public int compareTo(Monom o) {
        return o.getGrad() - this.getGrad();
    }
}
