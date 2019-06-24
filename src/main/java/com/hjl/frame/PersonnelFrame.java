package com.hjl.frame;

import com.hjl.entity.SalaryVO;
import com.hjl.entity.Staff;
import com.hjl.entity.StaffVO;
import com.hjl.factory.ServiceFactory;
import sun.swing.table.DefaultTableCellHeaderRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class PersonnelFrame extends JFrame {
    private JPanel rootPanel;
    private JPanel tablePanel;
    private JPanel acceptPanel;
    private JTextArea textArea;
    private JButton 查看通知Button;

    public PersonnelFrame() {
        setTitle("员工界面");
        setContentPane(rootPanel);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        List<StaffVO> staffVOList = ServiceFactory.getStaffInstance().selectAll();
        showPersonnel(staffVOList);

        查看通知Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             textArea.append("\n全体员工 今晚加班");
            }
        });
    }
    private void showPersonnel(List<StaffVO> staffVOList) {
        tablePanel.removeAll();
        //获得所有学生视图数据
        //创建表格
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"工号", "部门", "工作", "手机号码", "家庭住址", "入职时间"});
        //遍历List 转成Object数组
        for (StaffVO staffVO : staffVOList) {
            Object[] object = new Object[]{staffVO.getStaffId(), staffVO.getDepartmentName(), staffVO.getStaffWork(),
                    staffVO.getStaffPhone(), staffVO.getStaffAddress(), staffVO.getStaffDate()};
            model.addRow(object);
        }
        TableColumn tc = new TableColumn(6);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        //获得表头
        JTableHeader head = table.getTableHeader();
        //表头居中
        DefaultTableCellHeaderRenderer hr = new DefaultTableCellHeaderRenderer();
        hr.setHorizontalAlignment(JLabel.CENTER);
        head.setDefaultRenderer(hr);
        //设置表头大小
        head.setPreferredSize(new Dimension(head.getWidth(), 40));
        //设置表头字体
        head.setFont(new Font("微软雅黑", Font.PLAIN, 22));
        //设置表格行高
        table.setRowHeight(35);
        //表格背景色
        table.setBackground(new Color(246, 154, 181));
        //表格内容居中
        DefaultTableCellHeaderRenderer r = new DefaultTableCellHeaderRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板，水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        tablePanel.revalidate();
    }

    public static void main(String[] args) {
        new PersonnelFrame();
    }
}
