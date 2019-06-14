package com.hjl.frame;

import com.hjl.factory.ServiceFactory;
import com.hjl.ui.ImgPanel;
import com.hjl.utils.ResultEntity;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminLoginFrame extends JFrame{
    private ImgPanel rootPanel;
    private JTextField accountField;
    private JPasswordField passwordField;
    private JButton 登录Button;
    private JButton 取消Button;

    public AdminLoginFrame(){
        //设置需要的背景图
        rootPanel.setFileName("login-bg.jpg");
        //组件重绘
        rootPanel.repaint();
        setTitle("管理员登录");
        setContentPane(rootPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,600);
        setLocationRelativeTo(null);
        setVisible(true);
        登录Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            //获得输入的账号和密码，注意密码框组件的使用方法
                String account = accountField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                ResultEntity resultEntity = ServiceFactory.getAdminServiceInstance().adminLogin(account, password);
                JOptionPane.showMessageDialog(rootPanel, resultEntity.getMessage());
                //登录成功，进入主界面，并关闭登录界面
                if (resultEntity.getCode() == 0){
                    new MainFrame();
                    AdminLoginFrame.this.dispose();
                }else if (resultEntity.getCode() == 1){
                    /**
                     * 密码错误
                     * 清空密码框
                     */
                    passwordField.setText("");
                }else{
                    /**
                     * 账号错误（该用户不存在）
                     * 清空账号框 密码框
                     */
                    accountField.setText("");
                    passwordField.setText("");
                }
            }
        });
        取消Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                accountField.setText("");
                passwordField.setText("");
            }
        });
    }
    public static void main(String[] args)throws Exception {
        new AdminLoginFrame();
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
    }
}

