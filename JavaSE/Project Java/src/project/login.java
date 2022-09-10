package project;

import project.EMployee;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.*;
public class login extends JFrame implements ActionListener {
    JButton button;
    JRadioButton Emp;
    JRadioButton admin;
    JTextField text_id;
    JTextField text_pass;
    JTextField Text;
    public login(){
        JPanel panel=new JPanel();
        JFrame frame=new JFrame("Login");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(320, 230);
        frame.setLocation(400,200);
        frame.add(panel);
        panel.setLayout(null);
        //////////////////////////////////////////////////////////////////////
        //frame.setLayout(null);
        JLabel label=new JLabel("User_Id");
        label.setBounds(10, 20, 80, 25);
        panel.add(label);
        text_id = new JTextField(14);//user enter his name
        text_id.setBounds(100, 20, 165, 25);
        panel.add(text_id);
        //Entering password
        JLabel pass_label = new JLabel("Password");
        pass_label.setBounds(10, 80, 80, 25);
        panel.add(pass_label);
        text_pass = new JPasswordField(14);
        text_pass.setBounds(100, 80, 165, 25);
        panel.add(text_pass);
                 /* JTextField Text=new JTextField();
        Text.setBounds(115, 140, 80, 25);
        panel.add(Text);


        //radiobutton of choosing employee or admin
        JRadioButton Emp = new JRadioButton("Employee"); //1
       // Emp.addActionListener(this);
        JRadioButton admin = new JRadioButton("Admin");//2
      //  admin.addActionListener(this);
        //for choose one radio button
        ButtonGroup group = new ButtonGroup();
        group.add(Emp);
        group.add(admin);
        Emp.setBounds(115, 140, 80, 25);
        //Emp.setBounds(10,160,80,25);
        panel.add(Emp);


        Emp.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem() == Emp) {
                    Employee emp = new Employee();
                }
            }
        });
        admin.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem() == admin) {
                    whichFun w = new whichFun();
                }
            }
        });


        if (Emp.isSelected())
        {
            Employee emp=new Employee();
        }
        else if (admin.isSelected()){
            whichFun w = new whichFun();
        }
        else {
            JOptionPane.showMessageDialog(null,"Enter valid position");
        }


       /////////////////// admin.setBounds(115, 160, 80, 25);
        //admin.setBounds(225,160,80,25);
       ////////////////// panel.add(admin);
        //Button of login and send info
        */
        button = new JButton("Login");
        button.setBounds(115, 150, 80, 30);
        button.addActionListener(this);
        panel.add(button);
        frame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==button) {
            try {
                Connection c = DriverManager.getConnection("jdbc:mysql://localhost/javamysql");
                PreparedStatement ps=c.prepareStatement("select * from Admin ");
                ResultSet r=ps.executeQuery();

                while (r.next())
                {
                    if(r.getString("ID").equalsIgnoreCase(text_id.getText())) {
                        if (r.getString("Password").equalsIgnoreCase(text_pass.getText())) {
                            if (r.getString("Position").equalsIgnoreCase("employee")) {
                                // if (r.getString("Position").equalsIgnoreCase(Text.getText())) {
                                EMployee emp=new EMployee();
                                // JOptionPane.showMessageDialog(null, "user is sign in ");
                                this.dispose();
                                break;
                            } else if (r.getString("Position").equalsIgnoreCase("admin"))
                            {
                                whichFun w = new whichFun();
                                // JOptionPane.showMessageDialog(null, "pass is not valid");
                                break;
                            }
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "pass is not valid");
                            break;
                        }
                    }
                    else {
                        this.dispose();
                        // JOptionPane.showMessageDialog(null, "user is not Exit ");
                    }
                }
            } catch (SQLException ee) {
                System.out.println(ee.getMessage());
            }
        }
    }
}




