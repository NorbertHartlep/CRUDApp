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

// LOGIN
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
                    name: loginUsername,
                    password: loginPassword
                });
                console.log('Login Response:', response);
                window.location.href = '../shop_page/storehage.html';
            } catch (error) {
                console.error('Login Error:', error);
            }
        });
    }
});

// REGISTER
document.addEventListener('DOMContentLoaded', () => {
    const signupForm = document.getElementById('signupForm');
    if (signupForm) {
        signupForm.addEventListener('submit', async (event) => {
            event.preventDefault();
            const adminCheckbox = document.getElementById("adminCheckbox");
            const isAdmin = adminCheckbox.checked;
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
                    name: registerUsername,
                    admin: isAdmin,
                    password: registerPassword
                });
                console.log('Signup Response:', response);
                window.location.href = '../shop_page/storehage.html';
            } catch (error) {
                console.error('Signup Error:', error);
            }
        });
    }
});

// SPRECYZOWANE REQUESTY
async function getMotherboards(method, body) {
    return await makeApiRequest(method, '/motherboards', body );
}

async function getGpus(method, body) {
    return await makeApiRequest(method, '/gpus', body );
}

async function getCpus(method, body) {
    return await makeApiRequest(method, '/cpus', body );
}

async function getRams(method, body) {
    return await makeApiRequest(method, '/rams', body);
}

async function getLaptops(method, body) {
    return await makeApiRequest(method, '/laptops', body);
}

async function getComputers(method, body) {
    return await makeApiRequest(method, '/computers', body);
}



// PRZYCISKI ODPOWIADAJACE ZA WYSWIETLANIE KONKRETNEJ KATEGORII
document.getElementById('btn-laptops').addEventListener('click', async () => {
    const products = await getLaptops('GET');
    console.log(products);
});

document.getElementById('btn-computers').addEventListener('click', async () => {
    const products = await getComputers('GET');
    console.log(products);

});

document.getElementById('btn-motherboards').addEventListener('click', async () => {
    const products = await getMotherboards('GET');
    console.log(products);

});

document.getElementById('btn-gpus').addEventListener('click', async () => {
    const products = await getGpus('GET');
    console.log(products);

});

document.getElementById('btn-rams').addEventListener('click', async () => {
    const products = await getRams('GET');
    console.log(products);

});

document.getElementById('btn-cpus').addEventListener('click', async () => {
    const products = await getCpus('GET');
    console.log(products);

});

// PRZYCISKI DO DODAWANIA KONKRETNYCH ITEMOW
document.getElementById('laptop-adder').addEventListener('click', async () => {
    let nameLaptops = document.getElementById('name-laptops').value;
    let descriptionLaptops = document.getElementById('description-laptops').value;
    let cpuLaptops = document.getElementById('cpu-laptops').value;
    let gpuLaptops = document.getElementById('gpu-laptops').value;
    let priceLaptops = document.getElementById('price-laptops').value;

    let products = await getLaptops('POST', {
        "name": nameLaptops,
        "description": descriptionLaptops,
        "cpu": cpuLaptops,
        "gpu": gpuLaptops
    });
    console.log(products);

});

document.getElementById('computer-adder').addEventListener('click', async () => {
    let name = document.getElementById('name-computers').value;
    let description = document.getElementById('description-computers').value;
    let cpu = document.getElementById('cpu-computers').value;
    let gpu = document.getElementById('gpu-computers').value;
    let products = await getComputers('POST', {
        "name": name,
        "description": description,
        "cpu": cpu,
        "gpu": gpu
    });  
      console.log(products);

});

document.getElementById('motherboard-adder').addEventListener('click', async () => {
    let motherboardName = document.getElementById('name-motherboards').value;
    let motherboardDescription = document.getElementById('description-motherboards').value;
    let availablePorts = ["test port1", "test port 2"];
    let products = await getMotherboards('POST', {
        "name":motherboardName,
        "description":motherboardDescription,
        "availablePorts":availablePorts
    });
    console.log(products);

});

document.getElementById('gpu-adder').addEventListener('click', async () => {
    let gpuName = document.getElementById('name-gpus').value;
    let gpuDesc = document.getElementById('description-gpus').value;
    let gpuFrequency = document.getElementById('frequency-gpus').value;
    gpuFrequency = parseInt(gpuFrequency);
    console.log(gpuFrequency);

    if (isNaN(gpuFrequency)) {
        gpuFrequency = 0;
    }

    let products = await getGpus('POST', {
        "name":gpuName,
        "description":gpuDesc,
        "frequency":gpuFrequency
    });
    console.log(products);

});

document.getElementById('ram-adder').addEventListener('click', async () => {
    let ramName = document.getElementById('name-rams').value;
    let ramDesc = document.getElementById('description-rams').value;
    let ramFrequency = document.getElementById('frequency-rams').value;
    let ramPrice = document.getElementById('price-rams').value;
    ramFrequency = parseInt(ramFrequency);
    ramPrice = parseInt(ramPrice);
    console.log(ramFrequency);

    if (isNaN(ramFrequency)) {
        ramFrequency = 0;
    }
    if (isNaN(ramPrice)) {
        ramPrice = 0;
    }
    let products = await getRams('POST', {
        "name":ramName,
        "description":ramDesc,
        "frequency":ramFrequency,
        "price":ramPrice
    });
    console.log(products);

});

document.getElementById('cpu-adder').addEventListener('click', async () => {
    let nameCpus = document.getElementById('name-cpus').value;
    let descriptionCpus = document.getElementById('description-cpus').value;
    let coresCpus = document.getElementById('cores-cpus').value;
    let integratedGpuCpus = document.getElementById('integratedgpu-cpus').checked;
    let priceCpus = document.getElementById('price-cpus').value;
    if (!integratedGpuCpus) {
        integratedGpuCpus = false;
    }
    let products = await getCpus('POST', {
    "name":nameCpus,
    "cores":coresCpus,
    "haveIntegratedGPU":integratedGpuCpus,
    "price":priceCpus
    });
    console.log(products);

});
