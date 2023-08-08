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
            axios.post('/api/v1/auth/authenticate', loginData, { headers, withCredentials: true })
                .then(response => {
                    const data = response.data;
                    console.log('Content data:', data);
                    if (data.access_token) {
                            $("#emailAddress").val("");
                            $("#password").val("");
                            window.location.href ="/index"
                    } else {
                        $().msgpopup({
                            text: "Invalid credential check your username or password!"
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
            url: "/api/user/reg_token/" + adminEmail,
            type: "GET",
            dataType: "json",
            success: function (data) {
                Vue.prototype.token = data.access_token;
            },
            error: function (xhr, status, error) {
                $().msgpopup({
                    text: 'Error: ' + error.text
                });
            }
        })
    }
});