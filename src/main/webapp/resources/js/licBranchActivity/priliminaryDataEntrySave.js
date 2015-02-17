$(document).ready(function() {
	$('#table').dataTable();
	$("#table .odd").remove();
	
	
	$("#addBtn").click(function(){
		//$("#table .odd").remove();
		$("#table tbody").append(
				"<tr>"+
					"<td><select class='form-control payMode'> <option value=''>Select One</option>  <option value='Q'>Cheque</option> <option value='D'>DD</option> </select></td>"+
					"<td><input type='text' class='form-control chqDdNo'/></td>"+
					"<td><select class='form-control fevOf'> <option value=''>Select One</option>  <option value='LIFE INSURANCE CORPORATION OF INDIA (LICI)'>LIFE INSURANCE CORPORATION OF INDIA (LICI)</option> </select></td>" +
					"<td><input type='text' class='form-control bank'/></td>" +
					"<td><input type='text' class='form-control branch'/></td>" +
					"<td><input type='text' class='form-control chqDdDate'/></td>" +
					"<td><input type='text' class='form-control chqDdAmount'/></td>" +
					"<td><a href='#' class='removebutton'>DELETE</a></td>"+
				"</tr>");

		
	});
	
	$('#processBtn').on('click', function () {
		var totalDdChqAmt = 0.0;
		$('.chqDdAmount').each(function(){
			totalDdChqAmt = totalDdChqAmt + parseFloat($(this).val());
		 });
		
		
		var totalReceivable = (parseFloat(chequeDouble($('#totalAmount').val())) - (parseFloat(chequeDouble($('#ddMakingCrg').val())) + parseFloat(chequeDouble($('#otherCrg').val()))));
		var balanceInCash = 0.0;
		if(totalReceivable >= totalDdChqAmt){
			balanceInCash = parseFloat(totalReceivable) - parseFloat(totalDdChqAmt);
		 }else{
			 balanceInCash = 0.0;
		 }
		$("#balanceInCash").val(balanceInCash);
		$("#totalReceivable").val(totalReceivable);
		$("#totalDdChqAmt").val(totalDdChqAmt);
		$("#amtToReturn").val(0.0);
		$("#myModal").modal('show');
	});
	
});

$('#saveBtn').on('click', function () {
	var ddMakingCharges  = parseFloat(chequeDouble($('#ddMakingCrg').val()));
	var otherCharges = parseFloat(chequeDouble($('#otherCrg').val()));
	var remarks = $('#remarks').val();
	var totalReceivable = $('#totalReceivable').val();
	var balanceInCash = $('#balanceInCash').val();
	var totalDdChqAmt = $('#totalDdChqAmt').val();
	
	var chqDdAmount = 0.0;
	var payMode = '';
	var chqDdNo = '';
	var fevOf = '';
	var bank = '';
	var branch = '';
	var chqDdDate = '';
	
	var table = [];
	
	$('#table tbody tr').each(function(){
		chqDdAmount = parseFloat($(this).find( ".chqDdAmount" ).val());
		payMode = $(this).find( ".payMode" ).val();
		chqDdNo = $(this).find( ".chqDdNo" ).val();
		fevOf = $(this).find( ".fevOf" ).val();
		bank = $(this).find( ".bank" ).val();
		branch = $(this).find( ".branch" ).val();
		chqDdDate = $(this).find( ".chqDdDate" ).val();
		
		table.push({
			"payMode": payMode,
			"draftChqNo": chqDdNo,
			"payeeName": fevOf,
			"draftChqBank": bank,
			"draftCgqBranch": branch,
			"draftChqDate": chqDdDate,
			"amount":chqDdAmount
	    });
	 });
	var data = { "licPaymentDtlsList": table ,"totalReceivable": totalReceivable ,
			"balanceInCash": balanceInCash, "totalDdChqAmt" : totalDdChqAmt , "amtToReturn" : 0.0, "ddMakingCharges" : ddMakingCharges,
			"otherCharges" : otherCharges, "remarks" : remarks};
	
	//alert(JSON.stringify(data));
	$.ajax({url: "/licBranchActivity/priliminaryDataEntrySave/OnSave.html", 
		type: "POST",
		data: JSON.stringify(data),
		contentType: "application/json",
		success: function(response){
			alert(response.redirectUrl);
			// window.location = response.redirect;
			/*if (response.redirect) {
                window.location.href = response.redirect;
            }*/
	    },
		error: function(xhr){
			alert("An error occured: " + xhr.status + " " + xhr.statusText);
		}
	});
});



$(document).on('click', 'a.removebutton', function () {
    $(this).closest('tr').remove();
    return false;
});

function chequeDouble(val){
	if($.isNumeric(val)){
		return val;
	}else{
		return 0.0;
	}
}
