package com.dcits.odps.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dcits.odps.entity.Odps;
import com.dcits.odps.service.OdpsService;
/**
 * @author liucyo
 */
@RestController  
@RequestMapping("/odps")  
public class OdpsController {  
	@Autowired
	private OdpsService odpsService;
	
	/**
	 * 获取具体的内容
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getOdpsContent")
    public List<Odps> getOdpsContent(String pid,String lotno) {
		List<Odps> odps = odpsService.findOdpsContent(pid,lotno);
        System.out.println(odps.toString());
        return odps;
    }
	
	/**
	 * 获取树
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getOdpsTree")
    public List<Odps> getOdpsTree(String pid,String lotno) {
		List<Odps> tree = odpsService.getOdpsTree(pid,lotno);
        System.out.println(tree.toString());
        return tree;
    }
	
	/**
	 * 获取批次号
	 * @param pid
	 * @return
	 */
	@RequestMapping("/getOdpsLotno")
    public int getOdpsLotno(String pid) {
		int lotno = odpsService.getOdpsLotno();
        System.out.println(lotno);
        return lotno;
    }
	
	/**
	 * 插入数据
	 * @param odps
	 * @return
	 */
	@RequestMapping("/insertOdps")
    public int insertOdps(Odps odps) {

		int rows = odpsService.insertOdps(odps);
        System.out.println(rows);
        return rows;
    }

	/**
	 * 获得最新的100个批次备份
	 * @return
	 */
	@RequestMapping("/getTopLotno")
	public List<Odps> getTopLotno(){
		List<Odps> odps = odpsService.findTopLotno();
		System.out.println(odps.toString());
		return odps;
	}
	
}  
