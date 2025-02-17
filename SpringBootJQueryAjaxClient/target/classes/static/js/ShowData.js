var EmpData = [];

$(document).ready(function() {
	EmpTable = $('#tableEmps').DataTable({
	});
	$('#homeli').removeClass("active");
	$('#showDtli').addClass("active");

	$.ajax({
		type: "GET",
		url: "/customer/getAll",
		success: function(result) {

			EmpData = result;
			EmpTable.clear().draw();
			for (param = 0; param < EmpData.length; param++) {
				var rowData = [];
				rowData.push("<input type='checkbox' id =' " + param + " '></input>");
				rowData.push(EmpData[param].employeeId);
				rowData.push(EmpData[param].firstname);
				rowData.push(EmpData[param].lastname);
				rowData.push("<button class='mb-2 btn btn-primary updatebtn' id=" + EmpData[param].employeeId + " type='button' data-toggle='modal' data-target='#myModal'>Update</button>");
				rowData.push("<button class='mb-2 btn btn-danger deletebtn' id=" + EmpData[param].employeeId + " type='button'>Delete</button>");
				EmpTable.row.add(rowData);
			}
			EmpTable.columns.adjust().draw();

		}
	});
	$('#tableEmps').on('click', 'tbody .updatebtn', function() {
		var data_row = EmpTable.row($(this).closest('tr')).index();
		$("#Cid").val(this.id);
		
		$("#Fname").val(EmpData[data_row].firstname);
		$("#Lname").val(EmpData[data_row].lastname);
		$('#myModal').toggle();
	});
	

	$('#Umodal').on('click', function() {

		var updatedData = {
			employeeId: $("#Cid").val(),
			firstname: $("#Fname").val(),
			lastname: $("#Lname").val()
		}

		$.ajax({
			type: "POST",
			contentType: "application/json",
			data: JSON.stringify(updatedData),
			dataType: 'json',
			url: "/customer/update",
			success: function(result) {
				if (result == true) {
					location.reload();
				}

			}
		});
	});

	$('#tableEmps').on('click', 'tbody .deletebtn', function() {


		if (confirm('Are you sure ?')) {
			var customer = {
				employeeId: this.id
			}
			$.ajax({
				type: "POST",
				contentType: "application/json",
				data: JSON.stringify(customer),
				dataType: 'json',
				url: "/customer/delete",
				success: function(result) {

					location.reload();
				}
			});
		}


	});

	$("#flowcheckall").click(function() {
		if (this.checked) {
			$('#tableEmps tbody input[type="checkbox"]').attr('checked', true);
		} else {
			$('#tableEmps tbody input[type="checkbox"]').attr('checked', false);
		}
	});

	$("#ExportReporttoCsvs").on("click", function() {
		var filename = "Employee.csv"
		var csv = [];
		var cols = [];
		$('#tableEmps tbody tr').each(function(row, tr) {
			if (($(tr).find('td:eq(0)').children().prop("checked"))) {
				cols[row] = {
					"employeeId": $(tr).find('td:eq(1)').children().val() == undefined ? $(tr).find('td:eq(1)')[0].innerHTML : $(tr).find('td:eq(1)').children().val(),
					"firstname": $(tr).find('td:eq(2)').children().val() == undefined ? $(tr).find('td:eq(2)')[0].innerHTML : $(tr).find('td:eq(2)').children().val(),
					"lastname": $(tr).find('td:eq(3)').children().val() == undefined ? $(tr).find('td:eq(3)')[0].innerHTML : $(tr).find('td:eq(3)').children().val(),
				}
			}
		})
		for (indx in cols) {
			var result = [];
			result.push(cols[indx].firstname);
			result.push(cols[indx].lastname);
			csv.push(result.join(','));
		}
		downloadCSV(csv.join("\n"), filename);
	});

	function downloadCSV(csv, filename) {
		var csvFile;
		var downloadLink;
		csvFile = new Blob([csv], { type: "text/csv" });
		downloadLink = document.createElement("a");
		downloadLink.download = filename;
		downloadLink.href = window.URL.createObjectURL(csvFile);
		downloadLink.style.display = "none";
		document.body.appendChild(downloadLink);
		downloadLink.click();
	}
});
