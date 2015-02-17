<%@include file="../../taglib.jsp" %>
<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Search Criteria
   </div>
   <div class="panel-body" >
     <form class="form-inline" action="/admin/searchUser.html" method="post">
		  <div class="form-group">
		    <label for="userId">User Id :</label>
		    <input type="text" name="userId" class="form-control" id="userId" placeholder="User Id">
		  </div>
		  <div class="form-group">
		    <label for="username">User Name :</label>
		    <input type="text" name="username" class="form-control" id="username" placeholder="username">
		  </div>
		  <button type="submit" class="btn btn-default">Search</button>
		</form>
   </div>
</div>

<div class="panel panel-default" style="width:90%;margin: auto;margin-top: 5px;">
   <div class="panel-heading">
      Search Result
   </div>
   <div class="panel-body" >
     <form>
     	<table id="table" class="table table-striped table-bordered" data-pagination="true">
		   <thead>
		      <tr>
		         <th>User Id</th>
		         <th>User Name</th>
		         <th>Division Name</th>
		         <th>Branch Name</th>
		         <th>Designation</th>
		      </tr>
		   </thead>
		   <tbody>
		   <c:forEach items="${users}" var="row">
		   		<tr>
		         <td>${row.userid}</td>
		         <td>${row.userName}</td>
		         <td>${row.divisionMst.divName}</td>
		         <td>${row.branchMst.branchName}</td>
		         <td>${row.designationMst.designation}</td>
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