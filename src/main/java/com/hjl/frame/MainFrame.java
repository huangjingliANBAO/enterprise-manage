package com.hjl.frame;

import com.hjl.entity.Department;
import com.hjl.factory.ServiceFactory;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class MainFrame extends JFrame {
    private JPanel rootPanel;
    private JButton 部门管理Button;
    private JButton 员工管理Button;
    private JButton button4;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JPanel staffPanel;
    private JPanel departmentPanel;
    private JPanel contenPanel;
    private JPanel topPanel;
    private JButton 新增部门Button;

    public MainFrame() {
        setContentPane(rootPanel);
        setTitle("人事企业信息管理系统");
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = (CardLayout) centerPanel.getLayout();


        部门管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card1");
                showDepartment();
            }
        });
        员工管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card2");
            }
        });

        新增部门Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             new AddDepartment(MainFrame.this);
            }
        });
    }
    //部门
    private void showDepartment() {
        contenPanel.removeAll();
        List<Department> departmentList = ServiceFactory.getDepartmentInstance().selectAll();
        GridLayout gridLayout = new GridLayout(0, 3, 30, 30);
        contenPanel.setLayout(gridLayout);
        for (Department department : departmentList) {
            JPanel dpPanel = new JPanel();
            dpPanel.setPreferredSize(new Dimension(600, 400));
            dpPanel.setBorder(BorderFactory.createTitledBorder(department.getDepartmentName()));
            JLabel logoLabel = new JLabel("<html><img src='" + department.getLogo() + "'width=300 height=300 /></html>");
            dpPanel.add(logoLabel);
            contenPanel.add(dpPanel);
            //删除功能
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item = new JMenuItem("删除");
            jPopupMenu.add(item);
            logoLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 3) {
                        jPopupMenu.show(dpPanel, e.getX(), e.getY());
                        item.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int choice = JOptionPane.showConfirmDialog(dpPanel, "您是否要删除？");
                                if (choice == 0) {
                                    contenPanel.remove(dpPanel);
                                    contenPanel.repaint();
                                    ServiceFactory.getDepartmentInstance().deleteDepartment(department.getId());
                                }
                            }
                        });
                    }
                }
            });
            contenPanel.revalidate();
        }
    }

    public static void main(String[] args) throws Exception {
        new MainFrame();
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
    }
}
