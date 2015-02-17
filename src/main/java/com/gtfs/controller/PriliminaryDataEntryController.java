package com.gtfs.controller;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.gtfs.bean.AgentMst;
import com.gtfs.bean.LicBusinessTxn;
import com.gtfs.bean.LicInsuredDtls;
import com.gtfs.bean.LicOblApplicationMst;
import com.gtfs.bean.LicOblChecklist;
import com.gtfs.bean.LicPaymentDtls;
import com.gtfs.bean.LicPaymentMst;
import com.gtfs.bean.LicProposerDtls;
import com.gtfs.bean.UserMst;
import com.gtfs.dto.LicPreliminaryDataEntryDto;
import com.gtfs.service.interfaces.AgentMstService;
import com.gtfs.service.interfaces.BranchMstService;
import com.gtfs.service.interfaces.DesignationMstService;
import com.gtfs.service.interfaces.LicHubMstService;
import com.gtfs.service.interfaces.LicOblApplicationMstService;
import com.gtfs.service.interfaces.LicOblChecklistService;
import com.gtfs.service.interfaces.LicProductMstService;
import com.gtfs.service.interfaces.PhaseMstService;
import com.gtfs.util.FinYearCalculation;

@Controller
@SessionAttributes({"licPreliminaryDataEntryDto","user"})
public class PriliminaryDataEntryController implements Serializable{
	@Autowired
	private LicOblChecklistService licOblChecklistService;
	@Autowired
	private LicHubMstService licHubMstService;
	@Autowired
	private AgentMstService agentMstService;
	@Autowired
	private PhaseMstService phaseMstService;
	@Autowired
	private LicProductMstService licProductMstService;
	@Autowired
	private LicOblApplicationMstService licOblApplicationMstService;
	@Autowired
	private BranchMstService branchMstService;
	@Autowired
	private DesignationMstService designationMstService;
	
	@RequestMapping("/licBranchActivity/priliminaryDataEntry")
	public String onLoad(Model model){
		return "priliminaryDataEntry";
	}
	
