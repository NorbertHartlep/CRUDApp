document.addEventListener('DOMContentLoaded', (event) => {
    // Load products from localStorage on page load
    loadProducts();

    document.querySelectorAll('.add-button').forEach(button => {
        button.addEventListener('click', () => {
            const formId = 'form-' + button.id.split('-')[2];
            const form = document.getElementById(formId);
            form.style.display = form.style.display === 'none' || form.style.display === '' ? 'block' : 'none';
        });
    });

    // Add event listeners to the add buttons
    document.getElementById('laptop-adder').addEventListener('click', () => addProduct('laptops'));
    document.getElementById('computer-adder').addEventListener('click', () => addProduct('computers'));
    document.getElementById('gpu-adder').addEventListener('click', () => addProduct('gpus'));
    document.getElementById('ram-adder').addEventListener('click', () => addProduct('rams'));
    document.getElementById('cpu-adder').addEventListener('click', () => addProduct('cpus'));
    document.getElementById('motherboard-adder').addEventListener('click', () => addProduct('motherboards'));
});

async function addProduct(category) {
    const name = document.getElementById('name-' + category)?.value || '';
    const description = document.getElementById('description-' + category)?.value || '';
    const cpu = document.getElementById('cpu-' + category)?.value || '';
    const gpu = document.getElementById('gpu-' + category)?.value || '';
    const ports = document.getElementById('ports-' + category)?.value || '';
    let frequency = document.getElementById('frequency-' + category)?.value || '';
    const cores = document.getElementById('cores-' + category)?.value || '';
    const integratedgpu = document.getElementById('integratedgpu-' + category)?.checked ? 'Tak' : 'Nie';
    let price = document.getElementById('price-' + category)?.value || '';

    if (name && description && price) {
        const products = JSON.parse(localStorage.getItem('products')) || [];
        const product = { category, name, description, cpu, gpu, ports, frequency, cores, integratedgpu, price };
        products.push(product);
        localStorage.setItem('products', JSON.stringify(products));

        try {
            switch(category) {
                case 'laptops':
                    await makeApiRequest('POST', '/laptops', {
                        "name": name,
                        "description": description,
                        "cpu": cpu,
                        "gpu": gpu,
                        "price": price
                    });
                    break;
                case 'computers':
                    await makeApiRequest('POST', '/computers', {
                        "name": name,
                        "description": description,
                        "cpu": cpu,
                        "gpu": gpu,
                        "price": price
                    });
                    break;
                case 'gpus':
                    frequency = parseInt(frequency);
                    if (isNaN(frequency)) {
                        frequency = 0;
                    }
                    await makeApiRequest('POST', '/gpus', {
                        "name": name,
                        "description": description,
                        "frequency": frequency,
                        "price": price
                    });
                    break;
                case 'rams':
                    frequency = parseInt(frequency);
                    price = parseInt(price);
                    if (isNaN(frequency)) {
                        frequency = 0;
                    }
                    if (isNaN(price)) {
                        price = 0;
                    }
                    await makeApiRequest('POST', '/rams', {
                        "name": name,
                        "description": description,
                        "frequency": frequency,
                        "price": price
                    });
                    break;
                case 'cpus':
                    await makeApiRequest('POST', '/cpus', {
                        "name": name,
                        "description": description,
                        "cores": cores,
                        "haveIntegratedGPU": integratedgpu,
                        "price": price
                    });
                    break;
                case 'motherboards':
                    await makeApiRequest('POST', '/motherboards', {
                        "name": name,
                        "description": description,
                        "availablePorts": ports,
                        "price": price
                    });
                    break;
                default:
                    console.log("Unknown category.");
                    // Place your code for handling unknown categories here
            }
        } catch (error) {
            console.error("Error adding product to API:", error);
            alert("Wystąpił błąd podczas dodawania produktu do API.");
        }

        appendProductToTable(product);

        // Reset and hide the form
        document.getElementById('name-' + category).value = '';
        document.getElementById('description-' + category).value = '';
        if (document.getElementById('cpu-' + category)) document.getElementById('cpu-' + category).value = '';
        if (document.getElementById('gpu-' + category)) document.getElementById('gpu-' + category).value = '';
        if (document.getElementById('ports-' + category)) document.getElementById('ports-' + category).value = '';
        if (document.getElementById('frequency-' + category)) document.getElementById('frequency-' + category).value = '';
        if (document.getElementById('cores-' + category)) document.getElementById('cores-' + category).value = '';
        if (document.getElementById('integratedgpu-' + category)) document.getElementById('integratedgpu-' + category).checked = false;
        document.getElementById('price-' + category).value = '';
        document.getElementById('form-' + category).style.display = 'none';
    } else {
        alert('Proszę wypełnić wszystkie wymagane pola.');
    }
}

function appendProductToTable(product) {
    const tableBody = document.getElementById('product-table-body');
    const newRow = document.createElement('tr');

    newRow.innerHTML = `
        <td>${product.category.charAt(0).toUpperCase() + product.category.slice(1)}</td>
        <td>${product.name}</td>
        <td>${product.description}</td>
        <td>${product.cpu}</td>
        <td>${product.gpu}</td>
        <td>${product.ports}</td>
        <td>${product.frequency} MHz</td>
        <td>${product.cores}</td>
        <td>${product.integratedgpu}</td>
        <td>${product.price} zł</td>
    `;

    tableBody.appendChild(newRow);
}

function loadProducts() {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    products.forEach(product => appendProductToTable(product));
}

function sortProductsByCategory(category) {
    const products = JSON.parse(localStorage.getItem('products')) || [];
    const filteredProducts = products.filter(product => product.category === category);
    filteredProducts.sort((a, b) => a.name.localeCompare(b.name));

    const tableBody = document.getElementById('product-table-body');
    tableBody.innerHTML = '';
    filteredProducts.forEach(product => appendProductToTable(product));
}
