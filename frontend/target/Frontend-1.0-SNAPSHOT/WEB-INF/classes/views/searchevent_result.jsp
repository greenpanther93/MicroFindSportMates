<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<table class="table table-striped">
		<caption>Results are</caption>
		<thead>
			<tr>
				<th>Sport</th>
				<th>Date</th>
				<th>Time</th>
				<th>Place</th>
				<th>Host</th>
				<th></th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${events }" var="event" varStatus="status">
				<tr>
					<td>${event.eventType}</td>
					<td>${event.eventDate}</td>
					<td>${event.eventTime}</td>
					<td>${event.eventPlace}</td>
					<td>${hosts[status.index]}</td>
					<td> 
						<a class="btn btn-primary" href="/">Join</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf"%>