<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>


<div class="container">
	<h1>Add a Event</h1>

	<form:form name="myForm" method="post" commandName="event">
		<form:hidden path="eventId" />

		<fieldset class="form-group">
			<form:label path="eventType" class="col-md-1 control-label">Sport: </form:label>
			<div class="col-md-5">
				<form:select path="eventType" class="form-control" id="type"
					required="required" onChange="showCourt(this.selectedIndex);">
					<option value="NONE" label="--- Select ---" />
					<option value="basketball">Basketball</option>
					<option value="volleyball">Volleyball</option>
					<option value="badminton">Badminton</option>
					<option value="soccer">Soccer</option>
					<option value="tennis">Tennis</option>
				</form:select>
				<form:errors path="eventType" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="eventDate" class="col-md-1 control-label">Date: </form:label>
			<div class="col-md-5">
				<div class="input-group">
					<form:input class="form-control" id="date" name="date"
						placeholder="MM/DD/YYYY" type="text" path="eventDate"/>
					<div class="input-group-addon">
						<i class="fa fa-calendar"> </i>
					</div>
				</div>
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="eventTime" class="col-md-1 control-label">Time: </form:label>
			<div class="col-md-5">
				<form:select path="eventTime" class="form-control" id="time"
					required="required">
					<option value="NONE" label="--- Select ---" />
					<option>08:00-10:00</option>
					<option>10:00-12:00</option>
					<option>13:00-15:00</option>
					<option>15:00-17:00</option>
					<option>17:00-19:00</option>
					<option>19:00-21:00</option>
				</form:select>
				<form:errors path="eventTime" cssClass="text-warning" />
			</div>
		</fieldset>

		<fieldset class="form-group">
			<form:label path="eventPlace" class="col-md-1 control-label">Place: </form:label>
			<div class="col-md-5">
				<form:select path="eventPlace" class="form-control" id="place"
					required="required">
					<option value="" label="--- Select ---" />
				</form:select>
				<form:errors path="eventPlace" cssClass="text-warning" />
			</div>
		</fieldset>
		<input class="btn btn-success" type="submit" value="Submit" />
	</form:form>

</div>

<%@ include file="common/footer.jspf"%>


<script>
	$(document).ready(
			function() {
				var date_input = $('input[name="eventDate"]'); //our date input has the name "date"
				var container = $('.bootstrap-iso form').length > 0 ? $(
						'.bootstrap-iso form').parent() : "body";
				date_input.datepicker({
					format : 'mm/dd/yyyy',
					container : container,
					orientation: "right top",
					todayHighlight : true,
					autoclose : true
				})
			});
			
</script>

<script>
	court = new Array();
	court[0] = ["Basketball Court 1", "Basketball Court 2", "Basketball Court 3", "Basketball Court 4", "Basketball Court 5"];
	court[1] = ["Volleyball Court 1", "Volleyball Court 2"];
	court[2] = ["Badminton Court 1", "Badminton Court 2", "Badminton Court 3"];
	court[3] = ["Soccer Feild"];
	court[4] = ["Tennis Court 1", "Tennis Court 2", "Tennis Court 3"];
	function showCourt(index) {
		var place = document.getElementById('place');
		for(var i = 0; i<court[index-1].length; i++) {
			place.options[i] = new Option(court[index-1][i], court[index-1][i]);
			}
		place.length = court[index-1].length;
		}
</script>
