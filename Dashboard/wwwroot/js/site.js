import "./hashFix.js";

// Constants {{{
export const API_BASE = document.querySelector("html").attributes["api-base"].textContent;

// Metavariable fuckery. We love.
// __ = Defined by user in file.
// _  = temporary variable for exporting.
let _PRODUCT_EDITOR;
let _USER_EDITOR;
try {
    _PRODUCT_EDITOR = __PRODUCT_EDITOR;
    _USER_EDITOR = __USER_EDITOR;
} catch(e) {}
export const PRODUCT_EDITOR = _PRODUCT_EDITOR;
export const USER_EDITOR = _USER_EDITOR;
// }}}

try {
    if (PRODUCT_EDITOR || USER_EDITOR) {
        import("./editItem.js");
    }
} catch(e) {}