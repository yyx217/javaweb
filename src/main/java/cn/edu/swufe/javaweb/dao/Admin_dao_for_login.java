package cn.edu.swufe.javaweb.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.swufe.javaweb.entity.Admin_for_login;
import cn.edu.swufe.javaweb.utils.DbUtils;

public class Admin_dao_for_login {
	private QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
	public Admin_for_login findAdminByAd_id(Integer username) {
		try {
			String sql = "select ad_password from administrator where ad_id = ?";
			return runner.query(sql, new BeanHandler<>(Admin_for_login.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
