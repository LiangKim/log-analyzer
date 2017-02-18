package com.zjipst.dev.model;

/**
 * 服务器视图
 * 
 * @author kim
 */
public class AppServer {
	// 服务器类型，如应用服务器、接口服务器、联动服务器
	private String app;
	private String ip;
	private int port;
	// ssh用户名
	private String sshUsername;
	// ssh密码
	private String sshPassword;
	// 项目硬盘路径
	private String sotrePath;

	public String getApp() {
		return app;
	}

	public void setApp(String app) {
		this.app = app;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public String getSshUsername() {
		return sshUsername;
	}

	public void setSshUsername(String sshUsername) {
		this.sshUsername = sshUsername;
	}

	public String getSshPassword() {
		return sshPassword;
	}

	public void setSshPassword(String sshPassword) {
		this.sshPassword = sshPassword;
	}

	public String getSotrePath() {
		return sotrePath;
	}

	public void setSotrePath(String sotrePath) {
		this.sotrePath = sotrePath;
	}
}
