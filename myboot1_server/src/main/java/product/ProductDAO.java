package product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository("productdao") 
@Mapper
public interface ProductDAO {
	public List<ProductDTO> productlist();
	public ProductDTO product(int code);
}
