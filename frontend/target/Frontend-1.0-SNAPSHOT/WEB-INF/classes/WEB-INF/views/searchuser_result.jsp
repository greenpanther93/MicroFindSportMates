<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>User is</caption>
		<thead>
			<tr>
				<th>User Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Phone</th>
				<th>Role</th>
			</tr>
		</thead>

		<tbody>
				<tr>
					<td>${user.username}</td>
					<td>${user.firstname}</td>
					<td>${user.lastname}</td>
					<td>${user.phone}</td>
					<td>${user.role}</td>
				</tr>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>