function getAttributes($node) {
    var attrs = {};
    $.each($node[0].attributes, function (index, attribute) {
        attrs[attribute.name] = attribute.value;
    });

    return attrs;
}

const card = $(".card");
card.hide()

// Product edit button code {{{
const editButton = $(".edit-button");

// Due to ASP.NET's wonderful scoped styles, we need to give every
// element we edit/create the same hash that other elements have.
const cssHash = Object.keys(getAttributes($(".list-header-text")))[0];

// Product ID for editing POST request
const productId = $(".item-desc")[0].textContent;

editButton.one("click", function() {

    // Change the pencil icon to the checkmark icon
    $(".edit-button").html(`<svg ${cssHash} stroke=\"currentColor\" fill=\"currentColor\" stroke-width=\"0\" viewBox=\"0 0 24 24\" focusable=\"false\" class=\"edit-button-icon\" aria-hidden=\"true\" height=\"1em\" width=\"1em\" xmlns=\"http://www.w3.org/2000/svg\"><path fill=\"none\" d=\"M0 0h24v24H0z\"></path><path d=\"M9 16.2L4.8 12l-1.4 1.4L9 19 21 7l-1.4-1.4L9 16.2z\"></path></svg>`);
    $(".edit-button").removeAttr("type").attr("type", "submit");

    let listContent = document.querySelector(".list-content");

    let form = document.createElement("form");
    form.style.width = "100%";
    form.style.marginTop = "var(--chakra-space-2)";
    form.appendChild(listContent);

    document.querySelector(".list").appendChild(form);

    let kvs = document.querySelectorAll(".list-item-content")
    for (let kv of kvs) {
        // Key item of the key-value pairs (used for name in input tag)
        let k = kv.children[0];
        // Value item of the key-value pairs (right item in the table)
        let v = kv.children[1];
        let val = v.textContent.trim();

        let inputName = k.textContent.trim().toLowerCase().replace(/ /g, "_");

        if (val === "True" || val === "False") {
            val = $.parseJSON(val.toLowerCase());
            v.innerHTML = `<input ${cssHash} ${val ? "checked" : ""} type="checkbox" name="${inputName}" aria-label="${inputName}">`
        } else {
            v.innerHTML = `<input ${cssHash} name="${inputName}" aria-label="${inputName}" placeholder="Unset" class="list-item-kv-input" value="${val}">`;
        }
    }

    $(":checkbox").on("change", function() {
        this.value = this.checked;
    })

    editButton.one("click", (e) => {
        e.preventDefault()

        const data = {};
        $.each($("input"), (i, input) => {
            const key = $(input).parent().parent().children()[0].id;

            let val = $(input).val();
            if (val === "on") val = true;
            switch (val) {
                case "true":
                    val = true;
                    break;
                case "false":
                    val = false;
                    break;
            }

            data[key] = val;
        });
        fetch(`https://gdos-api.alyxia.dev/products/${productId}`, {
            method: "PATCH",
            body: JSON.stringify(data),
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(res => {
                if (!res.ok) {
                    console.error("cock")
                    card.show();
                    card.textContent = "Er ging iets fout. Weet je zeker dat alle waardes correct zijn?"
                } else {
                    location.reload();
                }
            })
    })
})
// }}}