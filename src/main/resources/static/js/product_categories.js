$(document).ready(function() {
    const apiUrl = 'http://localhost:8080/api/categories';

    function populateDropdown(data) {
        const dropdown = $('#categoryDropdown');

        console.log('Data from API:', data);
        console.log('Number of categories:', data.length);

        data.forEach(category => {
            dropdown.append(`<option value="${category.id}">${category.categoryName}</option>`);
        });
    }

    $.ajax({
        url: apiUrl,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log('API Request Successful.');
            populateDropdown(data);
        },
        error: function(error) {
            console.error('Error fetching data:', error);
        }
    });

    // Handle selection change
    $('#categoryDropdown').change(function() {
        const selectedCategoryId = $(this).val();
        const selectedCategoryName = $(this).find(':selected').text();
        console.log(`Selected Category ID: ${selectedCategoryId}, Name: ${selectedCategoryName}`);
    });
});