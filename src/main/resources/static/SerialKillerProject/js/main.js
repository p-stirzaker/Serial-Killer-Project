"use strict";






let getAll = () => {
    axios.get("http://localhost:8082/SerialKiller/getAll")
    .then(res => {
        console.log(res.data);
    }).catch(err => console.log(err));
}

let create = () => {

    let obj = {
        "firstName":"",
        "lastName":"",
        "place":"",
        "confirmedKills": 0,
        "zodiacSign":""
    }

    axios.post("http://localhost:8082/SerialKiller/create,", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let update = () => {

    let obj = {
        "firstName":"",
        "lastName":"",
        "place":"",
        "confirmedKills": 0,
        "zodiacSign":""
    }

    axios.put("http://localhost:8082/SerialKiller/update", obj)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let del = () => {
    axios.delete("http://localhost:8082/SerialKiller/delete/")
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}
let search =() => {
    let selected = document.getElementById("search-select").value
    console.log(selected)

    let input = document.getElementById("search-input").value
    console.log(input)

    axios.get(`http://localhost:8082/SerialKiller/${selected}/${input}`)
    .then(res => {
        console.log(res.data);
        let cardsContainer = document.getElementById("cards")
        let div = document.createElement("div")
        div.classList.add("col")
        div.innerHTML = `
        <div class="card shadow-sm">
        <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect></svg>

        <div class="card-body">
          <p class="card-text">
            <ul>
                <li>
                    First name: ${res.data.firstName}
                </li>
                <li>
                    Last name: ${res.data.lastName}
                </li>
                <li>
                    Place: ${res.data.place}
                </li>
                <li>
                    Confirmed kills: ${res.data.confirmedKills}
                </li>
                <li>
                    Zodiac sign: ${res.data.zodiacSign}
                </li>
            </ul>      
        </p>
          <div class="d-flex justify-content-between align-items-center">
            <div class="btn-group">
              <button type="button" class="btn btn-sm btn-outline-secondary">Update</button>
              <button type="button" class="btn btn-sm btn-outline-secondary">Delete</button>
            </div>

          </div>
        </div>
      </div>
`;
    cardsContainer.appendChild(div)
    }).catch(err => console.log(err));
}

let selectUpdate = () => {
    let e = document.getElementById("search-select")
    let text = e.options[e.selectedIndex].dataset.help
    console.log(text)
    document.getElementById("search-input").placeholder = text
}

