package cn.edu.swufe.javaweb.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.swufe.javaweb.entity.Qy_for_login;
import cn.edu.swufe.javaweb.utils.DbUtils;

public class Qy_dao_for_login {
	private QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
	public Qy_for_login findQyByCompany_number(Integer username) {
		try {
			String sql = "select company_password,company_status from companyinfor where company_number = ?";
			return runner.query(sql, new BeanHandler<>(Qy_for_login.class),username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
