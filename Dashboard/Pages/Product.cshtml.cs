using Dashboard.DTO;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Dashboard.Pages;

public class ProductModel : PageModel
{
    private HttpClient _client = new();

    public void OnGet()
    {
        // TODO: Separate into API wrapper class
        var products = _client.GetFromJsonAsync<List<Product>>("https://gdos-api.alyxia.dev/products");
        ViewData["products"] = products.Result;
    }
}