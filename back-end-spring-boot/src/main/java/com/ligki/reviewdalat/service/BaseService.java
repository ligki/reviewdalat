package com.ligki.reviewdalat.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    @Autowired
    DozerBeanMapper dozerBeanMapper;
}
