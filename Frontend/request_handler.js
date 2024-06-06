async function makeApiRequest(method, endpoint, body = null) {
    const options = {
        method: method,
        headers: {
            'Content-Type': 'application/json'
        },
    };

    if (body) {
        options.body = JSON.stringify(body);
    }

    let url = `http://localhost:8080${endpoint}`;
    try {
        const response = await fetch(url, options);
        if (!response.ok) {
            throw new Error(`HTTP error! Status: ${response.status}`);
        }
        const data = await response.json();
        return data;
    } catch (error) {
        console.error('Error:', error);
        throw error;
    }
}

//LOGIN
document.addEventListener('DOMContentLoaded', () => {
    const loginForm = document.getElementById('loginForm');
    if (loginForm) {
        loginForm.addEventListener('submit', async (event) => {
            event.preventDefault();

            const loginUsername = document.getElementById('user').value;
            const loginPassword = document.getElementById('password').value;

            console.log('Username:', loginUsername);
            console.log('Password:', loginPassword);

            try {
                const response = await makeApiRequest('POST', '/users/login', {
                    "name": loginUsername,
                    "password": loginPassword
                });
                console.log('Login Response:', response);
                window.location.href='../shop_page/storehage.html';
            } catch (error) {
                console.error('Login Error:', error);

            }
        });
    }
});

//REGISTER
document.addEventListener('DOMContentLoaded', () => {
    const signupForm = document.getElementById('signupForm');
    if (signupForm) {
        signupForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            var adminCheckbox = document.getElementById("adminCheckbox");

            
            var isAdmin = adminCheckbox.checked;
            const registerUsername = document.getElementById('user').value;
            const registerPassword = document.getElementById('password').value;
            const registerRepeatPassword = document.getElementById('repeat-password').value;

            console.log('Username:', registerUsername);
            console.log('Password:', registerPassword);
            console.log('Repeat Password:', registerRepeatPassword);

            if (registerPassword !== registerRepeatPassword) {
                console.error('Passwords do not match');
                return;
            }

            try {
                const response = await makeApiRequest('POST', '/users', {
                    "name":registerUsername,
                    "admin":isAdmin,
                    "password":registerPassword
                });
                console.log('Signup Response:', response);
                window.location.href='../shop_page/storehage.html';
            } catch (error) {
                console.error('Signup Error:', error);
            }
        });
    }
});
