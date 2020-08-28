<%@ include file="common/header.jspf"%>

<div class="container">
	<h1>Login</h1>
	<form:form action="/login" method="post" class="form-horizontal">
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>User Name:</label> 
				<input class="form-control" type="text" name="username" placeholder="Enter Valid CU Email">
			</div>
		</fieldset>
		<fieldset class="form-group">
			<div class="col-xs-3">
				<label>Password:</label> 
				<input class="form-control" type="password" name="password" placeholder="Enter password">
			</div>
		</fieldset>
		<div>
			<button type="submit" class="btn btn-primary btn-md">Login</button>
		</div>
		
	</form:form>
	<p style="color: red">${errorMsg }</p>
</div>
<%@ include file="common/footer.jspf"%>