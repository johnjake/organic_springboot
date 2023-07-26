new Vue({
    el: '#signUp',
    data: {
        firstName: '',
        lastName: '',
        userName: '',
        emailAdd: '',
        userPass: '',
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

            if (this.firstName.trim() === '') {
                $().msgpopup({
                    text: 'First name is required!'
                });
                $('#firstName').focus();
                return;
            }

            if (this.lastName.trim() === '') {
                $().msgpopup({
                    text: 'last name is required!'
                });
                $('#lastName').focus();
                return;
            }

            if (this.userName.trim() === '') {
                $().msgpopup({
                    text: 'username is required!'
                });
                $('#userName').focus();
                return;
            }

            if (this.emailAdd.trim() === '') {
                $().msgpopup({
                    text: 'email address is required!'
                });
                email.focus();
                return;
            }

            if (!this.isValidEmail(this.emailAdd)) {
                $().msgpopup({
                    text: 'Invalid email address!'
                });
                email.focus();
                return;
            }

            if (this.userPass.trim() === '') {
                $().msgpopup({
                    text: 'password is required!'
                });
                $('#password').focus();
                return;
            }

            if (this.userPass.length <= 5) {
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

            if (this.userPass.trim() !== this.rewrite.trim()) {
                $().msgpopup({
                    text: 'password and rewrite password does not match!'
                });
                $('#rewritePassword').focus();
                return;
            }

            const formData = {
                firstName: this.firstName.trim(),
                lastName: this.lastName.trim(),
                userName: this.userName.trim(),
                emailAdd: this.emailAdd.trim(),
                userPass: this.userPass.trim()
            };
            axios.post('http://localhost:8080/api/user/register', formData)
                .then(response => {
                    if (response.data === -1) {
                        $().msgpopup({
                            text: 'username already exist!'
                        });
                    } else if (response.data === -2) {
                        $().msgpopup({
                            text: 'email address already exist!'
                        });
                    } else {
                        $().msgpopup({
                            text: 'User for ' + this.firstName.trim() + ' ' + this.lastName.trim() + ' successfully created!'
                        });
                    }
                })
                .catch(error => {
                    $().msgpopup({
                        text: 'An error occurred during sign-up'
                    });
                });
        }
    }
});