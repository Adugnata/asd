package framework.ui.pages;

import javax.swing.*;
import java.awt.*;

public class GenerateReport extends JDialog {
    protected JTextArea report;
    //{{DECLARE_CONTROLS
    JScrollPane JScrollPane1 = new JScrollPane();
    javax.swing.JTextArea JTextArea = new JTextArea();
    JButton JButton_OK = new JButton();

    public GenerateReport(Frame parent) {
        super(parent);
        report = new JTextArea();
        getContentPane().setLayout(null);
        setSize(780, 560);
        setVisible(false);
        getContentPane().add(JScrollPane1);
        JScrollPane1.setBounds(24, 24, 780, 560);
        JScrollPane1.getViewport().add(report);
        report.setBounds(0, 0, 355, 237);
        JButton_OK.setText("OK");
        JButton_OK.setActionCommand("OK");
        getContentPane().add(JButton_OK);
        JButton_OK.setBounds(360, 590, 96, 24);

        //{{REGISTER_LISTENERS
        SymAction lSymAction = new SymAction();
        JButton_OK.addActionListener(lSymAction);
        //JTextArea.setText(BankingAccountService.report);
        //}}
    }

    public GenerateReport() {
        this(null);
    }

    public void setReport(String reportContent) {
        report.setText(reportContent);
    }
    //}}

    void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
        dispose();
    }

    class SymAction implements java.awt.event.ActionListener {
        public void actionPerformed(java.awt.event.ActionEvent event) {
            Object object = event.getSource();
            if (object == JButton_OK)
                JButtonOK_actionPerformed(event);
        }
    }
}

