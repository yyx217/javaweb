package cn.edu.swufe.javaweb.dto;

import java.util.HashMap;
import java.util.Map;

import cn.edu.swufe.javaweb.entity.Qy_notice;

public class notice {
	private Map<Qy_notice,Integer> notices = new HashMap<>();
	
	public int remove(Qy_notice notice) {
		int num = notices.remove(notice);
		return num;
	}
	
	public int updata()
}
