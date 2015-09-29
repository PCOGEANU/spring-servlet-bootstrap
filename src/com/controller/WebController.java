package com.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerMapping;
import org.webjars.WebJarAssetLocator;


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
   
   @ResponseBody
   @RequestMapping("/webjarslocator/{webjar}/**")
	public ResponseEntity locateWebjarAsset(@PathVariable String webjar, HttpServletRequest request) {
		try {
   	   WebJarAssetLocator assetLocator = new WebJarAssetLocator();
      	String mvcPrefix = "/webjarslocator/" + webjar + "/"; // This prefix must match the mapping path!
      	String mvcPath = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
          String fullPath = assetLocator.getFullPath(webjar, mvcPath.substring(mvcPrefix.length()));
          return new ResponseEntity(new ClassPathResource(fullPath), HttpStatus.OK);
      } catch (Exception e) {
          return new ResponseEntity<>(HttpStatus.NOT_FOUND);
      }
  }
  
}
