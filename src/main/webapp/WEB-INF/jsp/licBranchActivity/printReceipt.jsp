<%@include file="../../taglib.jsp" %>
<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Search Application
   </div>
   <div class="panel-body" >
     <form class="form-inline" action="/licBranchActivity/printReceiptSearch.html" method="post">
		  	<div class="form-group">
				<label for="businessDate">Date :* </label>
				<div class="input-group input-append date" id="businessDatePicker">
					<input type="text" name="businessDate" class="form-control" id="businessDate" placeholder="Date"/>
					<span class="input-group-addon add-on"><span class="glyphicon glyphicon-calendar"></span></span>
				</div>
  			</div>
  			<div class="form-group label"><label ></label></div>
		  <div class="form-group">
		    <label for="applicationNo">Application Number : </label>
		    <input type="text" name="applicationNo" class="form-control" id="applicationNo" placeholder="Application Number" />
		  </div>
		  <div class="form-group label"><label ></label></div>
		  <button type="submit" class="btn btn-default" style="width: 8%">Search</button>
	</form>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Print Receipt List
   </div>
   <div class="panel-body" >
     <form>
     	<table id="table" class="table table-striped table-bordered" data-pagination="true">
		   <thead>
		      <tr>
		         <th>Application No</th>
		         <th>Business Date</th>
		         <th>Insured Name</th>
		         <th>Proposer Name</th>
		         <th>Product Name</th>
		         <th>Amount</th>
		         <th>Print Status</th>
		         <th>Action</th>
		      </tr>
		   </thead>
		   <tbody>
		   <c:forEach items="${licOblApplicationMsts}" var="row">
		   		<tr>
		         <td>${row.oblApplNo}</td>
		         <td><fmt:formatDate pattern="dd/MM/yyyy" value="${row.businessDate}" /></td>
		          <td>${row.licInsuredDtls.name}</td>
		         <td>${row.licProposerDtls.name}</td>
		         <td>${row.licProductValueMst.licProductMst.prodDesc}</td>
		         <td>${row.licProductValueMst.totalAmt}</td>
		         <td>${row.printFlag}</td>
		         <td><a href='/licBranchActivity/provitionalPrintReceipt.html' style="font-weight: bold">Print</a></td>
		      </tr>
		   </c:forEach>
		      
		      
		   </tbody>
		</table>
		<script type="text/javascript">
		$(document).ready(function() {
		    $('#table').dataTable();
		} );
		</script>
	</form>
   </div>
</div>
<script src="/resources/js/licBranchActivity/priliminaryDataEntry.js"></script>