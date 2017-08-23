package com.stackroute.datamunger.query.parser;

//this class is used to store Aggregate Function
public class AggregateFunction {
	
	
	private String field;
	private int result;
	private String function;
	
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public String getFunction() {
		return function;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	
	
	
}
