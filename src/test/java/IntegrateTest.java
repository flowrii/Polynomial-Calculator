import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegrateTest {

    @Test
    public void test1() {
        String strP1 = "0";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("Const", model.getValue());
    }

    @Test
    public void test2() {
        String strP1 = "5";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+5.0*x", model.getValue());
    }

    @Test
    public void test3() {
        String strP1 = "-1";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("-x", model.getValue());
    }

    @Test
    public void test4() {
        String strP1 = "2x";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+x^2", model.getValue());
    }

    @Test
    public void test5() {
        String strP1 = "5x^4+4x^3+2x+4";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+x^5+x^4+x^2+4.0*x", model.getValue());
    }

    @Test
    public void test6() {
        String strP1 = "9x^11+6x^4-8x^3-13";
        Polinom p1 = new Polinom(strP1);
        Model model = new Model();
        model.integrate(p1);
        assertEquals("+0.75*x^12+1.2*x^5-2.0*x^4-13.0*x", model.getValue());
    }

}
