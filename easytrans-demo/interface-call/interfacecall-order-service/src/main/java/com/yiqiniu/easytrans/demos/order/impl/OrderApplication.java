package com.yiqiniu.easytrans.demos.order.impl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.yiqiniu.easytrans.EnableEasyTransaction;
import com.yiqiniu.easytrans.demos.wallet.api.WalletPayMoneyService;
import com.yiqiniu.easytrans.demos.wallet.api.requestcfg.WalletPayRequestCfg;
import com.yiqiniu.easytrans.util.CallWrapUtil;

@SpringBootApplication
@EnableEasyTransaction
@EnableTransactionManagement
public class OrderApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrderApplication.class, args);
	}
	
	/**
	 * create WalletPayMoneyService instance, you can inject the instance to call wallet tcc service
	 */
	@Bean
	public WalletPayMoneyService payService(CallWrapUtil util) {
		// TODO: G 注入 远程服务接口及实现，WalletPayMoneyService为服务接口、WalletPayRequestCfg配置了具体实现
		return util.createTransactionCallInstance(WalletPayMoneyService.class, WalletPayRequestCfg.class);
	}
	
}
