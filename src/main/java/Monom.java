public class Monom {
    private int grad;
    private double coef;

    public Monom(int grad, double coef) {
        this.grad = grad;
        this.coef = coef;
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
                str = String.valueOf(coef);
            default:
                str = String.valueOf(coef) + "*x^" + String.valueOf(grad);
        }
        return str;
    }
}
