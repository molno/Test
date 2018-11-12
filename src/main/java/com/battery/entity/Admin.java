package com.battery.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author ellen
 * @since 2018-11-01
 */
public class Admin extends Model<Admin> {

    private static final long serialVersionUID = 1L;

	@TableId(value="admin_id", type= IdType.AUTO)
	private Long adminId;
    /**
     * 用户名
     */
	@TableField("admin_name")
	private String adminName;
    /**
     * 密码
     */
	@TableField("admin_password")
	private String adminPassword;
    /**
     * 有效值
     */
	private Integer effective;
    /**
     * 创建时间
     */
	@TableField("gmt_create")
	private Date gmtCreate;
    /**
     * 修改时间
     */
	@TableField("gmt_modified")
	private Date gmtModified;


	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public Integer getEffective() {
		return effective;
	}

	public void setEffective(Integer effective) {
		this.effective = effective;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	@Override
	protected Serializable pkVal() {
		return this.adminId;
	}

	@Override
	public String toString() {
		return "Admin{" +
			", adminId=" + adminId +
			", adminName=" + adminName +
			", adminPassword=" + adminPassword +
			", effective=" + effective +
			", gmtCreate=" + gmtCreate +
			", gmtModified=" + gmtModified +
			"}";
	}
}
