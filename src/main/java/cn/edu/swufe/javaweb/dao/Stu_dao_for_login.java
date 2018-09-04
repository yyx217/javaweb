package cn.edu.swufe.javaweb.dao;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.edu.swufe.javaweb.entity.Stu_for_login;
import cn.edu.swufe.javaweb.utils.DbUtils;

public class Stu_dao_for_login {
	private QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
	public Stu_for_login findStuByStudent_number(Integer username) {
		try {
			String sql = "select student_password from studentinfor where student_number = ?";
			return runner.query(sql, new BeanHandler<>(Stu_for_login.class),username);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
