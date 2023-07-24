new Vue({
    el: '#app',
    data: {
        firstName: '',
        lastName: '',
        frmCountry: '',
        address: '',
        town: '',
        state: '',
        zip: '',
        phone: '',
        email: '',
        shipping: '',
        userid: ''
    },
    methods: {
        handleSubmit() {
            if (this.firstName.trim() === '') {
                $().msgpopup({
                    text: 'First name is required!'
                });
                return;
            }

            if (this.lastName.trim() === '') {
                $().msgpopup({
                    text: 'last name is required!'
                });
                return;
            }

            if (this.country.trim() === '') {
                $().msgpopup({
                    text: 'Country is required!'
                });
                return;
            }

            if (this.address.trim() === '') {
                $().msgpopup({
                    text: 'Address is required!'
                });
                return;
            }

            if (this.town.trim() === '') {
                $().msgpopup({
                    text: 'Town address is required!'
                });
                return;
            }

            if (this.state.trim() === '') {
                $().msgpopup({
                    text: 'State address is required!'
                });
                return;
            }

            if (this.zip.trim() === '') {
                $().msgpopup({
                    text: 'Zip code is required!'
                });
                return;
            }

            if (this.shipping.trim() === '') {
                $().msgpopup({
                    text: 'shipped to address is required!'
                });
                return;
            }

            if (this.userid.trim() === '') {
                $().msgpopup({
                    text: 'User Id is required!'
                });
                return;
            }

            const useridNumber = parseInt(this.userid.trim(), 10);
            const zipNumber = parseInt(this.zip.trim(), 10);
            const shipNumber = parseInt(this.shipping.trim(), 10);
            // Create an object to represent the data you want to send in the request
            const formData = {
                firstName: this.firstName.trim(),
                lastName: this.lastName.trim(),
                country: this.frmCountry.trim(),
                address: this.address.trim(),
                town: this.town.trim(),
                state: this.state.trim(),
                zip: zipNumber,
                phone: this.phone.trim(),
                email: this.email.trim(),
                shipping: shipNumber,
                userid: useridNumber
            };
            axios.post('http://localhost:8080/api/billing', formData)
                .then(response => {
                    $().msgpopup({
                        text: 'Billing for '+ this.firstName + ' ' + this.lastName + ' successfully added!'
                    });
                })
                .catch(error => {
                    $().msgpopup({
                        text: 'An error occurred upon adding billing details'
                    });
                });
        }
    }
});