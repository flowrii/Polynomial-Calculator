import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DivTest {

    @Test
    public void test1() {
        String strP1 = "0";
        String strP2 = "-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("0", model.getValue());
    }

    @Test
    public void test2() {
        String strP1 = "2x";
        String strP2 = "0";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("Impartire la 0!", model.getValue());
    }

    @Test
    public void test3() {
        String strP1 = "x-1";
        String strP2 = "x-1";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("+1.0", model.getValue());
    }

    @Test
    public void test4() {
        String strP1 = "x^2-2*x+1";
        String strP2 = "x-1";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("+x-1.0", model.getValue());
    }

    @Test
    public void test5() {
        String strP1 = "x-5";
        String strP2 = "x^4+7*x-2";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("  REST:+x-5.0", model.getValue());
    }

    @Test
    public void test6() {
        String strP1 = "2*x";
        String strP2 = "-2*x-11";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("-1.0  REST:-11.0", model.getValue());
    }

    @Test
    public void test7() {
        String strP1 = "x^8";
        String strP2 = "x-4";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("+x^7+4.0*x^6+16.0*x^5+64.0*x^4+256.0*x^3+1024.0*x^2+4096.0*x+16384.0  REST:+65536.0", model.getValue());
    }

    @Test
    public void test8() {
        String strP1 = "x^3+2*x^2+10*x+7";
        String strP2 = "x-5";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("+x^2+7.0*x+45.0  REST:+232.0", model.getValue());
    }

    @Test
    public void test9() {
        String strP1 = "x^8";
        String strP2 = "2x-7";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("+0.5*x^7+1.75*x^6+6.125*x^5+21.4375*x^4+75.03125*x^3+262.609375*x^2+919.1328125*x+3216.96484375  REST:+22518.75390625", model.getValue());
    }

    @Test
    public void test10() {
        String strP1 = "0";
        String strP2 = "0";
        Polinom p1 = new Polinom(strP1);
        Polinom p2 = new Polinom(strP2);
        Model model=new Model();
        model.div(p1,p2);
        assertEquals("Impartire la 0!", model.getValue());
    }
}
