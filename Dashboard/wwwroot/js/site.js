// Please see documentation at https://docs.microsoft.com/aspnet/core/client-side/bundling-and-minification
// for details on configuring this project to bundle and minify static web assets.

function getAttributes($node) {
    var attrs = {};
    $.each($node[0].attributes, function (index, attribute) {
        attrs[attribute.name] = attribute.value;
    });

    return attrs;
}

// Product edit button code {{{
const editButton = $(".edit-button")

// Due to ASP.NET's wonderful scoped styles, we need to give every
// element we edit/create the same hash that other elements have.
const cssHash = Object.keys(getAttributes($(".list-header-text")))[0];

editButton.on("click", function() {
    // Change the pencil icon to the checkmark icon
    $(".edit-button").html(`<svg ${cssHash} stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 24 24\" focusable=\"false\" class=\"edit-button-icon\" aria-hidden=\"true\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path fill=\"none\" d=\"M0 0h24v24H0z\"></path><path d=\"M9 16.2L4.8 12l-1.4 1.4L9 19 21 7l-1.4-1.4L9 16.2z\"></path></svg>`)

    let listContent = document.querySelector(".list-content");

    let form = document.createElement("form")
    form.style.width = "100%";
    form.appendChild(listContent)
    console.log(form);
    
    document.querySelector(".list").appendChild(form);
    
    let kvs = document.querySelectorAll(".list-item-content")
    for (let kv of kvs) {
        // Key item of the key-value pairs (used for name in input tag)
        let k = kv.children[0];
        // Value item of the key-value pairs (right item in the table)
        let v = kv.children[1];
        
        let inputName = k.textContent.trim().toLowerCase().replace(/ /g, "_")
        v.innerHTML = `<input ${cssHash} name="${inputName}" aria-label="${inputName}" placeholder="Unset" class="list-item-kv-input" value="${v.textContent.trim()}">`
    }
})
// }}}
