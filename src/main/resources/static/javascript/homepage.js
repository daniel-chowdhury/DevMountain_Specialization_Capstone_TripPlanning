
//Cookie
const cookieArr = document.cookie.split("=")

function handleLogout(){
    let c = document.cookie.split(";");
    for(let i in c){
        document.cookie = /^[^=]+/.exec(c[i])[0]+"=;expires=Thu, 01 Jan 1970 00:00:00 GMT"
    }
}

const userId = cookieArr[1];
const username = cookieArr[2];
if (!userId) {
    window.location.href = "/loginpage.html"
}
let welcome_user = document.getElementById("welcome")
welcome_user.innerHTML = `Welcome back<br>${username}`
const baseUrl = "https://dm-danchowdhury-airline-trips.herokuapp.com/api/trips/v1/"
const headers = {
    'Content-Type': 'application/json'
}


let airline_form = document.getElementById("airline_form")
let airline_select = document.getElementById("airline_select")
let airline_unselect_btn = document.getElementById("airline_unselect_btn")
let airline_p = document.getElementById("airline_selection")
airline_p.textContent = ""

let origin_form = document.getElementById("origin_form")
let origin_select = document.getElementById("origin_select")
let origin_unselect_btn = document.getElementById("origin_unselect_btn")
let origin_p = document.getElementById("origin_selection")
origin_p.textContent= ""

let destination_form = document.getElementById("destination_form")
let destination_select = document.getElementById("destination_select")
let destination_unselect_btn = document.getElementById("destination_unselect_btn")
let destination_p = document.getElementById("destination_selection")
destination_p.textContent= ""

let date_form = document.getElementById("date_form")
let date_select = document.getElementById("date_select")
let date_unselect_btn = document.getElementById("date_unselect_btn")
let date_p = document.getElementById("date_selection")
date_p.textContent= ""

let time_form = document.getElementById("time_form")
let time_select = document.getElementById("time_select")
let time_unselect_btn = document.getElementById("time_unselect_btn")
let time_p = document.getElementById("time_selection")
time_p.textContent= ""

let duration_form = document.getElementById("duration_form")
let duration_select = document.getElementById("duration_select")
let duration_unselect_btn = document.getElementById("duration_unselect_btn")
let duration_p = document.getElementById("duration_selection")
duration_p.textContent= ""

let price_form = document.getElementById("price_form")
let price_select = document.getElementById("price_select")
let price_unselect_btn = document.getElementById("price_unselect_btn")
let price_p = document.getElementById("price_selection")
price_p.textContent= ""

function create_object(){
    let obj = {}
    if (airline_p.textContent !== "") {
        obj.airline = airline_p.textContent
    }
    if (origin_p.textContent !== "") {
        obj.origin_city = origin_p.textContent
    }
    if (destination_p.textContent !== "") {
        obj.destination_city = destination_p.textContent
    }
    if (date_p.textContent !== "") {
        obj.trip_date = date_p.textContent
    }
    if (time_p.textContent !== "") {
        obj.trip_time = time_p.textContent
    }
    if (duration_p.textContent !== "") {
        obj.duration = duration_p.textContent
    }
    if (price_p.textContent !== "") {
        obj.price = price_p.textContent
    }
    return obj
}

get_flight_objs(create_object());

async function get_flight_objs(obj){

     await fetch(`${baseUrl}available`, {
         method: "POST",
         body: JSON.stringify(obj),
         headers: headers
     })
     .then(response => response.json())
     .then(data => populate_dropdowns(data))
    console.log("is it working")
}

function populate_dropdowns(flight_objs) {
    let airline_array = []
    let origin_array = []
    let destination_array = []
    let date_array = []
    let time_array = []
    let duration_array = []
    let price_array = []
    for (let i = 0; i < flight_objs.length; i++) {
        airline_array.push(flight_objs[i].airline)
        origin_array.push(flight_objs[i].origin_city)
        destination_array.push(flight_objs[i].destination_city)
        date_array.push(flight_objs[i].trip_date)
        time_array.push(flight_objs[i].trip_time)
        duration_array.push(flight_objs[i].duration)
        price_array.push(flight_objs[i].price)
    }
    airline_array = [...new Set(airline_array)]
    origin_array = [...new Set(origin_array)]
    destination_array = [...new Set(destination_array)]
    date_array = [...new Set(date_array)]
    time_array = [...new Set(time_array)]
    duration_array = [...new Set(duration_array)]
    price_array = [...new Set(price_array)]
    if (document.querySelector("option")) {
        let options = document.querySelectorAll("option")
        options.forEach(value => value.remove())
    }
    
    for (let i = 0; i <airline_array.length; i++) {
        let b = document.createElement("option")
        b.value = airline_array[i]
        b.innerHTML = airline_array[i]
        airline_select.append(b)
    }
    for (let i = 0; i <origin_array.length; i++) {
        let b = document.createElement("option")
        b.value = origin_array[i]
        b.innerHTML = origin_array[i]
        origin_select.append(b)
    }
    for (let i = 0; i <destination_array.length; i++) {
        let b = document.createElement("option")
        b.value = destination_array[i]
        b.innerHTML = destination_array[i]
        destination_select.append(b)
    }
    for (let i = 0; i <date_array.length; i++) {
        let b = document.createElement("option")
        b.value = date_array[i]
        b.innerHTML = date_array[i]
        date_select.append(b)
    }
    for (let i = 0; i <time_array.length; i++) {
        let b = document.createElement("option")
        b.value = time_array[i]
        b.innerHTML = time_array[i]
        time_select.append(b)
    }
    for (let i = 0; i <duration_array.length; i++) {
        let b = document.createElement("option")
        b.value = duration_array[i]
        b.innerHTML = duration_array[i]
        duration_select.append(b)
    }
    for (let i = 0; i <price_array.length; i++) {
        let b = document.createElement("option")
        b.value = price_array[i]
        b.innerHTML = price_array[i]
        price_select.append(b)
    }
    
}


