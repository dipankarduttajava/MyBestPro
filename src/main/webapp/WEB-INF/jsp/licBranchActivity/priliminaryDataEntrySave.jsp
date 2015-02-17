<%@include file="../../taglib.jsp" %>

<c:if test="${param.status == 'success'}">
    <div class="alert alert-success" style="width:90%;margin: auto;margin-top: 5px;">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Success!</strong>
    </div>
</c:if>

<c:if test="${param.status == 'fail'}">
    <div class="alert alert-error" style="width:90%;margin: auto;margin-top: 5px;">
        <a href="#" class="close" data-dismiss="alert">&times;</a>
        <strong>Error!</strong> 
    </div>
</c:if>


<form:form modelAttribute="licPreliminaryDataEntryDto" >
<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Personal Details
   </div>
   <div class="panel-body" >
     		<div class="form-group row">
	     		<form:label path="insuredName" cssClass="control-label col-sm-3">Name Of The Insured :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="insuredName" cssClass="form-control" id="insuredName" disabled="true"/>
	     		</div>
	     		<form:label path="insuredDob" cssClass="control-label col-sm-3">Insured Date Of Birth :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="insuredDob" cssClass="form-control" id="insuredDob" disabled="true"/>
	     		</div>
     		</div>
     		
     		<div class="form-group row">
	     		<form:label path="proposerName" cssClass="control-label col-sm-3">Name Of The Proposer :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="proposerName" cssClass="form-control" id="proposerName" disabled="true"/>
	     		</div>
	     		<form:label path="proposerDob" cssClass="control-label col-sm-3">Proposer Date Of Birth :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="proposerDob" cssClass="form-control" id="proposerDob" disabled="true"/>
	     		</div>
     		</div>
     		<div class="form-group row">
	     		<form:label path="applicationNo" cssClass="control-label col-sm-3">Application Number :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="applicationNo" cssClass="form-control" id="applicationNo" disabled="true"/>
	     		</div>
     		</div>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Product Details
   </div>
   <div class="panel-body" >
	  		<div class="form-group row">
	     		<form:label path="productName" cssClass="control-label col-sm-3">Product :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="productName" cssClass="form-control" id="productName" disabled="true"/>
	     		</div>
	     		<form:label path="policyTerm" cssClass="control-label col-sm-3">Policy Term :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="policyTerm" cssClass="form-control" id="policyTerm" disabled="true"/>
	     		</div>
     		</div>
     		<div class="form-group row">
	     		<form:label path="tabPrem" cssClass="control-label col-sm-3">Tabular Premium :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="tabPrem" cssClass="form-control" id="tabPrem" disabled="true"/>
	     		</div>
	     		<form:label path="basicPrem" cssClass="control-label col-sm-3">Basic Premium :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="basicPrem" cssClass="form-control" id="basicPrem" disabled="true"/>
	     		</div>
     		</div>
     		<div class="form-group row">
	     		<form:label path="totalAmount" cssClass="control-label col-sm-3">Total Amount :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="totalAmount" cssClass="form-control" id="totalAmount" disabled="true"/>
	     		</div>
	     		<form:label path="sumAssured" cssClass="control-label col-sm-3">Sum Assured :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="sumAssured" cssClass="form-control" id="sumAssured" disabled="true"/>
	     		</div>
     		</div>
     		<div class="form-group row">
	     		<form:label path="payMode" cssClass="control-label col-sm-3">Premium Payment Mode :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="payMode" cssClass="form-control" id="payMode" disabled="true"/>
	     		</div>
     		</div>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Office Details
   </div>
   <div class="panel-body" >
   	  		<div class="form-group row">
	     		<form:label path="agCode" cssClass="control-label col-sm-3">Agent Code :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="agCode" cssClass="form-control" id="agCode" disabled="true"/>
	     		</div>
	     		<form:label path="phaseName" cssClass="control-label col-sm-3">Phase :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="phaseName" cssClass="form-control" id="phaseName" disabled="true"/>
	     		</div>
     		</div>
	  		
     		<div class="form-group row">
	     		<form:label path="businessDate" cssClass="control-label col-sm-3">Business Date :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="businessDate" cssClass="form-control" id="businessDate" disabled="true"/>
	     		</div>
	     		<form:label path="companyName" cssClass="control-label col-sm-3">Name Of The Company :</form:label>
	     		<div class="col-sm-3">
	     			<form:input path="companyName" cssClass="form-control" id="companyName" disabled="true"/>
	     		</div>
     		</div>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Payment Details
   </div>
   <div class="panel-body" >
     	<button id="addBtn" type="button" class="btn btn-default">Add</button>
     	<hr/>
     	<table id="table" class="table table-striped table-bordered">
		   <thead>
		      <tr>
		         <th>DD/Cheque</th>
		         <th>DD/Cheque No.</th>
		         <th>Favour Of</th>
		         <th>Bank</th>
		         <th>Branch</th>
		         <th>DD/Cheque Date</th>
		         <th>DD/Cheque Amount</th>
		         <th>Action</th>
		      </tr>
		   </thead>
		   <tbody>
		   		
		   </tbody>
		</table>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Concessions
   </div>
   <div class="panel-body" >
   	  		<div class="form-group">
	     		<label for="ddMakingCrg" class="control-label col-sm-2">DD making Charges :</label>
	     		<div class="col-sm-2">
	     			<input type="text" name="ddMakingCrg" class="form-control" id="ddMakingCrg" />
	     		</div>
     		</div>
     		<div class="form-group">
	     		<label for="otherCrg" class="control-label col-sm-2">Others :</label>
	     		<div class="col-sm-2">
	     			<input type="text" name="otherCrg" class="form-control" id="otherCrg" />
	     		</div>
     		</div>
     		<div class="form-group">
	     		<label for="remarks" class="control-label col-sm-2">Remarks(If Others) :</label>
	     		<div class="col-sm-2">
	     			<input type="text" name="remarks" class="form-control" id="remarks" />
	     		</div>
     		</div>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
	<div class="panel-body" >
   		<button id="processBtn" type="button" class="btn btn-default">Process</button>
	</div>
</div>


<!-- Model HTML -->
 <div id="myModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">Confirmation</h4>
                </div>
                <div class="modal-body">
                    <div class="form-group row">
			     		<label for="totalReceivable" class="control-label col-sm-3">Total Receivable :</label>
			     		<div class="col-sm-3">
			     			<input type="text" name="totalReceivable" class="form-control" id="totalReceivable" disabled="true"/>
			     		</div>
			     		<label for="totalDdChqAmt" class="control-label col-sm-3">Total DD/Cheque Amount :</label>
			     		<div class="col-sm-3">
			     			<input type="text" name="totalDdChqAmt" class="form-control" id="totalDdChqAmt" disabled="true"/>
			     		</div>
		     		</div>
		     		 <div class="form-group row">
			     		<label for="balanceInCash" class="control-label col-sm-3">Balance Receivable In Cash :</label>
			     		<div class="col-sm-3">
			     			<input type="text" name="balanceInCash" class="form-control" id="balanceInCash" disabled="true"/>
			     		</div>
			     		<label for="amtToReturn" class="control-label col-sm-3">Amount To Be Return :</label>
			     		<div class="col-sm-3">
			     			<input type="text" name="amtToReturn" class="form-control" id="amtToReturn" disabled="true"/>
			     		</div>
		     		</div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button id="saveBtn" type="button" class="btn btn-primary">Save</button>
                </div>
            </div>
        </div>
 </div>

</form:form>
<script src="/resources/js/licBranchActivity/priliminaryDataEntrySave.js"></script>