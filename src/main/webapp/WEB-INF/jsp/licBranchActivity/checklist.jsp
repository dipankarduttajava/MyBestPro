<%@include file="../../taglib.jsp" %>
<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Check List
   </div>
   <div class="panel-body" >
   	<form:form action="/licBranchActivity/checklist.html" method="POST" modelAttribute="checklist" id="checklistForm">
   		<div class="row">
     		<div class="col-md-4">
     			 <div class="form-group">
	     			<form:label path="agCode">Code :*</form:label>
	     			<form:input path="agCode" cssClass="form-control" id="agCode" placeholder="Code"/>
     			</div>
			</div>
     		<div class="col-md-4">
     			<div class="form-group">
					<form:label path="oblApplNo">Application Number :*</form:label>
	     			<form:input path="oblApplNo" cssClass="form-control" id="oblApplNo" placeholder="Application Number"/>
	     		</div>
			</div>
			<div class="col-md-4">
				<div class="form-group">
					<form:label path="phaseId">Phase Id :*</form:label>
	     			<form:select path="phaseId" cssClass="form-control" id="phaseId">
	     				<form:option value="" label="Select One" />
	   					<form:options items="${phaseList}" itemLabel="phaseName" itemValue="phaseId"/>
	     			</form:select>
     			</div>
			</div>
     	</div>
     	
     	<div class="row">
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="proposerName">Proposer Name :*</form:label>
	     			<form:input path="proposerName" cssClass="form-control" id="proposerName" placeholder="Proposer Name"/>
     			</div>
			</div>
     		<div class="col-md-4">
     			<div class="form-group">
					<form:label path="proposerDob">Proposer DOB :*</form:label>
					<div class="input-group input-append date" id="proposerDobPicker">
						<form:input path="proposerDob" cssClass="form-control" id="proposerDob" placeholder="Proposer DOB"/>
						<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
					</div>
     			</div>
     			 
			</div>
			<div class="col-md-4">
				<div class="form-group">
	     			<form:checkbox path="insuredPropSameFlag" cssClass="form-control" id="insuredPropSameFlag" label="Is Proposer and Insured Person Same ? :"/>
     			</div>
			</div>
     	</div>
     	<div class="row">
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="insuredName">Insured Name :*</form:label>
	     			<form:input path="insuredName" cssClass="form-control" id="insuredName" placeholder="Insured Name"/>
     			</div>
			</div>
     		<div class="col-md-4">
     			<div class="form-group">
					<form:label path="insuredDob">Insured DOB :*</form:label>
					<div class="input-group input-append date" id="insuredDobPicker">
						<form:input path="insuredDob" cssClass="form-control" id="insuredDob" placeholder="Insured DOB"/>
						<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
					</div>
     			</div>
     			 
			</div>
			<div class="col-md-4">
			</div>
     	</div>
     	<div class="row">
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="year">Year :</form:label>
	     			<form:input path="year" cssClass="form-control" id="year" placeholder="Year" disabled="true"/>
     			</div>
			</div>
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="month">Month :</form:label>
	     			<form:input path="month" cssClass="form-control" id="month" placeholder="Month" disabled="true"/>
     			</div>
			</div>
			<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="day">Day :</form:label>
	     			<form:input path="day" cssClass="form-control" id="day" placeholder="Day" disabled="true"/>
     			</div>
			</div>
     	</div>
     	<div class="row">
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="productId">Product Name :*</form:label>
	     			<form:select path="productId" cssClass="form-control" id="productId">
	     				<form:option value="" label="Select One" />
	   					<form:options items="${productList}" itemLabel="prodDesc" itemValue="id"/>
	     			</form:select>
     			</div>
			</div>
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="policyTerm">Policy Term :*</form:label>
	     			<form:select path="policyTerm" cssClass="form-control" id="policyTerm"></form:select>
     			</div>
			</div>
			<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="payMode">Pay Mode :*</form:label>
	     			<form:select path="payMode" cssClass="form-control" id="payMode"></form:select>
     			</div>
			</div>
     	</div>
     	<div class="row">
     		<div class="col-md-4">
     			<div class="form-group">
	     			<form:label path="sumAssured">Sum Assured :*</form:label>
	     			<form:input path="sumAssured" cssClass="form-control" id="sumAssured" placeholder="Sum Assured"/>
     			</div>
			</div>
     		<div class="col-md-4">
     			
			</div>
			<div class="col-md-4">
     			
			</div>
     	</div>
   		<div class="form-group">
	        <div>
	            <button type="submit" class="btn btn-default">Validate</button>
	        </div>
	    </div>
   	</form:form>
   </div>
</div>

<script src="/resources/js/licBranchActivity/checklist.js"></script>