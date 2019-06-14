package com.hjl.dao.impl;

import com.hjl.dao.ClientDAO;
import com.hjl.entity.Client;
import com.hjl.factory.DAOFactory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ClientDAOImplTest {
private ClientDAO clientDAO = DAOFactory.getClientInstance();
    @Test
    public void selectAll() {
        List<Client> clientList = null;
        try {
            clientList = clientDAO.selectAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        clientList.forEach(client -> System.out.println(client));
    }

    @Test
    public void insertClient() {
        Client client = new Client();
        client.setClientName("测试");
        client.setOrder("测试系统");
        try {
            int n = clientDAO.insertClient(client);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void deleteClient() {
        int id = 4;
        try {
            clientDAO.deleteClient(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}