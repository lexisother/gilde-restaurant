using Dashboard.DTO;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Dashboard.Pages;

public class ProductsModel : PageModel
{
    private HttpClient _client = new();

    public string GetElementType(string key)
    {
        switch (key)
        {
            case "name":
                return "text";
            case "description":
                return "text";
            case "price":
                return "int";
            case "spanish":
                return "bool";
            case "warm":
                return "bool";
            case "cold":
                return "bool";
            case "vega":
                return "bool";
            default:
                return "KEY_NAME_INVALID";
        }
    }

    public string NormalizeKeyName(string key)
    {
        switch (key)
        {
            case "name":
                return "Naam";
            case "description":
                return "Beschrijving";
            case "price":
                return "Prijs";
            case "spanish":
                return "Spaans";
            case "warm":
                return "Warm";
            case "cold":
                return "Koud";
            case "vega":
                return "Vega";
            default:
                return "KEY_NAME_INVALID";
        }
    }

    public void OnGet()
    {
        // TODO: Separate into API wrapper class
        var products = _client.GetFromJsonAsync<List<Product>>("https://gdos-api.alyxia.dev/products");
        ViewData["products"] = products.Result;
    }
}