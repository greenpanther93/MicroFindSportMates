<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<h1>Search User</h1>
	<form:form action="/search-user" method="post" class="form-horizontal">
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>User Name:</label> 
				<input class="form-control" type="text" name="username" placeholder="Enter username">
			</div>
		</fieldset>
		<div>
			<button type="submit" class="btn btn-primary btn-md" >Search</button>
		</div>
		
	</form:form>
</div>
<%@ include file="common/footer.jspf"%>