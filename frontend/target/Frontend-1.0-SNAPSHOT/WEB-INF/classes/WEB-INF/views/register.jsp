<%@ include file="common/header.jspf"%>


<div class="container">
	<h1>Register</h1>

	<form:form name="myForm" method="post" commandName="user">
		<form:hidden path="id" />

		<fieldset class="form-group">
			<form:label path="username" class="col-md-2 control-label">User Name: </form:label>
			<div class="col-md-5">
				<form:input path="username" class="form-control" type="text"
					name="username" placeholder="Enter Valid CU Email" id="username"></form:input>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="password" class="col-md-2 control-label">Passward: </form:label>
			<div class="col-md-5">
				<form:input path="password" class="form-control" type="password"
					name="password" placeholder="Enter password" id="password"></form:input>
				<form:errors path="password" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="role" class="col-md-2 control-label">role: </form:label>
			<div class="col-md-5">
				<form:select path="role" class="form-control" id="role"
					required="required">
					<option value="NONE" label="--- Select ---" />
					<option value="student">CU Student</option>
					<option value="faculty">CU Faculty</option>
					<option value="officer">Officer</option>
				</form:select>
				<form:errors path="role" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="firstname" class="col-md-2 control-label">First Name: </form:label>
			<div class="col-md-5">
				<form:input path="firstname" class="form-control" type="text"
					name="firstname" placeholder="Enter your first name" id="firstname"></form:input>
				<form:errors path="firstname" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="lastname" class="col-md-2 control-label">Last Name: </form:label>
			<div class="col-md-5">
				<form:input path="lastname" class="form-control" type="text" name="year"
					placeholder="Enter your last name" id="lastname"></form:input>
				<form:errors path="lastname" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="phone" class="col-md-2 control-label"> Phone number: </form:label>
			<div class="col-md-5">
				<form:input path="phone" class="form-control" type="text"
					name="phone" placeholder="Enter your phone number" id="phone"></form:input>
				<form:errors path="phone" cssClass="text-warning" />
			</div>
		</fieldset>




		<input class="btn btn-success" type="submit" value="Register" />
	</form:form>

</div>

<%@ include file="common/footer.jspf"%>