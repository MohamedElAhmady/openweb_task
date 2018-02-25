<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html ng-app="myModule">

<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.min.js"></script>
<link href="<c:url value='/static/css/bootstrap.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/bootstrap.no-icons.min.css' />"
	rel="stylesheet"></link>
<link href="<c:url value='/static/css/font-awesome.css' />"
	rel="stylesheet"></link>
<script src="<c:url value='/static/js/employees_controller.js' />"></script>
<script src="<c:url value='/static/js/dirPagination.js' />"></script>
</head>

<body>
	<div ng-controller="myController">
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
					<td><input type="text" ng-model="search.name" /></td>
					<td><input type="text" ng-model="search.role" /></td>
					<td><input type="text" ng-model="search.skillset" /></td>
					<td></td>
				</tr>
				<tr
					dir-paginate="item in employees | filter:search  |  itemsPerPage: 5">
					<td>{{item.name}}</td>
					<td>{{item.role}}</td>
					<td>{{item.skillset}}</td>
					<td><img ng-src="{{item.profileImageURL}}" alt="profile picture" class="image"></td>
				</tr>
			</tbody>
		</table>
		<div class="text-center">
			<dir-pagination-controls boundary-links="true"
				on-page-change="pageChangeHandler(newPageNumber)"
				template-url="<c:url value='/static/html/dirPagination.tpl.html' />"></dir-pagination-controls>
		</div>
	</div>
</body>
</html>
