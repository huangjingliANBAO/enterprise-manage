package com.hjl.frame;

import com.eltima.components.ui.DatePicker;
import com.hjl.entity.Staff;
import com.hjl.factory.ServiceFactory;
import com.hjl.utils.AliOSSUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Date;
import java.util.Locale;

public class AddStaff extends JFrame {
    private JTextField idField;
    private JTextField departmentField;
    private JTextField workField;
    private JButton 新增Button;
    private JLabel avatarLabel;
    private JLabel closeLabel;
    private JPanel timePanel;
    private JPanel rootPanel;
    private AdminFrame mainFrame;
    private File file;

    public AddStaff(AdminFrame mainFrame){
        this.mainFrame = mainFrame;
        setUndecorated(true);
        setContentPane(rootPanel);
        setSize(400,300);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       closeLabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               AddStaff.this.dispose();
           }
       });
       avatarLabel.addMouseListener(new MouseAdapter() {
           @Override
           public void mouseClicked(MouseEvent e) {
               JFileChooser fileChooser = new JFileChooser();
               fileChooser.setCurrentDirectory(new File("E:/"));
               int result = fileChooser.showOpenDialog(rootPanel);
               if (result == JFileChooser.APPROVE_OPTION){
                   file = fileChooser.getSelectedFile();
                   ImageIcon icon = new ImageIcon(file.getAbsolutePath());
                   icon.setImage(icon.getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
                   avatarLabel.setText("");
                   avatarLabel.setIcon(icon);
               }
           }
       });
        DatePicker datepick = getDatePicker();
        timePanel.add(datepick);
        timePanel.revalidate();

        新增Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Staff staff = new Staff();
                staff.setStaffId(idField.getText());
                staff.setDepartmentId(departmentField.getText());
                staff.setStaffWork(workField.getText());
                staff.setStaffAvatar(AliOSSUtil.ossUpload(file));
                staff.setStaffDate((Date) getDatePicker().getValue());
                int n = ServiceFactory.getStaffInstance().insertStaff(staff);
                if (n == 1){
                    JOptionPane.showMessageDialog(rootPanel,"新增成功");
                    AddStaff.this.dispose();
                }
            }
        });
    }
    private static DatePicker getDatePicker() {
        final DatePicker datepick;
        // 格式
        String DefaultFormat = "yyyy-MM-dd";
        // 当前时间
        Date date = new Date();
        // 字体
        Font font = new Font("Times News Roman", Font.PLAIN, 18);
        Dimension dimension = new Dimension(200, 30);
        int[] hilightDays = {1, 3, 5, 7};
        int[] disabledDays = {4, 6, 5, 9};
        //构造方法（初始时间，时间显示格式，字体，控件大小）
        datepick = new DatePicker(date, DefaultFormat, font, dimension);
//        datepick.setLocation(137, 83);//设置起始位置
        /*
        //也可用setBounds()直接设置大小与位置
        datepick.setBounds(137, 83, 177, 24);
        */
        // 设置一个月份中需要高亮显示的日子
        datepick.setHightlightdays(hilightDays, Color.red);
        // 设置一个月份中不需要的日子，呈灰色显示
        datepick.setDisableddays(disabledDays);
        // 设置国家
        datepick.setLocale(Locale.CHINA);
        // 设置时钟面板可见
//        datepick.setTimePanleVisible(true);
        return datepick;
    }
}

