namespace Dashboard.DTO;

public struct MetaProps
{
    public User user;
    public Product product;

    public static implicit operator MetaProps(Product product)
    {
        return new MetaProps
        {
            product = product
        };
    }

    public static implicit operator MetaProps(User user)
    {
        return new MetaProps
        {
            user = user
        };
    }
}