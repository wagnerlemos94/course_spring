package com.lemos.cursomc.resources.excption;

import java.io.Serializable;

public class FieldMessage implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String fieldName;
	private String messege;
	
	public FieldMessage() {
		
	}

	public FieldMessage(String fieldName, String messege) {
		super();
		this.fieldName = fieldName;
		this.messege = messege;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getMessege() {
		return messege;
	}

	public void setMessege(String messege) {
		this.messege = messege;
	}

}
