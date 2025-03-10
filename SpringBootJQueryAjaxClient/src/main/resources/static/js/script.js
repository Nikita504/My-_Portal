$(document).ready(function () {
    // ✅ Button Click Event
    $("#showTableBtn").click(function () {
        console.log("Button Clicked!"); // ✅ Debugging Step 1

        // ✅ Check if table is visible
        if ($("#tableContainer").is(":visible")) {
            $("#tableContainer").fadeOut();  // ✅ Table Hide
            $(this).text("Show Table");      // ✅ Button Text Change
        } else {
            // ✅ AJAX Call to Fetch Data
            $.ajax({
                url: "/customer/getAllUserData",  // ✅ Spring Boot API Endpoint
                type: "GET",
                dataType: "json",
                success: function (response) {
                    console.log("Data Fetched:", response); // ✅ Debugging Step 2

                    // ✅ Clear previous table data
                    $("#dataTable tbody").empty();

                    // ✅ Append fetched data dynamically
                    response.forEach(function (user) {
                        var row = `
                            <tr>
                                <td>${user.id}</td>
                                <td>${user.firstName}</td>
                                <td>${user.lastName}</td>
                                <td>${user.city}</td>
                            </tr>
                        `;
                        $("#dataTable tbody").append(row);
                    });

                    // ✅ Show the table with a fade effect
                    $("#tableContainer").fadeIn();
                    $("#showTableBtn").text("Hide Table");  // ✅ Button Text Change
                },
                error: function (error) {
                    console.log("Error Fetching Data:", error); // ✅ Debugging Step 3
                    alert("Failed to fetch user data. Please try again.");
                }
            });
        }
    });
});
