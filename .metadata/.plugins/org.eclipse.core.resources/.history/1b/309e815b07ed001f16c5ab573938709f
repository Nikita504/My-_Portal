<!DOCTYPE html>
<html class="no-js h-100" lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org">
<head>
  <title>Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
 
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
<script src="/js/index.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" style="color: red" id="task" th:href="@{/}">TASK</a>
    </div>
    <ul class="nav navbar-nav">
      <li  id="homeli" class="active"><a id="home" th:href="@{/}">Home</a></li>
      <li id="showDtli"><a id="showDt" th:href="@{/ShowNextPage}">View Datatable</a></li>
       
    </ul>
  </div>
</nav>
  
<div class="container">
		<div class="row">
			<div class="col-8">
				<h3 style="color: blue">Please fill the firstname and lastname</h3>
				<div>
					<form class="form-inline" style="margin: 20px 20px 20px 20px"
						id="customerForm">
						<div class="form-group">
							<label for="firstname" style="margin-right: 5px">FirstName:</label>
							<input type="text" class="form-control" id="firstname"
								placeholder="Enter FirstName" />
						</div>
						<div class="form-group">
							<label for="lastname"
								style="margin-left: 20px; margin-right: 5px">LastName:</label> <input
								type="text" class="form-control" id="lastname"
								placeholder="Enter LastName" />
						</div>
						<button type="submit" class="btn btn-default"
							style="margin-left: 20px; margin-right: 5px">Submit</button>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>