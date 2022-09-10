package project;

import javax.swing.*;
import java.awt.*;
public class EMployee  extends JFrame {
    JButton ok_btn;

    public EMployee(){
        JPanel Em_panel = new JPanel();
        JFrame Em_frame = new JFrame("Employee");
        Em_frame.setResizable(false);
        Em_frame.setDefaultCloseOperation(3);
        Em_frame.setSize(320, 300);
        Em_frame.setLocation(700,200);
        Em_frame.add(Em_panel);
        Em_panel.setLayout((LayoutManager)null);
        //NameOfEmployee
        JLabel name = new JLabel("Name: ");
        name.setBounds(10, 20, 80, 25);
        Em_panel.add(name);
        JLabel em_name = new JLabel();
        em_name.setBounds(100, 20, 165, 25);
        Em_panel.add(em_name);
        //Salary label
        JLabel sal_label = new JLabel("Salary: ");
        sal_label.setBounds(10, 60, 80, 25);
        Em_panel.add(sal_label);
        JLabel sal_text = new JLabel();
        sal_text.setBounds(100, 60, 165, 25);
        Em_panel.add(sal_text);
        //Bonus label
        JLabel bon_label = new JLabel("Bonus: ");
        bon_label.setBounds(10, 100, 80, 25);
        Em_panel.add(bon_label);
        JLabel bon_text = new JLabel();
        bon_text.setBounds(100, 100, 165, 25);
        Em_panel.add(bon_text);
        //total
        JLabel tot_label = new JLabel("Total Salary: ");
        tot_label.setBounds(10, 140, 80, 25);
        Em_panel.add(tot_label);
        JLabel tot_text = new JLabel();
        tot_text.setBounds(100, 140, 165, 25);
        Em_panel.add(tot_text);
        //button ok
        ok_btn = new JButton("OK");
        ok_btn.setBounds(115, 210, 80, 30);
        Em_panel.add(ok_btn);
        Em_frame.setVisible(true);
    }
}

