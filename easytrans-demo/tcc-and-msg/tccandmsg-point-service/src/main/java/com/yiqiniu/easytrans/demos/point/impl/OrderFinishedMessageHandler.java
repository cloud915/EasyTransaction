package com.yiqiniu.easytrans.demos.point.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.yiqiniu.easytrans.demos.order.api.vo.OrderFinishedMessage;
import com.yiqiniu.easytrans.protocol.EasyTransRequest;
import com.yiqiniu.easytrans.protocol.msg.ReliableMessageHandler;
import com.yiqiniu.easytrans.queue.consumer.EasyTransConsumeAction;

@Component
public class OrderFinishedMessageHandler implements ReliableMessageHandler<OrderFinishedMessage>{

	
	@Resource
	private PointService pointService;


	@Override
	public int getIdempotentType() {
		return IDENPOTENT_TYPE_FRAMEWORK;
	}

	@Override
	public EasyTransConsumeAction consume(EasyTransRequest<?, ?> request) {
		//TODO: G  猜测：事务消息流程，下面是pre阶段后，本地操作
		pointService.addPointForBuying((OrderFinishedMessage) request);
		//TODO: G  猜测：完成本地操作后，进入commit阶段，告知框架（cancel/ReconsumeLater应该由异常处理执行）
		return EasyTransConsumeAction.CommitMessage;
	}
}
