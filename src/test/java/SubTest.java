import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SubTest {

    @Test
    public void test1() {
        String strP1 = "7";
        String strP2 = "-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("+18.0", model.getValue());
    }

    @Test
    public void test2() {
        String strP1 = "2*x";
        String strP2 = "-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("+2.0*x+11.0", model.getValue());
    }

    @Test
    public void test3() {
        String strP1 = "-5";
        String strP2 = "11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("-16.0", model.getValue());
    }

    @Test
    public void test4() {
        String strP1 = "2*x";
        String strP2 = "x^2-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("-x^2+2.0*x+11.0", model.getValue());
    }

    @Test
    public void test5() {
        String strP1 = "x^11+4*x^2+2*x+12";
        String strP2 = "x^2-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("+x^11+3.0*x^2+2.0*x+23.0", model.getValue());
    }

    @Test
    public void test6() {
        String strP1 = "2*x";
        String strP2 = "-2*x-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("+4.0*x+11.0", model.getValue());
    }

    @Test
    public void test7() {
        String strP1 = "100*x^11-4*x^2+2*x-12";
        String strP2 = "100*x^11-4*x^2+2*x-12";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("0", model.getValue());
    }

    @Test
    public void test8() {
        String strP1 = "0";
        String strP2 = "0";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("0", model.getValue());
    }

    @Test
    public void test9() {
        String strP1 = "4x^2";
        String strP2 = "100*x^11+4*x^2+2*x-12";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model = new Model();
        model.substract(p1, p2);
        assertEquals("-100.0*x^11-2.0*x+12.0", model.getValue());
    }
}
