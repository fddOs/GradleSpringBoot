package mybatis;

import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

//使用注解标识一个Mybatis的接口，Mybatis会自动寻找这个接口
@Mapper
public interface ITestDao {
	@Select("select * from user")
	public Map<String, Object> find();

	@Insert("insert into user(username,password) values(#{username},#{password})")
	public int insert(@Param("username") String username, @Param("password") String password);
}
