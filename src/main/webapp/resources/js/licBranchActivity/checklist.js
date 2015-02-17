function getMonths(todaysDate, yourDate) {
	var d1 = todaysDate;
	var d2 = yourDate;
	if(todaysDate < yourDate) {
	d1 = yourDate;
	d2 = todaysDate;
	}
	var m = (d1.getFullYear() - d2.getFullYear()) * 12 + (d1.getMonth() - d2.getMonth());
	if (d1.getDate() < d2.getDate()) {
		m--;
	}
	return m;
}	
	
function getYears(todaysDate, yourDate) {
	var years = todaysDate.getFullYear() - yourDate.getFullYear();
	var m = todaysDate.getMonth() - yourDate.getMonth();
	if (m < 0 || (m === 0 && todaysDate.getDate() < yourDate.getDate())) {
		years--;
	}
	return years;
}




$(document).ready(function() {
	
	$('#insuredDob').change(function(){
		
		try {
			var dob = $(this).val();
			var today = new Date();
			var dryDate = new Date(dob);
			//var timeSince = today - dryDate;
			
			
			
			var days = Math.round(today.getDate() - dryDate.getDate());
			var months = getMonths(today, dryDate) % 12;
			var years = getYears(today, dryDate);
			
			if(isNaN(years) || isNaN(months) || isNaN(days)){
				$('#year').val('');
				$('#month').val('');
				$('#day').val('');
			}else{
				$('#year').val(years);
				$('#month').val(months);
				$('#day').val(days);
			}
			
		}
		catch(err) {
			$('#year').val('');
			$('#month').val('');
			$('#day').val('');
		}
		
	});
	
	$('#insuredPropSameFlag').change(function(){
		if($(this).is(":checked")){	
			$('#insuredName').val($('#proposerName').val());	
			$('#insuredDob').val($('#proposerDob').val());
			
			var dob = $('#proposerDob').val();
			var today = new Date();
			var dryDate = new Date(dob);
			//var timeSince = today - dryDate;
			
			
			
			var days = Math.round(today.getDate() - dryDate.getDate());
			var months = getMonths(today, dryDate) % 12;
			var years = getYears(today, dryDate);
			
			$('#year').val(years);
			$('#month').val(months);
			$('#day').val(days);
		}else{
			$('#insuredName').val('');
			$('#insuredDob').val('');
			$('#year').val('');
			$('#month').val('');
			$('#day').val('');
		}
		
		
	});
	
	
	$('#productId').change(function(event) {
	      var productId = $("#productId").val();
	      var year = $("#year").val();
	      var month = $("#month").val();
	      var day = $("#day").val();
	      $.getJSON('/licBranchActivity/checklist/getTermByProduct.html', {
	    	  productId : productId,
	    	  year : year,
	    	  month : month
	      }, function(jsonResponse) {
//	        $('#ajaxResponse').text(jsonResponse.dummyMsg);
	        var payMode = $('#payMode');
	        var policyTerm = $("#policyTerm");
	       // var arRiderAmt = $("#arRiderAmt");
	        
	        //arRiderAmt.val(jsonResponse.arRiderAmt);
	        
	        payMode.find('option').remove();
	        policyTerm.find('option').remove();
	         $.each(jsonResponse.payModeList, function(key, value) {
	          $('<option>').val(key).text(value).appendTo(payMode);
	        }); 
	        
	        $.each(jsonResponse.termList, function(value) {
		          $('<option>').val(value).text(value).appendTo(policyTerm);
		    });
	        
	       
	        });
	      });
	
	
	
	
	
	
	
	/* $('#insuredPropSameFlag').on('change',function(){
		if($('#insuredPropSameFlag').prop('checked')){
			$('#insuredName').val($('#proposerName').val());
			$('#insuredDob').val($('#proposerDob').val());
		}else{
			$('#insuredName').val('');
			$('#insuredDob').val('');
		}
		
	}); */
	
	
	 $('#proposerDobPicker').datepicker({
         format: 'dd/mm/yyyy'
     }).on('changeDate', function(e) {
         // Revalidate the date field
         $('#checklistForm').formValidation('revalidateField', 'proposerDob');
     });
	 
	 $('#insuredDobPicker').datepicker({
         format: 'dd/mm/yyyy'
     }).on('changeDate', function(e) {
         // Revalidate the date field
        // $('#checklistForm').formValidation('revalidateField', 'proposerDob');
     });
	 
	 $('#checklistForm').formValidation({
	        framework: 'bootstrap',
	        icon: {
	            valid: 'glyphicon glyphicon-ok',
	            invalid: 'glyphicon glyphicon-remove',
	            validating: 'glyphicon glyphicon-refresh'
	        },
	        fields: {
	        	agCode: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Enter Code'
	                    }
	                }
	            },
	            oblApplNo: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Enter Application No'
	                    }
	                }
	            },
	            phaseId: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Select Phase Id'
	                    }
	                }
	            },
	            proposerName: {
	                validators: {
	                    notEmpty: {
	                        message: 'Please Enter Proposer Name'
	                    }
	                }
	            },
	            proposerDob: {
	                validators: {
	                    notEmpty: {
	                        message: 'The Select Proposer DOB'
	                    },
	                    date: {
	                        format: 'DD/MM/YYYY',
	                        message: 'The date is not valid'
	                    }
	                }
	            }
	        }
	    });
	 
	 
});