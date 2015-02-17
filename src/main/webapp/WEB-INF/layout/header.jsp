<%@include file="../taglib.jsp" %>


<div id='cssmenu'>
<ul>
    <li class="${current == 'licBranchActivity' ? 'active' : '' }"><a href='#'>Branch Activity</a>
      <ul>
	      <security:authorize access="hasRole('10002')">
	         <li><a href='/licBranchActivity/checklist.html'>CHECK LIST</a> </li>
	      </security:authorize>
	      <security:authorize access="hasRole('10003')">
	         <li><a href='/licBranchActivity/priliminaryDataEntry.html'>PRELIMINARY DATA ENTRY</a> </li>
	      </security:authorize>
	      <security:authorize access="hasRole('10004')">
	         <li><a href='/licBranchActivity/printReceipt.html'>LIC PRINT RECEIPT</a> </li>
	      </security:authorize>
	      <security:authorize access="hasRole('10006')">
	         <li><a href='/licBranchActivity/branchHubDispatch.html'>LIC BRANCH HUB DISPATCH</a> </li>
	      </security:authorize>
      </ul>
   </li>
   <li class="${current == 'users' ? 'active' : '' }"><a href='#'>Master Data</a>
      <ul>
	      <security:authorize access="hasRole('10021')">
	         <li><a href='/admin/users.html'>User Master</a> </li>
	      </security:authorize>
      </ul>
   </li>
   
   <li><a href='#'>About</a></li>
   <li><a href='#'>Contact</a></li>
   
   <li style="float:right;"><a href='/logout'>Logout</a></li>
</ul>
</div>