airline_form.addEventListener("submit", handleSubmit)
origin_form.addEventListener("submit", handleSubmit)
destination_form.addEventListener("submit", handleSubmit)
date_form.addEventListener("submit", handleSubmit)
time_form.addEventListener("submit", handleSubmit)
duration_form.addEventListener("submit", handleSubmit)
price_form.addEventListener("submit", handleSubmit)

function handleSubmit(e) {
    e.preventDefault()
    e.target.childNodes[5].childNodes[1].textContent = e.target.childNodes[1].value
    //console.log(e.target.childNodes)
    get_flight_objs(create_object())
}


airline_unselect_btn.addEventListener("click", unselect)
origin_unselect_btn.addEventListener("click", unselect)
destination_unselect_btn.addEventListener("click", unselect)
date_unselect_btn.addEventListener("click", unselect)
time_unselect_btn.addEventListener("click", unselect)
duration_unselect_btn.addEventListener("click", unselect)
price_unselect_btn.addEventListener("click", unselect)

function unselect(e) {
    e.preventDefault()
    e.target.parentNode.childNodes[5].childNodes[1].textContent = ""
    get_flight_objs(create_object())
}


// ------------------------------------------------------------------------------------------------------------------------------------- //

get_booked_flights()

let add_flight_btn = document.getElementById("add_flight_btn")
let flight_container = document.getElementById("booked_trip_container")

add_flight_btn.addEventListener("click", add_flight)


function add_flight(e) {
    e.preventDefault()
    if (airline_p.textContent === "" || origin_p.textContent === "" || destination_p.textContent === "" || date_p.textContent === "" || time_p.textContent === "" || duration_p.textContent === "" || price_p.textContent === "") {
        alert("Please select all the options for flight")
    } else {
        add_booked_flight(create_object())
    }
}

async function add_booked_flight(obj) {
    const response = await fetch(`${baseUrl}booked/${userId}`, {
        method: "POST",
        body: JSON.stringify(obj),
        headers: headers
    })
    .catch(err => console.log(err))
    if (response.status == 200) {
        get_booked_flights();
    }
}


async function get_booked_flights(){

     await fetch(`${baseUrl}booked/${userId}`, {
         method: "GET",
         headers: headers
     })
     .then(response => response.json())
     .then(data => create_booked_flights(data))
    //console.log("is it working")
}



function create_booked_flights(array) {
    flight_container.innerHTML = ''
    for (let i = 0; i < array.length; i++) {
       if (i%2 === 0) {
          let flight_row_pre = document.createElement("div")
          flight_row_pre.classList.add("spacer_two")
          let flight_row = document.createElement("div")
          flight_row.classList.add("row")
          flight_row.classList.add("d-flex")
          flight_row.classList.add("justify-content-around")
          flight_row.setAttribute("id", `row_${i}`)
          let flight_col = document.createElement("div")
          flight_col.classList.add("col-lg-3")
          flight_col.classList.add("col-sm-12")
 
          let flight_card = document.createElement("div")
          flight_card.classList.add("m-2")
          flight_card.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 30rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">Airline is: ${array[i].airline}</p>
                    <p class="card-text">Flying from: ${array[i].origin_city} airport</p>
                    <p class="card-text">Flying to ${array[i].destination_city} airport</p>
                    <p class="card-text">Flight date is: ${array[i].trip_date}</p>
                    <p class="card-text">Flight time is: ${array[i].trip_time}</p>
                    <p class="card-text">Flight duration is: ${array[i].duration}</p>
                    <p class="card-text">Price of ticket is: ${array[i].price}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${array[i].id})">Delete</button>
                    </div>
                </div>
            </div>
          `
          flight_col.append(flight_card)
          flight_row.append(flight_col)
          flight_container.append(flight_row_pre)
          flight_container.append(flight_row)
       } else {
          let flight_row = document.getElementById(`row_${i-1}`)
          let flight_col = document.createElement("div")
          flight_col.classList.add("col-lg-3")
          flight_col.classList.add("col-sm-12")
 
          let flight_card = document.createElement("div")
          flight_card.classList.add("m-2")
          flight_card.innerHTML = `
            <div class="card d-flex" style="width: 18rem; height: 30rem;">
                <div class="card-body d-flex flex-column  justify-content-between" style="height: available">
                    <p class="card-text">Airline is: ${array[i].airline}</p>
                    <p class="card-text">Flying from: ${array[i].origin_city} airport</p>
                    <p class="card-text">Flying to ${array[i].destination_city} airport</p>
                    <p class="card-text">Flight date is: ${array[i].trip_date}</p>
                    <p class="card-text">Flight time is: ${array[i].trip_time}</p>
                    <p class="card-text">Flight duration is: ${array[i].duration}</p>
                    <p class="card-text">Price of ticket is: ${array[i].price}</p>
                    <div class="d-flex justify-content-between">
                        <button class="btn btn-danger" onclick="handleDelete(${array[i].id})">Delete</button>
                    </div>
                </div>
            </div>
          `
          flight_col.append(flight_card)
          flight_row.append(flight_col)
       }
    }
 }

async function handleDelete(flightId){
    await fetch(`${baseUrl}booked/${flightId}`, {
        method: "DELETE",
        headers: headers
    })
        .catch(err => console.error(err))

    get_booked_flights()
}

