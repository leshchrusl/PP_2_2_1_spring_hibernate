package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   User getUserByCarModelAndSeries(String carModel, int carSeries);
   List<User> listUsers();
}