	@RequestMapping(value="/licBranchActivity/priliminaryDataEntry",method=RequestMethod.POST)
	public String onSearch(@RequestParam("applicationNo") String applicationNo, @RequestParam("businessDate") String businessDate,@ModelAttribute("user")UserMst user,Model model){

		try{
			if(!StringUtils.isEmpty(businessDate)){
				 SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
				 List<LicOblChecklist> licOblChecklists = licOblChecklistService.findApplicationForPremDataEntryByDate(dateFormat.parse(businessDate), user.getBranchMst().getBranchId());

				model.addAttribute("licOblChecklists", licOblChecklists);
			}

			if(!StringUtils.isEmpty(applicationNo)){
				List<LicOblChecklist> licOblChecklists = licOblChecklistService.findApplicationForPremDataEntryByApplicationNo(applicationNo, user.getBranchMst().getBranchId());
				model.addAttribute("licOblChecklists", licOblChecklists);
				
			}
		}catch(Exception e){
		}
		
		return "priliminaryDataEntry";
	}
	@RequestMapping(value="/licBranchActivity/priliminaryDataEntrySave")
	public String onActionClick(@RequestParam("applicationNo")String applicationNo,Model model,@ModelAttribute("user")UserMst user){
		try{
			List<LicOblChecklist> licOblChecklists = licOblChecklistService.findApplicationForPremDataEntryByApplicationNo(applicationNo, user.getBranchMst().getBranchId());
			
			LicPreliminaryDataEntryDto licPreliminaryDataEntryDto = new LicPreliminaryDataEntryDto();			
			licPreliminaryDataEntryDto.setLicOblChecklist(licOblChecklists.get(0));
			licPreliminaryDataEntryDto.setInsuredName(licOblChecklists.get(0).getInsuredName());
			licPreliminaryDataEntryDto.setInsuredDob(licOblChecklists.get(0).getInsuredDob());
			licPreliminaryDataEntryDto.setProposerName(licOblChecklists.get(0).getProposerName());
			licPreliminaryDataEntryDto.setProposerDob(licOblChecklists.get(0).getProposerDob());
			licPreliminaryDataEntryDto.setApplicationNo(licOblChecklists.get(0).getOblApplNo());
			licPreliminaryDataEntryDto.setProductId(licOblChecklists.get(0).getLicProductValueMst().getLicProductMst().getId());
			licPreliminaryDataEntryDto.setProductName(licOblChecklists.get(0).getLicProductValueMst().getLicProductMst().getProdDesc());
			licPreliminaryDataEntryDto.setPolicyTerm(licOblChecklists.get(0).getLicProductValueMst().getPolicyTerm());
			//licPreliminaryDataEntryDto.setPremiumAmount(licOblChecklist.getLicProductValueMst().getPremAmt()); you will do this work
			//licPreliminaryDataEntryDto.setServiceTax(licOblChecklist.getLicProductValueMst().getTaxSvcChrgs());
			licPreliminaryDataEntryDto.setTabPrem(licOblChecklists.get(0).getLicProductValueMst().getTabPrem());
			licPreliminaryDataEntryDto.setBasicPrem(licOblChecklists.get(0).getLicProductValueMst().getBasicPrem());
			licPreliminaryDataEntryDto.setTotalAmount(licOblChecklists.get(0).getLicProductValueMst().getTotalAmt());
			licPreliminaryDataEntryDto.setSumAssured(licOblChecklists.get(0).getLicProductValueMst().getSumAssured());
			licPreliminaryDataEntryDto.setPayMode(licOblChecklists.get(0).getLicProductValueMst().getPayNature());
			licPreliminaryDataEntryDto.setAgCode(licOblChecklists.get(0).getAgCode());
			licPreliminaryDataEntryDto.setPhaseId(licOblChecklists.get(0).getPhaseMst().getPhaseId());
			licPreliminaryDataEntryDto.setPhaseName(licOblChecklists.get(0).getPhaseMst().getPhaseName());
			licPreliminaryDataEntryDto.setBusinessDate(new Date());
			licPreliminaryDataEntryDto.setCompanyName("LIFE INSURANCE CORPORATION OF INDIA (LICI)");
			//licPreliminaryDataEntryDto.setBranchName(loginAction.getUserList().get(0).getBranchMst().getBranchName());
			//licPreliminaryDataEntryDto.setOperatorName(loginAction.getUserList().get(0).getUserName());
			
			model.addAttribute("licPreliminaryDataEntryDto", licPreliminaryDataEntryDto);
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return "priliminaryDataEntrySave";
	}
	
	@RequestMapping(value="/licBranchActivity/priliminaryDataEntrySave/OnSave" ,method=RequestMethod.POST)
	public String onSave(@RequestBody LicPreliminaryDataEntryDto licPreliminaryDataEntryJson, @ModelAttribute("user")UserMst user,@ModelAttribute("licPreliminaryDataEntryDto")LicPreliminaryDataEntryDto licPreliminaryDataEntryDto,Model model){
		
		System.out.println("dd "+licPreliminaryDataEntryJson.getLicPaymentDtlsList());
		try{
			Date now = new Date();
			Double totalReceived = 0.0;
		 	Long hubId = licHubMstService.findActiveHubIdByBranchId(user.getBranchMst().getBranchId()).get(0);
			
		 	if(hubId == null){
		 		return "priliminaryDataEntrySave";
		 	}
		 	
			AgentMst agentMst = agentMstService.findByAgCode(licPreliminaryDataEntryDto.getAgCode());
			
			LicOblChecklist licOblChecklist = licPreliminaryDataEntryDto.getLicOblChecklist();
			licOblChecklist.setPreDataEntryFlag("Y");
			
			LicPaymentMst licPaymentMst = new LicPaymentMst();
			licPaymentMst.setPayDate(now);
			licPaymentMst.setProcessName("OBL");
			licPaymentMst.setTotalReceivable(licPreliminaryDataEntryJson.getTotalReceivable());
			//licPaymentMst.setTotalReceived(licPreliminaryDataEntryDto.getTotalReceivable());
			licPaymentMst.setSalesTax(0.0);
			licPaymentMst.setServiceTax(0.0);
			licPaymentMst.setServiceCharge(0.0);
			licPaymentMst.setDdCharges(licPreliminaryDataEntryJson.getDdMakingCharges());
			licPaymentMst.setOtherCharges(licPreliminaryDataEntryJson.getOtherCharges());
			licPaymentMst.setCreatedBy(user.getUserid());
			licPaymentMst.setModifiedBy(user.getUserid());
			licPaymentMst.setCreatedDate(now);
			licPaymentMst.setModifiedDate(now);
			licPaymentMst.setDeleteFlag("N");
			
			
			LicBusinessTxn licBusinessTxn=new LicBusinessTxn();
			licBusinessTxn.setTransDate(now);
			
			licBusinessTxn.setPhaseMst(phaseMstService.findByPhaseId(licPreliminaryDataEntryDto.getPhaseId()));
			
			licBusinessTxn.setAgentMst(agentMst);
			licBusinessTxn.setLicProductMst(licProductMstService.findByProductId(licPreliminaryDataEntryDto.getProductId()));
			licBusinessTxn.setBusinessValue(licPreliminaryDataEntryDto.getBasicPrem());
			licBusinessTxn.setFrozenFlag("N");
			licBusinessTxn.setTransferFlag("N");
			licBusinessTxn.setTransStatus("D");
			//licBusinessTxn.setAgentRlns(agentRlns);
			licBusinessTxn.setFreeQtyFlag("N");
			licBusinessTxn.setReceivable(licPreliminaryDataEntryJson.getTotalReceivable());
			//licBusinessTxn.setReceived(licPreliminaryDataEntryDto.getTotalReceivable());
			licBusinessTxn.setCreatedBy(user.getUserid());
			licBusinessTxn.setModifiedBy(user.getUserid());
			licBusinessTxn.setCreatedDate(now);
			licBusinessTxn.setModifiedDate(now);
			licBusinessTxn.setDeleteFlag("N");
			
			//payment for cash 
			if(!licPreliminaryDataEntryJson.getBalanceInCash().equals(0.0)){
				LicPaymentDtls licPaymentDtls = new LicPaymentDtls();
				licPaymentDtls.setAmount(licPreliminaryDataEntryJson.getBalanceInCash());
				licPaymentDtls.setPayMode("C");
				licPaymentDtls.setCreatedBy(user.getUserid());
				licPaymentDtls.setModifiedBy(user.getUserid());
				licPaymentDtls.setCreatedDate(now);
				licPaymentDtls.setModifiedDate(now);
				licPaymentDtls.setDeleteFlag("N");
				licPreliminaryDataEntryJson.getLicPaymentDtlsList().add(licPaymentDtls);
			}
			
			if(licPreliminaryDataEntryJson.getLicPaymentDtlsList().size()>1){
				licPaymentMst.setPayMode("B");
			}else{
				licPaymentMst.setPayMode(licPreliminaryDataEntryJson.getLicPaymentDtlsList().get(0).getPayMode());
			}
			
			for (LicPaymentDtls obj : licPreliminaryDataEntryJson.getLicPaymentDtlsList()) {
				obj.setLicPaymentMst(licPaymentMst);
				totalReceived = totalReceived + obj.getAmount();
			}
			
			licBusinessTxn.setReceived(totalReceived);
			licPaymentMst.setTotalReceived(totalReceived);
			licPaymentMst.setLicPaymentDtlses(licPreliminaryDataEntryJson.getLicPaymentDtlsList());
				
			licBusinessTxn.setLicPaymentMst(licPaymentMst);
			//licPaymentMst.getLicBusinessTxns().add(licBusinessTxn);
			
			LicProposerDtls licProposerDtls=new LicProposerDtls();
			licProposerDtls.setName(licPreliminaryDataEntryDto.getProposerName());
			licProposerDtls.setDob(licPreliminaryDataEntryDto.getProposerDob());
			licProposerDtls.setCreatedBy(user.getUserid());
			licProposerDtls.setModifiedBy(user.getUserid());
			licProposerDtls.setCreatedDate(now);
			licProposerDtls.setModifiedDate(now);
			licProposerDtls.setDeleteFlag("N");
			LicInsuredDtls licInsuredDtls = new LicInsuredDtls();
			licInsuredDtls.setName(licPreliminaryDataEntryDto.getInsuredName());
			licInsuredDtls.setDob(licPreliminaryDataEntryDto.getInsuredDob());
			licInsuredDtls.setCreatedBy(user.getUserid());
			licInsuredDtls.setModifiedBy(user.getUserid());
			licInsuredDtls.setCreatedDate(now);
			licInsuredDtls.setModifiedDate(now);
			licInsuredDtls.setDeleteFlag("N");
			
			LicOblApplicationMst licOblApplicationMst = new LicOblApplicationMst();
			licOblApplicationMst.setAgentMst(agentMst);					
			licOblApplicationMst.setTieupCompyMst(licPreliminaryDataEntryDto.getLicOblChecklist().getLicProductValueMst().getTieupCompyMst());
			licOblApplicationMst.setDesignationMst(designationMstService.findById(user.getDesignationMst().getDesigId()));  
			licOblApplicationMst.setBranchMst(branchMstService.findById(user.getBranchMst().getBranchId())); 
			licOblApplicationMst.setLicProductValueMst(licPreliminaryDataEntryDto.getLicOblChecklist().getLicProductValueMst());
			licOblApplicationMst.setOblApplNo(licPreliminaryDataEntryDto.getApplicationNo());
			licOblApplicationMst.setFinYr(FinYearCalculation.getFiscalYear());
			licOblApplicationMst.setBusinessDate(now);
			licOblApplicationMst.setPrintFlag("N");
			licOblApplicationMst.setSecondaryEntryFlag("N");
			//licOblApplicationMst.setPicBranchId(picBranchId);
			licOblApplicationMst.setCreatedBy(user.getUserid());
			licOblApplicationMst.setModifiedBy(user.getUserid());
			licOblApplicationMst.setCreatedDate(now);
			licOblApplicationMst.setModifiedDate(now);
			licOblApplicationMst.setDeleteFlag("N");
			licOblApplicationMst.setOblHubMst(licHubMstService.findById(hubId));
			licOblApplicationMst.setLicProposerDtls(licProposerDtls);
			licOblApplicationMst.setLicInsuredDtls(licInsuredDtls);
			licOblApplicationMst.setLicBusinessTxn(licBusinessTxn);
			licOblApplicationMst.setLicOblChecklist(licOblChecklist);
			licOblApplicationMst.setMigrationFlag("N");
						
			licProposerDtls.setLicOblApplicationMst(licOblApplicationMst);
			licInsuredDtls.setLicOblApplicationMst(licOblApplicationMst);
			
			
			licBusinessTxn.setLicOblApplicationMst(licOblApplicationMst);
			licPaymentMst.setLicBusinessTxn(licBusinessTxn);
			
			

			//Long id = licOblApplicationMstService.insertDataForPreliminaryDataEntry(licOblApplicationMst);
			
			if(true){
				return "redirect:/licBranchActivity/priliminaryDataEntry.html?status=fail";
			}else{
				return "redirect:/licBranchActivity/priliminaryDataEntry.html?status=fail";
			}
		}catch(Exception e){
			return "redirect:/licBranchActivity/priliminaryDataEntry.html?status=fail";
		}
	}
	
}
