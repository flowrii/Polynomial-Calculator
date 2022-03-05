import java.awt.event.*;

public class Controller {

    private Model model;
    private View view;

    Controller(Model model, View view) {
        this.model = model;
        this.view = view;

        view.addAddListener(new AddListener());
        view.subAddListener(new SubtractListener());
        view.multiplyAddListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
        view.derivateAddListener(new DerivateListener());
        view.integrateAddListener(new IntegrateListener());
        view.divAddListener(new DivListener());
    }

    public boolean checkStrings(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            view.showError("Introduceti 2 (doua) polinoame in campurile destinate!");
            return false;
        } else if ((str1.chars().distinct().filter(ch -> ch >= 'a' && ch <= 'z').count() > 1) || (str2.chars().distinct().filter(ch -> ch >= 'a' && ch <= 'z').count() > 1) ||
                (str1.chars().distinct().filter(ch -> ch >= 'a' && ch <= 'z').count() == 1 && (!str1.contains("x"))) ||
                (str2.chars().distinct().filter(ch -> ch >= 'a' && ch <= 'z').count() == 1 && (!str2.contains("x")))) {
            view.showError("Folositi numai litera x ca si variabila pentru polinoame!");
            return false;
        }
        return true;
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";
            String str2 = "";

            str1 = view.getPol1().replaceAll("\\s+", "");
            str2 = view.getPol2().replaceAll("\\s+", "");

            if (checkStrings(str1, str2)) {
                Polinom pol1 = new Polinom(str1);
                Polinom pol2 = new Polinom(str2);

                model.reset();
                model.add(pol1, pol2);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class SubtractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";
            String str2 = "";
            str1 = view.getPol1().replaceAll("\\s+", "");
            str2 = view.getPol2().replaceAll("\\s+", "");

            if (checkStrings(str1, str2)) {
                Polinom pol1 = new Polinom(str1);
                Polinom pol2 = new Polinom(str2);

                model.reset();
                model.subtract(pol1, pol2);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";
            String str2 = "";

            str1 = view.getPol1().replaceAll("\\s+", "");
            str2 = view.getPol2().replaceAll("\\s+", "");

            if (checkStrings(str1, str2)) {
                Polinom pol1 = new Polinom(str1);
                Polinom pol2 = new Polinom(str2);

                model.reset();
                model.mul(pol1, pol2);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class DerivateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";

            str1 = view.getPol1().replaceAll("\\s+", "");
            if (checkStrings(str1, "x")) {
                Polinom pol1 = new Polinom(str1);

                model.reset();
                model.derivate(pol1);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class IntegrateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";

            str1 = view.getPol1().replaceAll("\\s+", "");
            if (checkStrings(str1, "x")) {
                Polinom pol1 = new Polinom(str1);

                model.reset();
                model.integrate(pol1);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class DivListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String str1 = "";
            String str2 = "";

            str1 = view.getPol1().replaceAll("\\s+", "");
            str2 = view.getPol2().replaceAll("\\s+", "");

            if (checkStrings(str1, str2)) {
                Polinom pol1 = new Polinom(str1);
                Polinom pol2 = new Polinom(str2);

                model.reset();
                model.div(pol1, pol2);
                view.resetTotal();
                view.setTotal(model.getValue());
            }
        }
    }

    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.reset();
            view.reset();
        }
    }
}
