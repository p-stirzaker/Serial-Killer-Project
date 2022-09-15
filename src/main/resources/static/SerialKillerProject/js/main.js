"use strict";

let createManyCards = (serialKillers) => {
    let cardsContainer = document.getElementById("cards")
    cardsContainer.innerHTML=""
    serialKillers.forEach(serialKiller => {
        let div = document.createElement("div")
        div.classList.add("col")
        div.innerHTML = `
            <div class="card shadow-sm">
            <svg class="bd-placeholder-img card-img-top" width="100%" height="225" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Thumbnail" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#55595c"></rect></svg>

            <div class="card-body">
                <p class="card-text">
                <ul>
                    <li>
                        First name: ${serialKiller.firstName}
                    </li>
                    <li>
                        Last name: ${serialKiller.lastName}
                    </li>
                    <li>
                        Place: ${serialKiller.place}
                    </li>
                    <li>
                        Confirmed kills: ${serialKiller.confirmedKills}
                    </li>
                    <li>
                        Zodiac sign: ${serialKiller.zodiacSign}
                    </li>
                </ul>      
            </p>
                <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                    <button type="button" class="btn btn-sm btn-outline-secondary">Update</button>
                    <button type="button" class="btn btn-sm btn-outline-secondary" data-id="${serialKiller.id}" onclick="del(this)">Delete</button>
                </div>

                </div>
            </div>
            </div>
        `;
        cardsContainer.appendChild(div)
        });
}

let getAll = () => {
    axios.get("http://localhost:8082/SerialKiller/getAll")
    .then(res => {
        console.log(res.data);
        createManyCards(res.data)
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

let del = (serialKiller) => {
    console.log(serialKiller);
    axios.delete(`http://localhost:8082/SerialKiller/delete/${serialKiller.dataset.id}`)
    .then(res => {
        console.log(res.data);
        getAll();
    }).catch(err => console.log(err));
}

let search =() => {
    document.getElementById("cards").innerHTML = ""
    let selected = document.getElementById("search-select").value
    console.log(selected)

    let input = document.getElementById("search-input").value
    console.log(input)

    axios.get(`http://localhost:8082/SerialKiller/${selected}/${input}`)
    .then(res => {
        let data = res.data
        if (Object.prototype.toString.call(data) !== '[object Array]') {
            data = [data]
        }
        createManyCards(data)
    }).catch(err => console.log(err));
}

let selectUpdate = () => {
    let e = document.getElementById("search-select")
    let text = e.options[e.selectedIndex].dataset.help
    console.log(text)
    document.getElementById("search-input").placeholder = text
}

