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
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return emailPattern.test(email);
        },

        submitSignUp() {
            const email = $('#emailAddress')
            function isValidEmail(email) {
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
            const msgUsername = 'username already exist!'
            const msgEmailAdd = 'email address already exist!'
            const msgErrorSign = 'An error occurred during sign-up'
            const formData = {
                firstname: this.firstName.trim(),
                lastname: this.lastName.trim(),
                email: this.emailAdd.trim(),
                password: this.userPass.trim(),
                role: "ADMIN"
            };
            const accessToken = Vue.prototype.token;
            const headers = {
                'Authorization': `Bearer ${accessToken}`,
                'Content-Type': 'application/json'
            };
            axios.post('http://localhost:8080/api/v1/auth/register', formData, { headers })
                .then(response => {
                    if (response.toString().length > 0) {
                        $().msgpopup({
                            text: "Account successfully created"
                        });
                    } else {
                        $().msgpopup({
                            text: "Account not created: error occurred during sign-up"
                        });
                    }
                })
                .catch(error => {
                    $().msgpopup({
                        text: msgErrorSign
                    });
                });
        }
    },
    mounted() {
        const adminEmail = "admin@mail.com";
        $.ajax({
            url: "http://localhost:8080/api/user/reg_token/" + adminEmail,
            type: "GET",
            dataType: "json",
            success: function (data) {
                Vue.prototype.token = data.access_token;
                console.log(data.access_token);
            },
            error: function (xhr, status, error) {
                $().msgpopup({
                    text: 'Error: ' + error.text
                });
            }
        })
    }
});