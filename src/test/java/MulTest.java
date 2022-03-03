import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MulTest {

    @Test
    public void test1() {
        String strP1 = "5";
        String strP2 = "-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("-55.0", model.getValue());
    }

    @Test
    public void test2() {
        String strP1 = "2*x";
        String strP2 = "-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("-22.0*x", model.getValue());
    }

    @Test
    public void test3() {
        String strP1 = "x-1";
        String strP2 = "x-1";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("+x^2-2.0*x+1.0", model.getValue());
    }

    @Test
    public void test4() {
        String strP1 = "x^3+2*x+7";
        String strP2 = "0";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("0", model.getValue());
    }

    @Test
    public void test5() {
        String strP1 = "x-5";
        String strP2 = "x^4+7*x-2";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("+x^5-5.0*x^4+7.0*x^2-37.0*x+10.0", model.getValue());
    }

    @Test
    public void test6() {
        String strP1 = "2*x";
        String strP2 = "-2*x-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("-4.0*x^2-22.0*x", model.getValue());
    }

    @Test
    public void test7() {
        String strP1 = "10*x^11-4*x^2+2*x-12";
        String strP2 = "20*x^11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("+200.0*x^22-80.0*x^13+40.0*x^12-240.0*x^11", model.getValue());
    }

    @Test
    public void test8() {
        String strP1 = "0";
        String strP2 = "0";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.mul(p1,p2);
        assertEquals("0", model.getValue());
    }
}
