package com.dcits.odps.entity;

import java.io.Serializable;
import java.util.Date;
/**
 * 
 * @author liucyo
 *
 */
public class Odps implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String objid;
	
	private String objpid;
	
	private String type;
	
	//具体的内容
	private String content;
	
	private String name;
	
	//备份时间
	private Date createdate;
	
	//批次号
	private int lotno;

	public String getObjid() {
		return objid;
	}

	public void setObjid(String objid) {
		this.objid = objid;
	}

	public String getObjpid() {
		return objpid;
	}

	public void setObjpid(String objpid) {
		this.objpid = objpid;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public int getLotno() {
		return lotno;
	}

	public void setLotno(int lotno) {
		this.lotno = lotno;
	}
	
	
}
