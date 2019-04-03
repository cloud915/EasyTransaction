package com.yiqiniu.easytrans.demos.point.impl;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.yiqiniu.easytrans.demos.order.api.vo.OrderFinishedMessage;

@Component
public class PointService {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	//TODO: G  本地操作事务性保证
	@Transactional
	public void addPointForBuying(OrderFinishedMessage msg){
		int update = jdbcTemplate.update("update `point` set point = point + ? where user_id = ?;", 
				msg.getOrderAmt(),msg.getUserId());
		if(update != 1){
			//TODO: G  抛出异常，由框架执行ReconsumeLater流程
			throw new RuntimeException("can not find specific user id!");
		}
	}
	

}
