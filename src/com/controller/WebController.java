package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class WebController {
   @RequestMapping(value = "/hello", method = RequestMethod.GET)
   public String index() {
	   return "hello";
   }
   
   @RequestMapping(value = "/staticPage", method = RequestMethod.GET)
   public String redirect() {
     
      return "redirect:/pages/final.htm";
   }
}
