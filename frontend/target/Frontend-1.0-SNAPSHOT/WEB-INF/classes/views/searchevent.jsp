<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<h1>Search Events</h1>

	<form:form method="post" commandName="event">
		<form:hidden path="eventId" />

		<fieldset class="form-group">
			<label class="col-md-1 control-label">Sport: </label>
			<div class="col-md-5">
				<select class="form-control" id="type" name="type"
					required="required">
					<option value="NONE" label="--- Select ---" />
					<option>unrestricted</option>
					<option>Basketball</option>
					<option>Volleyball</option>
					<option>Badminton</option>
					<option>Soccer</option>
					<option>Tennis</option>
				</select>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-md-1 control-label">Date: </label>
			<div class="col-md-5">
				<div class="input-group">
					<input class="form-control" id="date" name='date' placeholder="MM/DD/YYYY"
						type="text" />
					<div class="input-group-addon">
						<i class="fa fa-calendar"> </i>
					</div>
				</div>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-md-1 control-label">From: </label>
			<div class="col-md-5">
				<select class="form-control" id="time1" name="time1"
					required="required">
					<option value="NONE" label="--- Select ---" />
					<option>unrestricted</option>
					<option>08:00</option>
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
					<option>13:00</option>
					<option>14:00</option>
					<option>15:00</option>
					<option>16:00</option>
					<option>17:00</option>
					<option>18:00</option>
					<option>19:00</option>
					<option>20:00</option>
					<option>21:00</option>
					<option>22:00</option>
				</select>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<label class="col-md-1 control-label">To: </label>
			<div class="col-md-5">
				<select class="form-control" id="time2" name="time2"
					required="required">
					<option value="NONE" label="--- Select ---" />
					<option>unrestricted</option>
					<option>08:00</option>
					<option>09:00</option>
					<option>10:00</option>
					<option>11:00</option>
					<option>12:00</option>
					<option>13:00</option>
					<option>14:00</option>
					<option>15:00</option>
					<option>16:00</option>
					<option>17:00</option>
					<option>18:00</option>
					<option>19:00</option>
					<option>20:00</option>
					<option>21:00</option>
					<option>22:00</option>
				</select>
			</div>
		</fieldset>

		<input class="btn btn-success" type="submit" value="Search" />
	</form:form>

</div>

<%@ include file="common/footer.jspf"%>


<script>
	$(document).ready(
			function() {
				var date_input = $('#date'); //our date input has the name "date"
				var container = $('.bootstrap-iso form').length > 0 ? $(
						'.bootstrap-iso form').parent() : "body";
				date_input.datepicker({
					format : 'mm/dd/yyyy',
					container : container,
					orientation : "right top",
					todayHighlight : true,
					autoclose : true
				})
			});
</script>