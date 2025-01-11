package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      Car car1 = new Car("model1", 10);
      user1.setCar(car1);

      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      Car car2 = new Car("model2", 20);
      user2.setCar(car2);

      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car3 = new Car("model3", 30);
      user3.setCar(car3);

      User user4 = new User("User4", "Lastname4", "user4@mail.ru");
      Car car4 = new Car("model4", 40);
      user4.setCar(car4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);

      user1 = userService.getUserByCarModelAndSeries("model1", 10);
      System.out.println("_____GET_USER_____");
      System.out.println(user1);
      System.out.println("_____GET_USER_____");
      user2 = userService.getUserByCarModelAndSeries("model2", 20);
      System.out.println("_____GET_USER_____");
      System.out.println(user2);
      System.out.println("_____GET_USER_____");
      user3 = userService.getUserByCarModelAndSeries("model3", 30);
      System.out.println("_____GET_USER_____");
      System.out.println(user3);
      System.out.println("_____GET_USER_____");
      user4 = userService.getUserByCarModelAndSeries("model4", 40);
      System.out.println("_____GET_USER_____");
      System.out.println(user4);
      System.out.println("_____GET_USER_____");

      List<User> users = userService.listUsers();

      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car id = "+user.getCar().getId());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println("___________");
      }

      context.close();
   }
}
