package com.hjl.service;

import com.hjl.utils.ResultEntity;

public interface AdminService {
    ResultEntity adminLogin(String account, String password);
}
