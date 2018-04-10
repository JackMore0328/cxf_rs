package com.rs.framwork.baseConfig;

import com.alipay.demo.trade.config.Configs;

public class InitConfig {

	private InitConfig() {
		Configs.init("zfb.properties");
	}

}
