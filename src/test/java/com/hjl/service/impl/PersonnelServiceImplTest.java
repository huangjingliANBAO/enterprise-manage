package com.hjl.service.impl;

import com.hjl.factory.ServiceFactory;
import com.hjl.service.PersonnelService;
import com.hjl.utils.ResultEntity;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonnelServiceImplTest {
private PersonnelService personnelService = ServiceFactory.getPersonnelInstance();
    @Test
    public void personnelLogin() {
        ResultEntity resultEntity = personnelService.personnelLogin("22","123");
        System.out.println(resultEntity);
    }
}