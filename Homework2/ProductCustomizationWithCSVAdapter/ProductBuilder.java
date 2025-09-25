public interface ProductBuilder {
    public ProductBuilder setAttribute(String key, String value);
    public Product build();
}