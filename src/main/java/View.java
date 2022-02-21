import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class View extends JFrame {

    private JTextField pol1 = new JTextField(20);
    private JTextField pol2 = new JTextField(20);
    private JTextField total = new JTextField(20);
    private JButton addBtn = new JButton("       Add        ");
    private JButton clearBtn = new JButton("Clear");
    private JButton subBtn = new JButton("  Substract  ");
    private JButton multiplyBtn = new JButton("    Multiply    ");
    private JButton divBtn=new JButton("         Div        ");
    private JButton derivateBtn=new JButton("Derivate P1 ");
    private JButton integrateBtn=new JButton("Integrate P1");

    private Model m_model;

    View(Model model) {

        m_model = model;
        m_model.setValue(Model.INITIAL_VALUE);

        total.setText(m_model.getValue());
        total.setEditable(false);

        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        Box box1 = Box.createHorizontalBox();
        box1.add(new JLabel("P1"));
        box1.add(pol1);
        Box box2 = Box.createHorizontalBox();
        box2.add(new JLabel("P2"));
        box2.add(pol2);
        Box box3 = Box.createVerticalBox();
        box3.add(box1);
        box3.add(box2);
        content.add(box3);
        Box box4 = Box.createVerticalBox();
        box4.add(addBtn);
        box4.add(subBtn);
        box4.add(multiplyBtn);
        box4.add(divBtn);
        box4.add(derivateBtn);
        box4.add(integrateBtn);
        content.add(box4);
        content.add(new JLabel("Total"));
        content.add(total);
        content.add(clearBtn);

        this.setContentPane(content);
        this.pack();

        this.setTitle("Polynomial Calc - MVC");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void reset() {
        total.setText(Model.INITIAL_VALUE);
    }

    String getPol1() {
        return pol1.getText();
    }

    String getPol2() {
        return pol2.getText();
    }

    void setTotal(String newTotal) {
        total.setText(newTotal);
    }

    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    void addAddListener(ActionListener mal) {
        addBtn.addActionListener(mal);
    }

    void addSubListener(ActionListener mal) {
        subBtn.addActionListener(mal);
    }

    void addClearListener(ActionListener cal) {
        clearBtn.addActionListener(cal);
    }
}
