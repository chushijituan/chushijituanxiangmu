package com.bookmall.bean;

public class Expression {
	private String name;
	private String operator;
	private int value;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Expression [name=" + name + ", operator=" + operator
				+ ", value=" + value + "]";
	}

	public Expression() {
		super();
	}

	public Expression(String name, String operator, int value) {
		super();
		this.name = name;
		this.operator = operator;
		this.value = value;
	}

}
