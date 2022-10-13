namespace Dashboard.DTO;

public class User
{
    public int id { get; set; }
    public string name { get; set; }
    public string email { get; set; }
    public string password { get; set; }
    public bool clocked { get; set; }
    public string created_at { get; set; }
    public string updated_at { get; set; }
}