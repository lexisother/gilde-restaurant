using System.Net;
using Dashboard.DTO;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.RazorPages;

namespace Dashboard.Pages;

public class IndexModel : PageModel
{
    private readonly ILogger<IndexModel> _logger;
    private HttpClient _client = new();

    public IndexModel(ILogger<IndexModel> logger)
    {
        _logger = logger;
    }

    public void OnGet()
    {
        var products = _client.GetFromJsonAsync<List<Product>>("https://gdos-api.alyxia.dev/products");
        ViewData["products"] = products.Result;
    }
}