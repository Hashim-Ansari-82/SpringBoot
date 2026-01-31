package com.bank.constant;

public enum AccountConstant {
	
	SAVINNG("SAVINNG"),
	CURRENT("CURRENT"),
	
	ACTIVE("ACTIVE"),
	INACTIVE("INACTIVE"),
	
	SUCCESSFULLY_SAVE("ACCOUNT SAVE SUCCESS ");

	public final String value;
	
	private AccountConstant(String string) {
		this.value = "";
	}
	
	public String getValue() {
		return value;
	}

}
