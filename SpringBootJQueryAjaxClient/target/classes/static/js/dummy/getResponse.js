$(document).ready(function() {

	// GET REQUEST
	$("#getAllCustomerId").click(function(event) {
		event.preventDefault();
		ajaxCall1();
	});

	$("#ShowData").click(function() {
	})

	function ajaxCall1() {
		$.ajax({
			type: "GET",
			url: window.location + "api/customer/all",
			success: function(result) {
				 
				ajaxCall2(result);
			}
		});
	}

	function ajaxCall2(result) {
		  
		
		$.ajax({
			type: "POST",
			contentType: "application/json",
			url: window.location + "postData",
			data : JSON.stringify({cust: result}),
			success: function(resp) {
				if(resp!=false)
				 window.location =  "ShowNextPage";
				/*ajaxCall3(resp);*/
			}
		});
	}



	function ajaxCall3(resp) {
		$.ajax({
			type: "GET",
			url: window.location + "ShowNextPage",
			success: function() {
			}
		});
	}
});