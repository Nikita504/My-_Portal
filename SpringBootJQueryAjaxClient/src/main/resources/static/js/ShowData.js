var EmpData = [];

$(document).ready(function() {
    EmpTable = $('#tableEmps').DataTable({});

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
                rowData.push("<input type='checkbox' id='" + param + "'></input>");
                rowData.push(EmpData[param].id);
                rowData.push(EmpData[param].firstname);
                rowData.push(EmpData[param].lastname);
                rowData.push(EmpData[param].email); // Added email field
                rowData.push("<button class='mb-2 btn btn-primary updatebtn' id=" + EmpData[param].id + " type='button' data-toggle='modal' data-target='#myModal'>Update</button>");
                rowData.push("<button class='mb-2 btn btn-danger deletebtn' id=" + EmpData[param].id + " type='button'>Delete</button>");
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
        $("#Email").val(EmpData[data_row].email); // Added email field
        $('#myModal').toggle();
    });

    $('#Umodal').on('click', function() {
        var updatedData = {
            id: $("#Cid").val(),
            firstname: $("#Fname").val(),
            lastname: $("#Lname").val(),
            email: $("#Email").val() // Added email field
        }

        $.ajax({
            type: "POST",
            contentType: "application/json",
            data: JSON.stringify(updatedData),
            dataType: 'json',
            url: "/customer/update",
            success: function(result) {
                if (result && result.id != null) { 
                    location.reload();
                } else {
                    alert("Customer ID is missing. Update failed.");
                }
            }
        });
    });

    $('#tableEmps').on('click', 'tbody .deletebtn', function() {
        if (confirm('Are you sure?')) {
            var customer = { id: parseInt(this.id) || null };
            console.log("Deleting customer with ID:", this.id);
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
        $('#tableEmps tbody input[type="checkbox"]').prop('checked', this.checked);
    });

    $("#ExportReporttoCsvs").on("click", function() {
        var filename = "Employee.csv";
        var csv = [];
        var cols = [];
        $('#tableEmps tbody tr').each(function(row, tr) {
            if ($(tr).find('td:eq(0)').children().prop("checked")) {
                cols[row] = {
                    "employeeId": $(tr).find('td:eq(1)').text(),
                    "firstname": $(tr).find('td:eq(2)').text(),
                    "lastname": $(tr).find('td:eq(3)').text(),
                    "email": $(tr).find('td:eq(4)').text() // Added email field
                }
            }
        });
        for (indx in cols) {
            var result = [];
            result.push(cols[indx].firstname);
            result.push(cols[indx].lastname);
            result.push(cols[indx].email); // Added email field
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
