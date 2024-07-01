package com.example.demo.controller;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.demo.constant.UrlConst;
import com.example.demo.form.LoginForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * control is works like api when gettting get,post request
 */


@Controller
@RequiredArgsConstructor
public class LoginController {
//	private final ___LoginService service;
//	
//	private final PasswordEncoder passwordEncoder;
//	
//	private final MessageSource messageSource;
	
	private final HttpSession session;

	@GetMapping(UrlConst.LOGIN)
	public String view(Model model, LoginForm form) {
		return "login";
	}
	
	
//	login shippaishita toki ni hyouji suru login page
	
	@GetMapping(value = UrlConst.LOGIN,params = "error")
	public String viewWithError(Model model,LoginForm form){
		var errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg",errorInfo.getMessage());
		return "login";
		
	}
	
	
//	@PostMapping(UrlConst.LOGIN)
//	public String login(Model model, LoginForm form) {
//		var userInfo = service.searchUserById(form.getLoginId());
//		System.out.println(userInfo);
//		var encordedPassword = passwordEncoder.encode(form.getPassword());
//		System.out.println(encordedPassword);
//		var isCorrectUserAuth = userInfo.isPresent()
//				&& passwordEncoder.matches(form.getPassword(),userInfo.get().getPassword());
////				&& form.getPassword().equals(userInfo.get().getPassword());
//		if(isCorrectUserAuth) {
//			return "redirect:/menu";
//		}else {
//			var errorMsg = AppUtil.getMessage(messageSource, MessageConst.LOGIN_WRONG_INPUT);
//			model.addAttribute("errorMsg",errorMsg);
//			return "login";
//		}
//	}
}
