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


<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Search Criteria
   </div>
   <div class="panel-body" >
     <form:form cssClass="form-inline" action="/licBranchActivity/branchHubDispatch.html" method="post" modelAttribute="searchDto">
		  	<div class="form-group">
				<form:label path="businessFromDate">Business From Date :*</form:label>
				<div class="input-group input-append date" id="businessFromDatePicker">
				<form:input path="businessFromDate" cssClass="form-control" id="businessFromDate" placeholder="Date"/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
  			</div>
  			<div class="form-group">
				<form:label path="businessToDate">Business To Date :*</form:label>
				<div class="input-group input-append date" id="businessToDatePicker">
				<form:input path="businessToDate" cssClass="form-control" id="businessToDate" placeholder="Date"/>
				<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
  			</div>
		  <div class="form-group">
		    <form:label path="hubId">Hubs :</form:label>
		    <form:select path="hubId" cssClass="form-control" id="hubId" >
		    	<form:option value="" label="Select One" />
	   			<form:options items="${hubMstList}" itemLabel="hubName" itemValue="id"/>
		    </form:select>
		  </div>
		  <button type="submit" class="btn btn-default">Search</button>
	</form:form>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Preliminary Data Entry List 
   </div>
   <div class="panel-body" >
     <form method="POST" action="/licBranchActivity/branchHubDispatchSave.html" >
     	<table id="table" class="table table-striped table-bordered" data-pagination="true">
		   <thead>
		      <tr>
		      	 <th>Active</th>
		         <th>Application No</th>
		         <th>Business Date</th>
		         <th>Insured Name</th>
		         <th>Proposer Name</th>
		         <th>Branch</th>
		         <th>Product</th>
		         <th>Basic Premium</th>
		         <th>Service Tax</th>
		         <th>Pay Mode</th>
		     	 <th>Pay Nature</th>
		     	 <th>Total Amount</th>
		      </tr>
		   </thead>
		   <tbody>
		   <c:forEach items="${licOblApplicationMstList}" var="row">
		   		<tr>
		   		 <td><input type="checkbox" name="applicationNo" value="${row.id}" /></td>
		   		 
		         <td>${row.oblApplNo}</td>
		         <td><fmt:formatDate pattern="dd/MM/yyyy" value="${row.businessDate}"/></td>
		         <td>${row.licInsuredDtls.name}</td>
		         <td>${row.licProposerDtls.name}</td>
		         <td>${row.branchMst.branchName}</td>
		         <td>${row.licProductValueMst.licProductMst.prodDesc}</td>
		         <td>${row.licProductValueMst.basicPrem}</td>
		         <td>${row.licProductValueMst.taxOnPrem}</td>
		         <td>${row.licProductValueMst.taxOnPrem}</td>
		         <td>${row.licProductValueMst.payNature}</td>
		         <td>${row.licProductValueMst.totalAmt}</td>
		      </tr>
		   </c:forEach>
		      
		      
		   </tbody>
		</table>
		<script type="text/javascript">
		$(document).ready(function() {
		    $('#table').dataTable();
		} );
		</script>
		
		<div class="form-group">
	        <div>
	            <button type="submit" class="btn btn-default">Save</button>
	        </div>
	    </div>
	</form>
   </div>
</div>

<script src="/resources/js/licBranchActivity/branchHubDispatch.js"></script>