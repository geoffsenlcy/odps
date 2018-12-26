package com.dcits.odps.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dcits.odps.entity.Odps;
import com.dcits.odps.mapper.query.OdpsQueryMapper;
import com.dcits.odps.service.OdpsService;
/**
 * 
 * @author liucyo
 *
 */
@Service
public class OdpsServiceImpl implements OdpsService{

	@Autowired
    private com.dcits.odps.mapper.query.OdpsQueryMapper odpsQueryMapper;
	@Autowired
    private com.dcits.odps.mapper.update.OdpsMapper odpsUpdateMapper;

    public List<Odps> findOdpsContent(String pid,String lotno){
        return odpsQueryMapper.findOdpsContent(pid,lotno);
    }

	@Override
	public List<Odps> getOdpsTree(String pid,String lotno) {
		return odpsQueryMapper.findOdpsTree(pid,lotno);
	}

	@Override
	public int getOdpsLotno() {
		return odpsUpdateMapper.findOdpsLotno();
	}

	@Override
	public int insertOdps(Odps odps) {
		return odpsUpdateMapper.insertOdps(odps);
	}


	@Override
	public List<Odps> findTopLotno() {
		return odpsQueryMapper.findTopLotno();
	}


}
