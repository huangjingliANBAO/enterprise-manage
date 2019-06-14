package com.hjl.frame;

import com.hjl.entity.Department;
import com.hjl.factory.ServiceFactory;
import com.hjl.ui.ImgPanel;
import com.hjl.utils.AliOSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;

public class AddDepartment extends JFrame {
    private ImgPanel rootPanel;
    private JTextField departmentFiele;
    private JButton 新增部门Button;
    private JLabel logoLabel;
    private JLabel closeLabel;
    private File file;
    private MainFrame mainFrame;

    public AddDepartment(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        setUndecorated(true);
        setSize(400,400);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //绘制背景图
        setContentPane(rootPanel);
        rootPanel.setFileName("add-department.jpg");
        rootPanel.repaint();
        closeLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                AddDepartment.this.dispose();
            }
        });
        logoLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("E:/"));
                int result = fileChooser.showOpenDialog(rootPanel);
                if (result == JFileChooser.APPROVE_OPTION){
                    file = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                    icon.setImage(icon.getImage().getScaledInstance(165,165, Image.SCALE_DEFAULT));
                    logoLabel.setText("");
                    logoLabel.setIcon(icon);
                }
            }
        });
        新增部门Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Department department = new Department();
                department.setLogo(AliOSSUtil.ossUpload(file));
                department.setDepartmentName(departmentFiele.getText());
                int n = ServiceFactory.getDepartmentInstance().insertDepartment(department);
                if (n == 1){
                    JOptionPane.showMessageDialog(rootPanel,"新增成功");
                    AddDepartment.this.dispose();
                }
            }
        });
    }
}
