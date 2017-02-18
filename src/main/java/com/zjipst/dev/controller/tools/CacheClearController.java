package com.zjipst.dev.controller.tools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 应用服务器缓存清理
 * @author kim
 */
@Controller
@RequestMapping(value="/tools/cache-clear")
public class CacheClearController {
	/**
	 * 显示服务器列表
	 * @return
	 */
	@RequestMapping(value="/show")
	public String show(){
		/**
		 * 动态加载全部服务器列表
		 */
		return "tools/clearCache";
	}
}
