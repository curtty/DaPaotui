package com.curtty.dapaotui.data;

public class Contract  extends BaseData{
	//the buying request in which you can find information about part A
	private RequestData request;
	//part B of this contract
	private User userB;
	private float reward;
	private long submitTime;
	private float contractAmmount;
	private String contractUnit;
	//comment of part B
	private String commentB;
	
	
	public RequestData getRequest() {
		return request;
	}
	public void setRequest(RequestData request) {
		this.request = request;
	}
	public User getUserB() {
		return userB;
	}
	public void setUserB(User userB) {
		this.userB = userB;
	}
	public float getReward() {
		return reward;
	}
	public void setReward(float reward) {
		this.reward = reward;
	}
	public long getSubmitTime() {
		return submitTime;
	}
	public void setSubmitTime(long submitTime) {
		this.submitTime = submitTime;
	}
	public float getContractAmmount() {
		return contractAmmount;
	}
	public void setContractAmmount(float contractAmmount) {
		this.contractAmmount = contractAmmount;
	}
	public String getContractUnit() {
		return contractUnit;
	}
	public void setContractUnit(String contractUnit) {
		this.contractUnit = contractUnit;
	}
	public String getCommentB() {
		return commentB;
	}
	public void setCommentB(String commentB) {
		this.commentB = commentB;
	}
}
