import {getAttributes} from "./lib.js";

for (let item of document.querySelectorAll("img.icon")) {
    const hash = Object.keys(getAttributes($(item).parent()))[0];
    // Fix for ASP.NET not tacking the CSS hash onto img elements with a `~` src.
    item.setAttribute(hash, "");
}