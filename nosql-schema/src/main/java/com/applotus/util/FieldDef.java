package com.applotus.util;

public class FieldDef {
	private String name;
	private DataType type;
	private String value;

	public FieldDef(String name, DataType type, String value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DataType getType() {
		return type;
	}

	public void setType(DataType type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public static enum DataType {
		STRING, INTEGER, LONG, DOUBLE, OBJECT;
	}
}
