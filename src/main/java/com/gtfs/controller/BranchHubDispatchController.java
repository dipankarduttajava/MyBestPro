package com.gtfs.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gtfs.bean.LicBrnhHubPicMapDtls;
import com.gtfs.bean.LicHubMst;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.UserMst;
import com.gtfs.dto.SearchDto;
import com.gtfs.service.interfaces.LicBranchHubPicMappingService;
import com.gtfs.service.interfaces.LicBrnhHubPicMapDtlsService;
import com.gtfs.service.interfaces.LicHubMstService;
import com.gtfs.service.interfaces.LicOblApplicationMstService;

@Controller
@SessionAttributes({"hubMstList","dispatchHub"})
public class BranchHubDispatchController implements Serializable{
	@Autowired
	private LicBranchHubPicMappingService licBranchHubPicMappingService;
	@Autowired
	private LicHubMstService licHubMstService;
	@Autowired
	private LicOblApplicationMstService licOblApplicationMstService;
	@Autowired
	private LicBrnhHubPicMapDtlsService licBrnhHubPicMapDtlsService;
	
	
	@RequestMapping("/licBranchActivity/branchHubDispatch")
	public String onLoad(HttpServletRequest request,Model model){
		
		UserMst user = (UserMst) request.getSession().getAttribute("user");
		
		List<LicHubMst> hubMstList = new ArrayList<LicHubMst>();
		List<Long> destinationlist = licBranchHubPicMappingService.findHubIdForBranchIdByProcessName(user.getBranchMst().getBranchId(), "OBL");
		System.out.println("dd "+destinationlist);
		for(LicHubMst obj:licHubMstService.findActiveHubMst()){
			if(destinationlist.contains(obj.getId())){
				hubMstList.add(obj);
			}		
		}
		model.addAttribute("hubMstList",hubMstList);
		model.addAttribute("searchDto", new SearchDto());
		return "branchHubDispatch";
	}
	
	@RequestMapping(value="/licBranchActivity/branchHubDispatch",method=RequestMethod.POST)
	public String onSearch(HttpServletRequest request,Model model,@ModelAttribute SearchDto searchDto){
		
		try{
			UserMst user = (UserMst) request.getSession().getAttribute("user");
			List<LicOblApplicationMst> licOblApplicationMstList = licOblApplicationMstService.findDispatchApplicationsByBusinessDate(searchDto.getBusinessFromDate(), searchDto.getBusinessToDate(),user.getBranchMst().getBranchId());
			
			
			model.addAttribute("licOblApplicationMstList", licOblApplicationMstList);
			model.addAttribute("dispatchHub", searchDto.getHubId());
		}catch(Exception e){
			
		}
		
		return "branchHubDispatch";
	}
	
	@RequestMapping(value="/licBranchActivity/branchHubDispatchSave",method=RequestMethod.POST)
	public String onSave(@RequestParam("applicationNo") Long [] ids,HttpServletRequest request){
		
		try{
			List<LicOblApplicationMst> selectedList = new ArrayList<LicOblApplicationMst>();
			
			for(Long id:ids){
				System.out.println("Iddddd "+id);
				LicOblApplicationMst licOblApplicationMst = licOblApplicationMstService.findById(id);
				selectedList.add(licOblApplicationMst);
			}
			
			Long hubId = (Long) request.getSession().getAttribute("dispatchHub");
			UserMst user = (UserMst) request.getSession().getAttribute("user");
			Date now = new Date();
			Double total = 0.0;
			LicHubMst hub = licHubMstService.findById(hubId);
			
			LicBrnhHubPicMapDtls licBrnhHubPicMapDtls = new LicBrnhHubPicMapDtls();
			licBrnhHubPicMapDtls.setBranchHubPicFlag("B2H");
			licBrnhHubPicMapDtls.setDispatchListDate(now);
			licBrnhHubPicMapDtls.setTotalAmount(total);
			licBrnhHubPicMapDtls.setCreatedBy(user.getUserid());
			licBrnhHubPicMapDtls.setModifiedBy(user.getUserid());
			licBrnhHubPicMapDtls.setCreatedDate(now);
			licBrnhHubPicMapDtls.setModifiedDate(now);
			licBrnhHubPicMapDtls.setDeleteFlag("N");
			
			for(LicOblApplicationMst obj : selectedList){
				obj.setBrnhHubMapDtls(licBrnhHubPicMapDtls);
				obj.setOblHubMst(hub);	
			}
			
			
			licBrnhHubPicMapDtls.setLicOblApplicationMsts(selectedList);
			
			Long id = licBrnhHubPicMapDtlsService.saveForBranchHubDispatchList(licBrnhHubPicMapDtls);
			
			if(id>0){
				return "redirect:/licBranchActivity/branchHubDispatch.html?status=success";
			}else{
				return "redirect:/licBranchActivity/branchHubDispatch.html?status=fail";
			}
			
		}catch(Exception e){
			
		}
		
		return "redirect:/licBranchActivity/branchHubDispatch.html";
	}
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(true);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}*/
}
