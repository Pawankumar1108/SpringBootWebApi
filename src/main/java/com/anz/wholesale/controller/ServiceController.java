package com.anz.wholesale.controller;

import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import org.springframework.web.bind.annotation.RestController;
import com.anz.wholesale.model.AccontTransactionModel;
import com.anz.wholesale.model.AccountDetailsModel;
import com.anz.wholesale.model.LoginModel;
import com.anz.wholesale.service.LoginService;
import com.anz.wholesale.service.WholesaleService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class ServiceController {

	private static final Logger LOGGER = LogManager.getLogger(ServiceController.class);
	@Autowired
	WholesaleService wholesaleService;

	@Autowired
	LoginService loginService;

	@GetMapping(path = "/accountdetails", produces = "application/json")
	public ResponseEntity<Set<AccountDetailsModel>> getAllAccounts() throws Exception {

		Set<AccountDetailsModel> listOfAccountDetails = wholesaleService.getAccountsList();

		return (new ResponseEntity<Set<AccountDetailsModel>>(listOfAccountDetails, new HttpHeaders(), HttpStatus.OK));
	}

	@GetMapping(path = "/transactionOnAccounts/{accountNumber}", produces = "application/json")
	public ResponseEntity<List<AccontTransactionModel>> getTransactionByAccounts(
			@PathVariable("accountNumber") String accountNumber) throws Exception {

		List<AccontTransactionModel> lisOfTransaction = wholesaleService
				.getTransactionByAccount(Long.parseLong(accountNumber));

		return (new ResponseEntity<List<AccontTransactionModel>>(lisOfTransaction, new HttpHeaders(), HttpStatus.OK));
	}

	@PostMapping(path = "/login")
	public ResponseEntity<List<AccontTransactionModel>> login(@PathVariable("loginJson") String loginJson)
			throws Exception {

		List<AccontTransactionModel> lisOfTransaction = wholesaleService
				.getTransactionByAccount(Long.parseLong(loginJson));

		return (new ResponseEntity<List<AccontTransactionModel>>(lisOfTransaction, new HttpHeaders(), HttpStatus.OK));
	}

	// User LoginPage

	@GetMapping("/loginpage")
	public boolean userLoginPage(@RequestHeader("user-name") String userName) throws Exception {

		LOGGER.info("Login method started executing");

		return loginService.isUserIdExist(userName);
	}

	@GetMapping("/allUser")
	public List<LoginModel> allUser() throws Exception {

		LOGGER.info("All User From Sql Database excuting");

		return loginService.getAllUser();

	}


	@GetMapping(path = "/password")
	public boolean userPassword(@RequestHeader("userPswd") String userPassword) throws Exception {

		LOGGER.info("The User Password is Excuting ");

		return loginService.isUserPasswordExist(userPassword);
	}

	@PutMapping("/resetpassword")
	public boolean userPasswordReset(@RequestBody String jsonRequest) throws Exception {

		LOGGER.info("Reset Password Excuting");
		ObjectMapper objectMapper = new ObjectMapper();
		LoginModel loginModel = objectMapper.readValue(jsonRequest, LoginModel.class);
		

		return loginService.getUserPasswordUpdate(loginModel.getUserPassword(), loginModel.getUserId());

	}

	@PostMapping("/newUser")
	public boolean newUser(@RequestBody String jsonReuest) throws Exception {

		LOGGER.info("Creating New User into the Database Executing");
		ObjectMapper objectMapper = new ObjectMapper();
		LoginModel loginModel = objectMapper.readValue(jsonReuest, LoginModel.class);
		return loginService.createNewUser(loginModel.getUserId(), loginModel.getUserPassword(),
				loginModel.getUserName());

	}
	
	/*
	 * @PostMapping("/userpin") public boolean userPinCreator(@RequestBody String
	 * jsonRequest)throws Exception{
	 * LOGGER.info("The New User Creating with Pin Feature "); ObjectMapper
	 * objectMapper = new ObjectMapper(); LoginModel loginModel =
	 * objectMapper.readValue(jsonRequest, LoginModel.class); return
	 * loginService.getUserWithPin(loginModel.getUserId(),
	 * loginModel.getUserPassword(),loginModel.getUserpin(),
	 * loginModel.getUserName());
	 * 
	 * }
	 */
	

}
