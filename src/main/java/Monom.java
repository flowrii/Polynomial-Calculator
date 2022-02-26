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
                if(str.charAt(0)=='-')
                    this.coef=-1;
                else
                    this.coef = 1;
            } else {
                if (str.substring(0, 1).equals("+"))          // "+2*x"
                    this.coef = Integer.valueOf(str.substring(1, str.indexOf("*")));
                else if (str.substring(0, 1).equals("-"))      // "-3*x"
                    this.coef = -Integer.valueOf(str.substring(1, str.indexOf("*")));
                else
                    this.coef = Integer.valueOf(str.substring(0, str.indexOf("*")));    // "2*x"
            }
            if (!str.contains("^")) {
                this.grad = 1;
            } else {
                this.grad = Character.getNumericValue(str.charAt(str.indexOf("^") + 1));
            }
        } else {
            this.grad = 0;
            if (str.length() == 1)
                this.coef = Integer.valueOf(str);
            else switch (str.substring(0, 1)) {
                case "-":
                    this.coef = Integer.valueOf(str);
                    break;
                case "+":
                    this.coef = Integer.valueOf(str.substring(1));
                    break;
                default:
                    this.coef = Integer.valueOf(str);
            }
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
