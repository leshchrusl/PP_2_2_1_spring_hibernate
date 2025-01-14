package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   private final SessionFactory sessionFactory;

   @Autowired
   public UserDaoImp(SessionFactory sessionFactory) {
      this.sessionFactory = sessionFactory;
   }

   @Override
   public void add(User user) {

      sessionFactory.getCurrentSession().save(user.getCar());
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   public User getUserByCarModelAndSeries(String carModel, int carSeries) {

      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User as u where " +
                  "u.car.model = :model and u.car.series = :series", User.class);

      query.setParameter("model", carModel);
      query.setParameter("series", carSeries);

      return query.getSingleResult();
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession()
              .createQuery("from User");
      return query.getResultList();
   }

}
