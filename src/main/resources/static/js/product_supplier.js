$(document).ready(function() {
    const apiUrl = 'http://localhost:8080/api/supplier/name';

    function supplierDropdown(data) {
        const dropdown = $('#supplierDropdown');

        console.log('Data from API:', data);
        console.log('Number of supplier:', data.length);

        data.forEach( supplier => {
            dropdown.append(`<option value="${supplier.id}">${supplier.supplierName}</option>`);
        });
    }

    $.ajax({
        url: apiUrl,
        method: 'GET',
        dataType: 'json',
        success: function(data) {
            console.log('API Request Successful.');
            supplierDropdown(data);
        },
        error: function(error) {
            console.error('Error fetching data:', error);
        }
    });
    // Handle selection change
    $('#supplierDropdown').change(function() {
        const selectedSupplierId = $(this).val();
        const selectedSupplierName = $(this).find(':selected').text();
        console.log(`Selected Category ID: ${selectedSupplierId}, Name: ${selectedSupplierName}`);
    });
});