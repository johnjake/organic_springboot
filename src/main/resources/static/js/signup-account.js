new Vue({
    el: '#signUp',
    data: {
        fname: '',
        lname: '',
        username: '',
        emailadd: '',
        userpass: '',
        rewrite: ''
    },
    methods: {

        isValidEmail(email) {
            // Define the regular expression pattern for a valid email address
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return emailPattern.test(email);
        },

        submitSignUp() {
            const email = $('#emailAddress')
            function isValidEmail(email) {
                // Define the regular expression pattern for a valid email address
                const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
                return emailPattern.test(email);
            }

            if (this.fname.trim() === '') {
                $().msgpopup({
                    text: 'First name is required!'
                });
                $('#firstName').focus();
                return;
            }

            if (this.lname.trim() === '') {
                $().msgpopup({
                    text: 'last name is required!'
                });
                $('#lastName').focus();
                return;
            }

            if (this.username.trim() === '') {
                $().msgpopup({
                    text: 'username is required!'
                });
                $('#userName').focus();
                return;
            }

            if (this.emailadd.trim() === '') {
                $().msgpopup({
                    text: 'email address is required!'
                });
                email.focus();
                return;
            }

            if (!this.isValidEmail(this.emailadd)) {
                $().msgpopup({
                    text: 'Invalid email address!'
                });
                email.focus();
                return;
            }

            if (this.userpass.trim() === '') {
                $().msgpopup({
                    text: 'password is required!'
                });
                $('#password').focus();
                return;
            }

            if (this.userpass.length <= 5) {
                $().msgpopup({
                    text: 'password does not meet the minimum required length!'
                });
                $('#password').focus();
                return;
            }

            if (this.rewrite.trim() === '') {
                $().msgpopup({
                    text: 'rewrite password is required!'
                });
                $('#rewritePassword').focus();
                return;
            }

            if (this.userpass.trim() !== this.rewrite.trim()) {
                $().msgpopup({
                    text: 'password and rewrite password does not match!'
                });
                $('#rewritePassword').focus();
                return;
            }

            const formData = {
                fname: this.fname,
                lname: this.lname,
                username: this.username,
                emailadd: this.emailadd,
                userpass: this.userpass
            };
            axios.post('http://localhost:8080/api/signup', formData)
                .then(response => {
                    $().msgpopup({
                        text: 'User for '+ this.firstName + ' ' + this.lastName + ' successfully created!'
                    });
                })
                .catch(error => {
                    $().msgpopup({
                        text: 'An error occurred during sign-up'
                    });
                });
        }
    }
});