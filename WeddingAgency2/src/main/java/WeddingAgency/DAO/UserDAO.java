package WeddingAgency.DAO;
import WeddingAgency.Models.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.xml.bind.SchemaOutputResolver;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Repository
public class UserDAO {
    JdbcTemplate template;
    private static final Logger logger= LoggerFactory.getLogger(UserDAO.class);

    public List<User> getAllUsers(){
        logger.info("Выполнение метода getAllUsers для вывода всех пользователей");
        try{
            return template.query("select * from user",new RowMapper<User>(){

                public User mapRow(ResultSet rs, int row) throws SQLException {
                    User u =  new User();
                    u.setUserId(rs.getInt("userId"));
                    u.setLogin(rs.getString("login"));
                    u.setPassword(rs.getString("password"));
                    u.setEmail(rs.getString("email"));
                    return u;
                }
            });

        }catch (Exception e){
            logger.error("Ошибка при выполнении метода getAllUsers: ", e);
            return null;
        }
    }

    public List<User> getByCategory(int category){
        logger.info("Выполнение метода getByCategory для вывода организаторов по категориям");
        String sql="select * from user where category=?";
        try{
            List<User> org  = template.query(sql,new Object[]{category}, new BeanPropertyRowMapper<User>(User.class));
            return org;
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода getByCategory: ", e);
            return null;
        }
    }

    public User getUserById(int idUser){
        logger.info("Выполнение метода getUserById - получаем информацию о конкретном пользователе");
        String query="select * from user where userId=?";
        try{
            return template.queryForObject(query, new Object[]{idUser}, new BeanPropertyRowMapper<User>(User.class));
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода getUserById: ", e);
            return null;
        }
    }
    public int update(User user){
        logger.info("Выполнение метода update - изменение данных о пользователе");
        String query="update user set login=?, password=?, email=? where userId=?";
        Object[] params = {user.getLogin(), user.getPassword(), user.getEmail(), user.getUserId()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода update: ", e);
            return -1;
        }
    }
    public int insert(User user){
        logger.info("Выполнение метода insert - добавление нового пользователя");
        String query="insert into user(login, password, email) values (?, ?, ?)";
        Object[] params = {user.getLogin(), user.getPassword(), user.getEmail()};
        int[] types = {Types.VARCHAR, Types.VARCHAR, Types.VARCHAR};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода insert: ", e);
            return -1;
        }
    }

    public int delete(int idUser){
        logger.info("Выполнение метода delete - удаление пользователя");
        String query="delete from user where userId=?";
        Object[] params = {idUser};
        int[] types = {Types.INTEGER};
        try {
            return template.update(query,params,types);
        }catch (Exception e) {
            logger.error("Ошибка при выполнении метода delete: ", e);
            return -1;
        }
    }

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
}
