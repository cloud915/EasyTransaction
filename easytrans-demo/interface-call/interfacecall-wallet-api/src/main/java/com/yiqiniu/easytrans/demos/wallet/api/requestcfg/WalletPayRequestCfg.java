package com.yiqiniu.easytrans.demos.wallet.api.requestcfg;

import com.yiqiniu.easytrans.demos.wallet.api.WalletPayMoneyService.WalletPayRequestVO;
import com.yiqiniu.easytrans.demos.wallet.api.WalletPayMoneyService.WalletPayResponseVO;
import com.yiqiniu.easytrans.demos.wallet.api.WalletServiceApiConstant;
import com.yiqiniu.easytrans.protocol.BusinessIdentifer;
import com.yiqiniu.easytrans.protocol.tcc.TccMethodRequest;

/**
 * define the calling configuration for WalletPayMoneyService
 */
// TODO: G 注解中定义的busCode 为映射非服务接口方法；实现TccMethodRequest
@BusinessIdentifer(appId=WalletServiceApiConstant.APPID,busCode="pay",rpcTimeOut=2000)
public class WalletPayRequestCfg extends WalletPayRequestVO implements TccMethodRequest<WalletPayResponseVO>{
	// TODO: G WalletPayRequestCfg 在WalletService类中，配置了cfgClass=WalletPayRequestCfg,进行了关联
	// TODO: G 猜测：框架通过注解、配置信息，找到了 WalletPayMoneyService 服务接口的具体实现
	private static final long serialVersionUID = 1L;
}
