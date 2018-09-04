package cn.edu.swufe.javaweb.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import cn.edu.swufe.javaweb.entity.Qy_notice;
import cn.edu.swufe.javaweb.utils.DbUtils;

public class Qy_notice_dao {
	private QueryRunner runner = new QueryRunner(DbUtils.getDataSource());
	public List<Qy_notice> findAll() {
		try {
			String sql = "select * from companynotice";
			return runner.query(sql,new BeanListHandler<>(Qy_notice.class));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
