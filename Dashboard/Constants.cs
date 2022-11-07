namespace Dashboard;

public static class Constants
{
    public static string API_HOST = Environment.GetEnvironmentVariable("API_HOST");
    public static string API_BASE = API_HOST != null ? API_HOST : "https://gdos-api.alyxia.dev";
}