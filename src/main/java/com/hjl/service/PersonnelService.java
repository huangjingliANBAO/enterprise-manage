package com.hjl.service;

import com.hjl.utils.ResultEntity;


public interface PersonnelService {
    ResultEntity personnelLogin(String account, String password);
}
