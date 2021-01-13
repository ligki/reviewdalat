package com.ligki.reviewdalat.service;

import org.dozer.DozerBeanMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BaseService {
    protected static final Logger LOGGER = LoggerFactory.getLogger(BaseService.class);

    @Autowired
    DozerBeanMapper dozerBeanMapper;
}
