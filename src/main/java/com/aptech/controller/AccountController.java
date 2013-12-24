package com.aptech.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.aptech.model.Account;
import com.aptech.service.AccountService;
import com.aptech.service.EncryptService;

@Controller
@RequestMapping("/account")
@SessionAttributes("user")
public class AccountController {

	@Autowired
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String doLogin(@RequestParam(value = "email") String email,
			@RequestParam(value = "password") String password, Model model,
			HttpSession session) {

		Account account = new Account();
		account.setEmail(email);
		account.setPassword(EncryptService.SHA1(password));

		if (accountService.checkAccountExist(account)) {
			session.setAttribute("user", accountService.findAccount(email));

			String prevUrl = (String) session.getAttribute("prevUrl");

			if (prevUrl == null || prevUrl.equals("")) {
				return "redirect:/home/index";
			}

			return "redirect:" + prevUrl;
		}

		model.addAttribute("error", "Invalid Email / Password");
		return "Account/login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model, HttpSession session) {

		Account account = (Account) session.getAttribute("user");
		if (account != null) {
			return "redirect:/home/index";
		}

		return "Account/login";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public String logout(Model model, HttpSession session) {

		session.removeAttribute("user");

		return "redirect:/account/login";

	}

}
