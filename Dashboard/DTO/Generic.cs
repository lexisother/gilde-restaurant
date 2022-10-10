namespace Dashboard.DTO;

public struct ProductMetaProps
{
    public Product product;

    public static implicit operator ProductMetaProps(Product product)
    {
        return new ProductMetaProps
        {
            product = product
        };
    }
}