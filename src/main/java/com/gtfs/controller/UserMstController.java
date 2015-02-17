package com.gtfs.controller;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gtfs.bean.UserMst;
import com.gtfs.service.interfaces.UserMstService;

@Controller
public class UserMstController implements Serializable{
	@Autowired
	private UserMstService userMstService;

	@RequestMapping("/admin/users")
	public String onLoad(){
		return "users";
	}
	@RequestMapping(value="/admin/searchUser",method=RequestMethod.POST)
	public String searchUser(@RequestParam("userId")Long userId,@RequestParam("username")String username,Model model){
		
		System.out.println("userId "+userId +" username "+username);
		List<UserMst> list = null;
		if(userId != null){
			list = userMstService.findActiveUserInfoByUserId(userId);
		}else if(!StringUtils.isEmpty(username)){
			list = userMstService.findActiveUserInfoByUserName(username);
		}else {
			list = userMstService.findAllActiveUserInfo();
		}
		
		model.addAttribute("users", list);
		return "users";
	}
	
}
