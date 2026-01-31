package com.bank.mapper;

import com.bank.dto.AccountDTO;
import com.bank.entity.Account;

public class AccountMapper { 
     public static Account dtoToEntity(AccountDTO accountDTO) {
    	 
    	 Account dto=new Account();
    	 
    	 dto.setAccountNo(accountDTO.getAccountNo());
    	 dto.setAccountType(accountDTO.getAccountType());
    	 dto.setBranch(accountDTO.getBranch());
    	 dto.setName(accountDTO.getName());
    	  
    	 return dto;
     }
     public static AccountDTO entityToDTO(Account account) {
    	 
    	 AccountDTO acc=new AccountDTO();
    	 
    	 acc.setAccountNo(account.getAccountNo());
    	 acc.setAccountType(account.getAccountType());
    	 acc.setBranch(account.getBranch());
    	 acc.setName(account.getName());
    	 
    	 return acc;
     }
}
