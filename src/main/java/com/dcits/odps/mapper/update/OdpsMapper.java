package com.dcits.odps.mapper.update;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dcits.odps.entity.Odps;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liucyo
 */
@Mapper
public interface OdpsMapper {
    /**
     * 查询具体内容
     * @param pid
     * @return
     */
	public List<Odps> findOdpsContent(@Param("pid") String pid,@Param("lotno")String lotno);
	
	/**
	 * 获取树
	 * @param pid
	 * @return
	 */
	public List<Odps> findOdpsTree(@Param("pid") String pid, @Param("lotno") String lotno);
	
	/**
	 * 获取最大批次号
	 * @return
	 */
	public int findOdpsLotno();
	
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
