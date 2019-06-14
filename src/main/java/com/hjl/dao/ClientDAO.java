package com.hjl.dao;

import com.hjl.entity.Client;

import java.sql.SQLException;
import java.util.List;

public interface ClientDAO {
    /**
     * 查询所有客户
     * @return list
     * @throws SQLException
     */
    List<Client> selectAll()throws SQLException;

    /**
     * 新增客户
     * @param client
     * @return  int
     * @throws SQLException
     */
    int insertClient(Client client)throws SQLException;

    /**
     * 根据id删除客户
     * @param id
     * @return
     * @throws SQLException
     */
    int deleteClient(int id)throws SQLException;
}
