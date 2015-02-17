package com.gtfs.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.UserMst;
import com.gtfs.service.interfaces.LicOblApplicationMstService;

@Controller
public class PrintReceiptController implements Serializable{

	@Autowired
	private LicOblApplicationMstService licOblApplicationMstService;
	
	@RequestMapping("/licBranchActivity/printReceipt")
	public String onLoad(){
		return "printReceipt";
	}
	
	@RequestMapping(value="/licBranchActivity/printReceiptSearch",method=RequestMethod.POST)
	public String onSearch(@RequestParam("applicationNo") String applicationNo,@RequestParam("businessDate") String businessDate,HttpServletRequest request,Model model){

		try{
			UserMst useMst = (UserMst) request.getSession().getAttribute("user");
			if(!StringUtils.isEmpty(businessDate)){
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
				 List<LicOblApplicationMst> licOblApplicationMsts = licOblApplicationMstService.findApplicationForSecondaryDataEntryByDate(dateFormat.parse(businessDate), useMst.getBranchMst().getBranchId());

				model.addAttribute("licOblApplicationMsts", licOblApplicationMsts);
			}

			if(!StringUtils.isEmpty(applicationNo)){
				List<LicOblApplicationMst> licOblApplicationMsts = licOblApplicationMstService.findApplicationForSecondaryDataEntryByApplicationNo(applicationNo, useMst.getBranchMst().getBranchId());
				model.addAttribute("licOblApplicationMsts", licOblApplicationMsts);
				
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return "printReceipt";
	}
	
	@RequestMapping(value="/licBranchActivity/provitionalPrintReceipt")
	public String printPage(){
		return "provitionalPrintReceipt";
	}
}
