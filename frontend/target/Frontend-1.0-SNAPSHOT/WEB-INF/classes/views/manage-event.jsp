<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Events are</caption>
		<thead>
			<tr>
				<th>Sport</th>
				<th>Date</th>
				<th>Time</th>
				<th>Place</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${events }" var="event">
				<tr>
					<td>${event.eventType}</td>
					<td>${event.eventDate}</td>
					<td>${event.eventTime}</td>
					<td>${event.eventPlace}</td>
					<td> <!--<a class="btn btn-success" href="/edit/${event.eventId}">Update</a>-->
						<a class="btn btn-danger" href="/remove/${event.eventId}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>