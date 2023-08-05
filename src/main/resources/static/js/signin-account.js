new Vue({
    el: '#signIn',
    data: {
        userAddress: '',
        userPassword: ''
    },
    methods: {
        isValidEmail(email) {
            const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
            return emailPattern.test(email);
        },
        onSignIn() {
            const email = $('#emailAddress')

            if (this.userAddress.trim() === '') {
                $().msgpopup({
                    text: 'email address is required!'
                });
                email.focus();
                return;
            }

            if (this.userPassword.trim() === '') {
                $().msgpopup({
                    text: 'password is required!'
                });
                $('#password').focus();
                return;
            }

            if (!this.isValidEmail(this.userAddress)) {
                $().msgpopup({
                    text: 'Invalid email address!'
                });
                email.focus();
                return;
            }
            const loginData = {
                email: this.userAddress.trim(),
                password: this.userPassword.trim()
            };
            const accessToken = Vue.prototype.token;
            const headers = {
                'Authorization': `Bearer ${accessToken}`,
                'Content-Type': 'application/json'
            };
            axios.post('http://localhost:8080/api/v1/auth/authenticate', loginData, { headers })
                .then(response => {
                    if (response.toString().length > 0) {
                        $("#emailAddress").val("");
                        $("#password").val("");
                        window.location.href = "index";
                    } else {
                        $().msgpopup({
                            text: "Login successfully"
                        });
                    }
                })
                .catch(error => {
                    $().msgpopup({
                        text: "Invalid username or password!"
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