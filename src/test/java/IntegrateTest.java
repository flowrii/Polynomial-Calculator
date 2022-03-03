import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrateTest {

    @Test
    public void test1() {
        String strP1 = "7";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("0", model.getValue());
    }

    @Test
    public void test2() {
        String strP1 = "x";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+1.0", model.getValue());
    }

    @Test
    public void test3() {
        String strP1 = "4*x^7";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+28.0*x^6", model.getValue());
    }

    @Test
    public void test4() {
        String strP1 = "9x^5+6x^4+10x^2+4";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+45.0*x^4+24.0*x^3+20.0*x", model.getValue());
    }

    @Test
    public void test5() {
        String strP1 = "100*x^11-4*x^2+2*x-12";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+1100.0*x^10-8.0*x+2.0", model.getValue());
    }

}
