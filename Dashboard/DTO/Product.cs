namespace Dashboard.DTO;

public class Product
{
    public int id { get; set; }
    public string name { get; set; }
    public string description { get; set; }
    public string price { get; set; }
    public bool spanish { get; set; }
    public bool warm { get; set; }
    public bool cold { get; set; }
    public bool vega { get; set; }
    public string created_at { get; set; }
    public string updated_at { get; set; }
}
