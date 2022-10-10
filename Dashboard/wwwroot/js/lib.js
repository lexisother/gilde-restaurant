export function getAttributes($node) {
    var attrs = {};
    var iterOver = $node[0] ?? $node;
    $.each(iterOver.attributes, function (index, attribute) {
        attrs[attribute.name] = attribute.value;
    });

    return attrs;
}