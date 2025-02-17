<!DOCTYPE HTML>

<html class="no-js h-100" lang="en" xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org">
<head>
<title>Show All Records</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />






<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css" />
<link rel="stylesheet"
	href="https://cdn.datatables.net/buttons/1.6.5/css/buttons.dataTables.min.css" />
<!-- <link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"/> 
 -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/r/dt/jq-2.1.4,jszip-2.5.0,pdfmake-0.1.18,dt-1.10.9,af-2.0.0,b-1.0.3,b-colvis-1.0.3,b-html5-1.0.3,b-print-1.0.3,se-1.0.1/datatables.min.css" />
<script type="text/javascript"
	src="https://cdn.datatables.net/r/dt/jq-2.1.4,jszip-2.5.0,pdfmake-0.1.18,dt-1.10.9,af-2.0.0,b-1.0.3,b-colvis-1.0.3,b-html5-1.0.3,b-print-1.0.3,se-1.0.1/datatables.min.js"></script>


<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.6.5/js/dataTables.buttons.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.html5.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/buttons/1.6.5/js/buttons.print.min.js"></script>

<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
<!-- <style>
table, td, th {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 100%;
}


th {
	 height: 2px;
       line-height: 2px;
}
</style> -->
<script src="/js/ShowData.js"></script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" style="color: red" id="task" th:href="@{/}">TASK</a>
			</div>
			<ul class="nav navbar-nav">
				<li id="homeli" class="active"><a id="home" th:href="@{/}">Home</a></li>
				<li id="showDtli"><a id="showDt" th:href="@{/ShowNextPage}">View
						Datatable</a></li>

			</ul>
		</div>
	</nav>



	<div class="container">
		<div class="row">
			<div class="offset-4">
				<h3 style="color: blue">View All Records Here</h3>
			</div>
		</div>

		<div class="row">
			<div class="col-md-6 offset-3">
				 
				<table id="tableEmps" class="table table-bordered table-md" cellspacing="0" >
					<thead>
						<tr>
							<th class="check"><input type="checkbox" id="flowcheckall"
								value="">&nbsp;</input></th>
							<th>Customer Id</th>
							<th>Customer Firstname</th>
							<th>Customer Lastname</th>
							<th>Update Record</th>
							<th>Delete Record</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>

				<div>
					<button id="ExportReporttoCsvs" type="button" class="btn btn-primary">Export Report to CSV</button>
				</div>
			</div>

		</div>
	</div>

	<div class="modal fade" id="myModal" role="dialog">
		<div class="modal-dialog">

			<!-- Modal content-->
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">&times;</button>
					<h4 class="modal-title">Update Customer</h4>
				</div>
				<div class="modal-body">
				
				<label>Employee Id:</label>   <input type="text" class="form-control" id="Cid"
						placeholder="Employee id" /> 
					<label>First name:</label>   <input type="text" class="form-control" id="Fname"
						placeholder="Enter FirstName" /> 
					<label>Last name:</label>  <input type="text"
						class="form-control" id="Lname" placeholder="Enter FirstName" />
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" id="Umodal"
						data-dismiss="modal">Update and Close</button>
				</div>
			</div>

		</div>
	</div>




</body>
</html>