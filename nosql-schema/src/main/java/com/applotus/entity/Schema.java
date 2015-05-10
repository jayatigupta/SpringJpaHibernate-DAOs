package com.applotus.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.applotus.util.FieldDef;
import com.applotus.util.FieldDef.DataType;

@Entity
@Table(name = "nosql_schema", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"identifier", "field" }) })
public class Schema extends AbstractEntity {

	private static final long serialVersionUID = -938867976060797736L;

	@Column(name = "identifier", nullable = false, length = 100)
	String identifier;

	@Column(name = "field", nullable = false, length = 100)
	String field;

	@Column(name = "datatype", nullable = false, length = 40)
	private DataType dataType;

	@Column(name = "value", nullable = false, length = 500)
	private String value;

	public Schema() {
	}

	public Schema(String id, String key, FieldDef fd) {
		super(id);
		this.identifier = key;
		this.field = fd.getName();
		this.value = fd.getValue();
		this.dataType = fd.getType();
	}
	
	public Schema(String id, String identifier, String field, String type,
			String value) {
		super(id);
		this.identifier = identifier;
		this.field = field;
		this.value = value;
		this.dataType = DataType.valueOf(type);
	}

	public Schema(String id, String identifier, String field, DataType type,
			String val) {
		super(id);
		this.identifier = identifier;
		this.field = field;
		this.value = val;
		this.dataType = type;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public DataType getDataType() {
		return dataType;
	}

	public void setDataType(DataType dataType) {
		this.dataType = dataType;
	}
}
