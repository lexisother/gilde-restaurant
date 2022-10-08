export function getAttributes($node) {
    var attrs = {};
    $.each($node[0].attributes, function (index, attribute) {
        attrs[attribute.name] = attribute.value;
    });

    return attrs;
}