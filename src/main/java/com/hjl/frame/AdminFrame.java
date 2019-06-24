package com.hjl.frame;

import com.hjl.entity.*;
import com.hjl.factory.ServiceFactory;
import com.hjl.service.NewsService;

import sun.swing.table.DefaultTableCellHeaderRenderer;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

public class AdminFrame extends JFrame {
    private JPanel rootPanel;
    private JButton 部门管理Button;
    private JButton 员工管理Button;
    private JButton 员工薪资管理Button;
    private JPanel leftPanel;
    private JPanel centerPanel;
    private JPanel departmentPanel;
    private JPanel contenPanel;
    private JPanel topPanel;
    private JButton 新增部门Button;
    private JPanel staffPanel;
    private JPanel staffTopPanel;
    private JPanel staffContenPanel;
    private JButton 新增员工Button;
    private JPanel salaryPanel;
    private JPanel tablePanel;
    private JButton 新闻Button;
    private JPanel newPanel;
    private JButton 头条Button;
    private JButton 社会Button;
    private JButton 体育Button;
    private JButton 娱乐Button;
    private JButton 时尚Button;
    private JPanel newTopPanel;
    private JPanel newConterPanel;
    private JButton 国内Button;
    private JButton 国际Button;
    private JButton 军事Button;
    private JButton 科技Button;
    private JButton 财经Button;
    private JPanel toutiaoPanel;
    private JPanel shehuiPanel;
    private JPanel tiyuPanel;
    private JPanel yulePanel;
    private JPanel shishangPanel;
    private JPanel guoneiPanel;
    private JPanel guojiPanel;
    private JPanel junshiPanel;
    private JPanel kejiPanel;
    private JPanel caijingPanel;
    private JButton 切换账号Button;
    private JButton 发布通知Button;
    private JPanel noticePanel;
    private JTextArea textArea;
    private JButton releaseBtn;
    public AdminFrame() {
        setContentPane(rootPanel);
        setTitle("人事企业信息管理系统");
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = (CardLayout) centerPanel.getLayout();
        centerPanel.setLayout(cardLayout);
        CardLayout cardLayout1 = (CardLayout) newConterPanel.getLayout();
        newConterPanel.setLayout(cardLayout1);
        showDepartment();
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
                showStaff();
            }
        });

        新增部门Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddDepartment(AdminFrame.this);
            }
        });
        新增员工Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStaff(AdminFrame.this);
            }
        });
        员工薪资管理Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card3");
                List<SalaryVO> salaryVOList = ServiceFactory.getSalaryInstance().selectAll();
                showSalary(salaryVOList);
            }
        });

        新闻Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card4");
            }
        });
        //默认展示
        cardLayout1.show(newConterPanel, "Card1");
        List<News> newsList = NewsService.getNews("top");
        showData(newsList, toutiaoPanel);
        头条Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card1");
                List<News> newsList = NewsService.getNews("top");
                showData(newsList, toutiaoPanel);
            }
        });
        社会Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card2");
                List<News> newsList = NewsService.getNews("shehui");
                showData(newsList, shehuiPanel);
            }
        });
        体育Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card3");
                List<News> newsList = NewsService.getNews("tiyu");
                showData(newsList, tiyuPanel);
            }
        });
        娱乐Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card4");
                List<News> newsList = NewsService.getNews("yule");
                showData(newsList, yulePanel);
            }
        });
        时尚Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card5");
                List<News> newsList = NewsService.getNews("shishang");
                showData(newsList, shishangPanel);
            }
        });
        国内Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card6");
                List<News> newsList = NewsService.getNews("guonei");
                showData(newsList, guoneiPanel);
            }
        });
        国际Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card7");
                List<News> newsList = NewsService.getNews("guoji");
                showData(newsList, guojiPanel);
            }
        });
        军事Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card8");
                List<News> newsList = NewsService.getNews("junshi");
                showData(newsList, junshiPanel);
            }
        });
        科技Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card9");
                List<News> newsList = NewsService.getNews("keji");
                showData(newsList, kejiPanel);
            }
        });
        财经Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout1.show(newConterPanel, "Card10");
                List<News> newsList = NewsService.getNews("caijing");
                showData(newsList, caijingPanel);
            }
        });
        切换账号Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                AdminFrame.this.dispose();
            }
        });
        发布通知Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(centerPanel, "Card5");
            }
        });
        releaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(noticePanel,"发布成功！");
            }
        });
    }

    private void showData(List<News> newsList, JPanel bigPanel) {
        bigPanel.removeAll();
        GridLayout gridLayout = new GridLayout(0, 3, 50, 50);
        bigPanel.setLayout(gridLayout);
        for (News news : newsList) {
            JPanel jPanel = new JPanel();
            jPanel.setLayout(new BorderLayout());
            jPanel.setBackground(new Color(132, 213, 192));
            JLabel imgLabel = new JLabel();
            JLabel titleLabel = new JLabel(news.getTitle());
            imgLabel.setText("<html><img src='" + news.getThumbnailPicS() + "'width = 250 height = 150/></html>");
            JLabel authorLabel = new JLabel("作者：" + news.getAuthorName());
            JLabel dateLabel = new JLabel(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(news.getDate()));
            Font font = new Font("微软雅黑", Font.BOLD, 20);
            titleLabel.setFont(font);
            dateLabel.setFont(font);
            authorLabel.setFont(font);
            jPanel.add(titleLabel, BorderLayout.NORTH);
            jPanel.add(imgLabel, BorderLayout.CENTER);
            jPanel.add(authorLabel, BorderLayout.EAST);
            jPanel.add(dateLabel, BorderLayout.SOUTH);
            bigPanel.add(jPanel);
            bigPanel.revalidate();
        }
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

    //员工
    private void showStaff() {
        staffContenPanel.removeAll();
        List<StaffVO> staffVOList = ServiceFactory.getStaffInstance().selectAll();
        GridLayout gridLayout = new GridLayout(0, 4, 30, 30);
        staffContenPanel.setLayout(gridLayout);
        for (StaffVO staffVO : staffVOList) {
            JPanel staffPanel1 = new JPanel();
            staffContenPanel.setPreferredSize(new Dimension(400, 400));
            JLabel staffId = new JLabel("工号：" + staffVO.getStaffId());
            JLabel department = new JLabel("部门：" + staffVO.getDepartmentName());
            JLabel work = new JLabel("工作：" + staffVO.getStaffWork());
            JLabel date = new JLabel("入职时间：" + String.valueOf(new Date(staffVO.getStaffDate().getTime())));
            JLabel avatar = new JLabel("<html><img src='" + staffVO.getStaffAvatar() + "'/></html>");
            staffPanel1.add(staffId);
            staffPanel1.add(department);
            staffPanel1.add(work);
            staffPanel1.add(date);
            staffPanel1.add(avatar);
            staffContenPanel.add(staffPanel1);
            //删除
            JPopupMenu jPopupMenu = new JPopupMenu();
            JMenuItem item = new JMenuItem("删除");
            jPopupMenu.add(item);
            avatar.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == 3) {
                        jPopupMenu.show(staffPanel1, e.getX(), e.getY());
                        item.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                int choice = JOptionPane.showConfirmDialog(staffPanel1, "您是否要删除？");
                                if (choice == 0) {
                                    staffContenPanel.remove(staffPanel1);
                                    staffContenPanel.repaint();
                                    ServiceFactory.getStaffInstance().deleteId(staffVO.getId());
                                }
                            }
                        });
                    }
                }
            });
            staffContenPanel.revalidate();
        }
    }
    //员工薪资管理
    private void showSalary(List<SalaryVO> salaryVOS) {
        tablePanel.removeAll();
        //获得所有学生视图数据
        //创建表格
        JTable table = new JTable();
        //表格数据模型
        DefaultTableModel model = new DefaultTableModel();
        table.setModel(model);
        //表头内容
        model.setColumnIdentifiers(new String[]{"工号", "薪资"});
        //遍历List 转成Object数组
        for (SalaryVO salaryVO : salaryVOS) {
            Object[] object = new Object[]{salaryVO.getStaffId(), salaryVO.getStaffSalary()};
            model.addRow(object);
        }
        TableColumn tc = new TableColumn(2);
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
        //表格内容居中
        DefaultTableCellHeaderRenderer r = new DefaultTableCellHeaderRenderer();
        r.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, r);
        //表格加入滚动面板，水平垂直方向带滚动条
        JScrollPane scrollPane = new JScrollPane(table, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        tablePanel.add(scrollPane);
        tablePanel.revalidate();
        //打印按钮
        JButton printBtn = new JButton("打印工资条");
        tablePanel.add(printBtn,BorderLayout.SOUTH);
        printBtn.setBackground(new Color(26, 160, 52));
        printBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                File file = new File("E:/aaaa.xlsx");
                if (!file.exists()){
                    try {
                        exportTable(table,file);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        });
    }
    //打印工资条方法
    private void exportTable(JTable table,File file)throws IOException{
        TableModel model = table.getModel();
        FileWriter out = new FileWriter(file);
        for (int i = 0; i < model.getColumnCount(); i++){
            out.write(model.getColumnName(i) + "\t");
        }
        out.write("\n");
        for (int i = 0; i < model.getRowCount(); i++){
            for (int j = 0; j < model.getColumnCount(); j++){
                out.write(model.getValueAt(i,j).toString() + "\t");
            }
            out.write("\n");
        }
        out.close();
        System.out.println("write out to:" + file);
        JOptionPane.showMessageDialog(tablePanel,"打印成功");
    }
    public static void main(String[] args) throws Exception {
        new AdminFrame();
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
    }
}
