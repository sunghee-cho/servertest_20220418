package spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper //sql매핑파일 id명 동일 메소드 실행 가능
@Repository("mybatisdao")
public interface MemberDAO {
	public int insertmember(MemberDTO dto) ;
	public int updatemember(MemberDTO dto) ;
	public int deletemember(String id) ;
	public List<MemberDTO> memberlist();
	public List<MemberDTO> paginglist(int[] limit);
	public List<String> addresssearch(String[] address);
	public MemberDTO member(String id);
}

