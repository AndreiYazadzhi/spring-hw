import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.model.User;
import spring.service.UserService;

public class Application {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        User bob = new User("bobobob@bob.cob");
        User alice = new User("alice@ali.ce");
        userService.add(bob);
        userService.add(alice);
        userService.listUsers().forEach(System.out::println);
    }
}
