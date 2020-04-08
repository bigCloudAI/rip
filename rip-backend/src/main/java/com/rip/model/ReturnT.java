package com.rip.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class ReturnT<T> implements Serializable {
	public static final long serialVersionUID = 42L;

	public static final int SUCCESS_CODE = 200;
	public static final int FAIL_CODE = 500;

	public static final ReturnT<String> SUCCESS = new ReturnT<String>(null);
	public static final ReturnT<String> FAIL = new ReturnT<String>(FAIL_CODE, null);

	private int code;
	private String msg;
	private T content;
	
	public ReturnT(){}
	public ReturnT(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public ReturnT(T content) {
		this.code = SUCCESS_CODE;
		this.content = content;
	}
	
	public static ReturnT<Object> ok() {
		ReturnT<Object> r = new ReturnT<Object>();
		r.setCode(ReturnT.SUCCESS_CODE);
		r.setContent("ok");
		r.setMsg("ok");
		return r;
	}
	
	public static ReturnT<Object> ok(String msg) {
		ReturnT<Object> r = new ReturnT<Object>();
		r.setCode(ReturnT.SUCCESS_CODE);
		r.setContent(msg);
		r.setMsg(msg);
		return r;
	}
	
	public static ReturnT<Object> ok(Object data) {
		ReturnT<Object> r = new ReturnT<Object>();
		r.setCode(ReturnT.SUCCESS_CODE);
		r.setContent(data);
		r.setMsg("ok");
		return r;
	}
	
	public static ReturnT<Object> error(String msg) {
		return error(ReturnT.FAIL_CODE, msg);
	}
	
	public static ReturnT<Object> error(int code, String msg) {
		ReturnT<Object> r = new ReturnT<Object>();
		r.setCode(code);
		r.setContent(msg);
		r.setMsg(msg);;
		return r;
	}

	public ReturnT<T> error500(String message) {
		this.setCode(ReturnT.FAIL_CODE);
		return this;
	}


}
