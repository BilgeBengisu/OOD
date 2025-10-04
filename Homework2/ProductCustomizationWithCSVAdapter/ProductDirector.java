import java.util.Map;
import java.util.HashMap;
public class ProductDirector {
    private ProductBuilder builder;

    public ProductDirector(ProductBuilder builder) {
        this.builder = builder;
    }

    public Product construct(Map<String, String> attributes) {
        for (Map.Entry<String, String> entry : attributes.entrySet()) {
            builder.setAttribute(entry.getKey(), entry.getValue());
        }
        return builder.build();
    }
}