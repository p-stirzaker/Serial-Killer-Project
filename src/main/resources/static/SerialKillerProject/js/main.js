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
