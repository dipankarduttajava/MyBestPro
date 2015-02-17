<%@include file="../taglib.jsp" %>
<link rel="stylesheet" href="/resources/css/signin.css">

<div class="container">

      <form class="form-signin" id="chooseBranch" method="POST" action="chooseBranch.html">
        <h2 class="form-signin-heading">Choose Branch</h2>
        <label for="branchId" class="sr-only">Branch</label>
        <select name="branchId" class="form-control">
       		<option value="">Select One</option>
	       	<c:forEach items="${branches}" var="row">
	       		<option value="${row.branchId}">${row.branchName}</option>
	       	</c:forEach>
		</select>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
      </form>

</div> <!-- /container -->

