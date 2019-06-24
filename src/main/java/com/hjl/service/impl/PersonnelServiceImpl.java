package com.hjl.service.impl;

import com.hjl.dao.PersonnelDAO;
import com.hjl.entity.Personnel;
import com.hjl.factory.DAOFactory;
import com.hjl.service.PersonnelService;
import com.hjl.utils.ResultEntity;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;


public class PersonnelServiceImpl implements PersonnelService {
    private PersonnelDAO personnelDAO = DAOFactory.getPersonnelInstance();
    @Override
    public ResultEntity personnelLogin(String account, String password) {
ResultEntity resultEntity = new ResultEntity();
        Personnel personnel = null;
        try {
            personnel = personnelDAO.getPersonnelByAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //根据账号查找到记录
        if (personnel != null){
            //比较密码，此时需要将客户端传过来的密码进行MD5加密后才能比对
            if (DigestUtils.md5Hex(password).equals(personnel.getPassword())){
                resultEntity.setCode(0);
                resultEntity.setMessage("登录成功");
                resultEntity.setData(personnel);
            }else {
                resultEntity.setCode(1);
                resultEntity.setMessage("密码错误");
            }
        }else {
            resultEntity.setCode(2);
            resultEntity.setMessage("账户不存在");
        }
        return resultEntity;
    }
}
