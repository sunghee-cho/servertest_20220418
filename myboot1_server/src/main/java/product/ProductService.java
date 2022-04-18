package product;

import java.util.List;

public interface ProductService {
	public List<ProductDTO> productlist(); //매핑sql id 동일하지 않아도 된다
	public ProductDTO product(int code);
}
