package com.github.dy.zero.service;

import com.github.dy.zero.dao.InfoMapper;
import com.github.dy.zero.domain.Info;
import com.github.dy.zero.utils.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoService {
    private static final Logger LOG = LoggerFactory.getLogger(InfoService.class);

    @Autowired
    private InfoMapper infoMapper;

    public void insertInfo(Long uid, Long tid) throws ServiceException {
        Info info = new Info();
        info.setUid(uid);
        info.setTid(tid);

        try {
            infoMapper.insertInfo(info);
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw new ServiceException(e);
        }
    }

    public List<Info> selectInfos(Long uid) throws ServiceException {
        try {
            return infoMapper.selectInfos(uid);
        } catch (Exception e) {
            LOG.error(e.toString(), e);
            throw new ServiceException(e);
        }
    }
}
