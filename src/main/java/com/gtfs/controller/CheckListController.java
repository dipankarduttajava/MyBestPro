package com.gtfs.controller;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gtfs.dto.ChecklistDto;
import com.gtfs.dto.ProductChangeDto;
import com.gtfs.service.interfaces.LicPremFreqAllowARMstService;
import com.gtfs.service.interfaces.LicProductMstService;
import com.gtfs.service.interfaces.LicTabPremMstService;
import com.gtfs.service.interfaces.PhaseMstService;

@Controller
public class CheckListController implements Serializable{
	@Autowired
	private PhaseMstService phaseMstService;
	@Autowired
	private LicProductMstService licProductMstService;
	@Autowired
	private LicTabPremMstService licTabPremMstService;
	@Autowired
	private LicPremFreqAllowARMstService licPremFreqAllowARMstService;
	
	
	@RequestMapping("/licBranchActivity/checklist")
	public String onLoad(Model model){
		model.addAttribute("checklist", new ChecklistDto());
		model.addAttribute("phaseList", phaseMstService.findBusinessPhasesForCurrentDate());
		model.addAttribute("productList",licProductMstService.findActiveLicProductMstForChecklist());
		return "checklist";
	}
	@RequestMapping(value="/licBranchActivity/checklist" , method=RequestMethod.POST)
	public String onSave(){
		return "checklist";
	}
	
	@RequestMapping(value="/licBranchActivity/checklist/getTermByProduct")
	public @ResponseBody ProductChangeDto getTermByProduct(@RequestParam("productId")Long productId,@RequestParam("year")Integer year,@RequestParam("month")Integer month){
		ProductChangeDto productChangeDto = new ProductChangeDto();
		
		Integer minAge = licTabPremMstService.findMinAgeByProdId(productId).get(0);
		int age=0;
		
		if(minAge!=null){
			if(minAge <= year){
				
				if (month >= 6) {
					age = year + 1;
				} else {
					age = year;
				}
				
				for(Long obj : licTabPremMstService.findTermsByAgeProdId(age,productId)){
					if(obj == null){
					}else{
						productChangeDto.getTermList().add(obj);
					}
				}
			}
		}
		
		String paymode = licPremFreqAllowARMstService.findPayModeByProdId(productId).get(0);
		
		if(paymode != null){
			if(paymode.contains("Y")){
				productChangeDto.getPayModeList().put("Y","Yearly");
			}
			if(paymode.contains("H")){
				productChangeDto.getPayModeList().put("H","Half-Yearly");
			}
			/*if(paymode.contains("Q")){
				payModeList.add(new SelectItem("Q","Quaterly"));
			}
			if(paymode.contains("M")){
				payModeList.add(new SelectItem("M","Monthly"));
			}*/
			if(paymode.contains("S")){
				productChangeDto.getPayModeList().put("S","Single");
			}
		}
		
		
		
		return productChangeDto;
	}
	
	
}
