package com.zjipst.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.zjipst.dev.model.AppServer;

/**
 * 应用服务器相关服务类
 * @author kim
 */
@Service
public class AppService {

	/**
	 * 编写一个json db
	 * @return
	 */
	public List<AppServer> listServer(){
		List<AppServer> serverList = new ArrayList<>();
		return serverList;
	}
}
