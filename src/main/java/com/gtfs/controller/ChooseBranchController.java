package com.gtfs.controller;

import java.io.Serializable;
import java.security.Principal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gtfs.bean.BranchMst;
import com.gtfs.bean.UserLoginDtls;
import com.gtfs.bean.UserMst;
import com.gtfs.service.interfaces.BranchMstService;
import com.gtfs.service.interfaces.UserLoginDtlsService;
import com.gtfs.service.interfaces.UserMstService;

@Controller
public class ChooseBranchController implements Serializable{
	@Autowired
	private BranchMstService branchMstService; 
	@Autowired
	private UserMstService userMstService;
	@Autowired
	private UserLoginDtlsService userLoginDtlsService;
	
	@RequestMapping("/chooseBranch")
	public String onLoad(Model model){
		List<BranchMst> branchMsts = branchMstService.findAll();
		model.addAttribute("branches", branchMsts);
		return "chooseBranch";
	}
	
	@RequestMapping(value="/chooseBranch",method=RequestMethod.POST)
	public String goToWelcomePage(@RequestParam("branchId") Long branchId,HttpServletRequest request,Principal principal){
		
		UserMst user = userMstService.findById(Long.parseLong(principal.getName()));
		
		if(user.getBranchMst().getBranchId().equals(branchId)){
			
			 UserLoginDtls userLoginDtls = new UserLoginDtls();
             userLoginDtls.setUserid(user.getUserid());
             userLoginDtls.setBranchId(user.getBranchMst().getBranchId());
             userLoginDtls.setLoginTime(new Date());

             Long id = userLoginDtlsService.insert(userLoginDtls);
			
             if (id != null && id > 0l) {
            	 request.getSession().setAttribute("user", user);
            	 return "dashBoard";
             } else {
            	 return "redirect:logout";
             }
			
			
		}else{
			return "redirect:logout";
		}
	}
	
}
