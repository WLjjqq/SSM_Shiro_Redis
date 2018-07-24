import com.shiro.entity.User;
import com.shiro.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Create by 六
 * Date:18-7-21
 */
public class UserMapper extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void testSelect(){
        User select = userService.select("soso");
        System.out.println(select);
    }
}
