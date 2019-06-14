package com.hjl.dao.impl;

import com.hjl.dao.ClientDAO;
import com.hjl.entity.Client;
import com.hjl.utils.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDAOImpl implements ClientDAO {
    @Override
    public List<Client> selectAll() throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "select * from t_client";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Client> clientList = new ArrayList<>();
        while (rs.next()) {
            Client client = new Client();
            client.setId(rs.getInt("id"));
            client.setClientName(rs.getString("client_name"));
            client.setOrder(rs.getString("client_order"));
            clientList.add(client);
        }
        rs.close();
        pstmt.close();
        jdbcUtil.closeConnection();
        return clientList;
    }

    @Override
    public int insertClient(Client client) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "INSERT INTO t_client(client_name,client_order)VALUE (?,?)";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, client.getClientName());
        pstmt.setString(2, client.getOrder());
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }

    @Override
    public int deleteClient(int id) throws SQLException {
        JDBCUtil jdbcUtil = JDBCUtil.getInitJDBCUtil();
        Connection connection = jdbcUtil.getConnection();
        String sql = "DELETE from t_client where id = " + id;
        PreparedStatement pstmt = connection.prepareStatement(sql);
        int n = pstmt.executeUpdate();
        pstmt.close();
        connection.close();
        return n;
    }
}
