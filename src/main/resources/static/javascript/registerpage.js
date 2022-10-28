const registerForm = document.getElementById('register-form')
const registerUsername = document.getElementById('register-username')
const registerPassword = document.getElementById('register-password')

const headers = {
    'Content-type': 'application/json'
}

const baseUrl = 'https://dm-danchowdhury-airline-trips.herokuapp.com/api/trips/v1/user'

const handleSubmit = async (e) => {
    e.preventDefault()

    let bodyObj = {
        username: registerUsername.value,
        password: registerPassword.value
    }

    const response = await fetch(`${baseUrl}/register`, {
        method: "post",
        body: JSON.stringify(bodyObj),
        headers: headers
    }).catch(err => console.error(err.message))

    const responseArr = await response.json()

    if (response.status === 200) {
        window.location.replace(responseArr[0])
    }
}

registerForm.addEventListener("submit", handleSubmit)