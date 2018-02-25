<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en" ng-app="myModule">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link href="<c:url value='/static/css/font-awesome.css' />"
	rel="stylesheet"></link>
<script src="<c:url value='/static/js/employees_controller.js' />"></script>
<script src="<c:url value='/static/js/dirPagination.js' />"></script>
<style>
.pageLinks {
	padding: 5px;
	border: 1px solid #c3c3c3;
	margin-left: 2px;
}
</style>
</head>

<body>
	<div class="container" ng-controller="myController">
		<table class="table table-striped table-condensed table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Role</th>
					<th>Skillset</th>
					<th>Image</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><input type="text" ng-model="search.name"
						class="form-control" /></td>
					<td><input type="text" ng-model="search.role"
						class="form-control" /></td>
					<td><input type="text" ng-model="search.skillset"
						class="form-control" /></td>
					<td></td>
				</tr>
				<tr
					dir-paginate="item in employees | filter:search  |  itemsPerPage: 5">
					<td style="vertical-align: middle">{{item.name}}</td>
					<td style="vertical-align: middle">{{item.role}}</td>
					<td style="vertical-align: middle">{{item.skillset}}</td>
					<td><img ng-src="{{item.profileImageURL}}"
						alt="profile picture" class="img-responsive" style="width: 150px"></td>
				</tr>
			</tbody>
		</table>
		<div align="center">
			<dir-pagination-controls boundary-links="true"
				on-page-change="pageChangeHandler(newPageNumber)"
				template-url="<c:url value='/static/html/dirPagination.tpl.html' />"></dir-pagination-controls>
		</div>
	</div>
</body>
</html>
