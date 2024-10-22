package com.cts.socialapp.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class SocialAppGlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleException(HttpServletRequest request, Exception ex) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("exception", ex);
		mav.addObject("url", request.getRequestURI());
		mav.setViewName("error");
		return mav;
	}

}
