new Vue({
    el: '#bodyDiv',
    data: {
        token: '',
        emailAdd: ''
    },
    computed: {
        hasToken() {
            return !!this.token;
        }
    },
    methods: {
        getTokenFromCookie: function() {
            const accessToken = `; ${document.cookie}`;
            console.log("token size", accessToken.length);
            this.token = accessToken.replace("accessToken=", "");
            const tokenParts = this.token.split('.');
            if (tokenParts.length === 3) {
                const payload = atob(tokenParts[1]);
                const payloadObject = JSON.parse(payload);
                this.emailAdd = payloadObject.sub.toString().trim();
                console.log('Issued At:', new Date(payloadObject.iat * 1000));
                console.log('Expiration Time:', new Date(payloadObject.exp * 1000));
                $("#emailId").text(" "+this.emailAdd);
                $("#emailIds").text(" "+this.emailAdd);
            }
        },
        getToken() {
            const cookies = document.cookie.split('; ');
            for (const cookie of cookies) {
                const [name, value] = cookie.split('=');
                if (name === 'accessToken') {
                    return value;
                }
            }
            return null;
        }
    },
    mounted() {
        this.getTokenFromCookie();
        console.log("access token: ", this.token);
        if (this.token.length > 2) {
            $('#authId').text(" Logout");
            $('#authLink').attr('href', '/api/v1/auth/logout');
            $('#authL').text(" Logout");
            $('#authLs').attr('href', '/api/v1/auth/logout');
        } else {
            $('#authId').text(" Login");
            $('#authLink').attr('href', '/sign-in');
            $('#authL').text(" Login");
            $('#authLs').attr('href', '/sign-in');
        }

        $("#navShopGrid").click(function(event) {
            event.preventDefault();
            alert("Shop Grid");
       });

        $("#butShopGrid").click(function(event) {
            event.preventDefault();
            window.location.href = '/shop-grid';
        });
    }
});
