package com.dcits.odps.service;

import java.util.List;

import com.dcits.odps.entity.Odps;
/**
 * 
 * @author liucyo
 *
 */
public interface OdpsService {
	
	/**
	 * 查询具体内容
	 * @param pid
	 * @return
	 */
    public List<Odps> findOdpsContent(String pid,String lotno);
    
    /**
     * 获取树
     * @param pid
     * @return
     */
    public List<Odps> getOdpsTree(String pid,String lotno);
    
    /**
     * 获取最大批次号
     * @return
     */
    public int getOdpsLotno();
    
    /**
     * 插入数据
     * @param odps
     * @return
     */
    public int insertOdps(Odps odps);

    /**
     * 查找最新的100个批次
     * @return
     */
    public List<Odps> findTopLotno();
}
