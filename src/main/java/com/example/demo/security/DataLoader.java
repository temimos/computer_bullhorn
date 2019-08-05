package com.example.demo.security;

import com.example.demo.Home;
import com.example.demo.Repositories.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.boot.CommandLineRunner;


@Component
public class DataLoader implements CommandLineRunner{
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    HomeRepository homeRepository;

    @Autowired
    UserService userService;

    @Override
    public void run(String... strings) throws Exception{
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));
System.out.println("INSIDE DATALOADER");
        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("kqy@g.gtvtech.com", "Pa$$word2019", "jim", "jimmerson",true,"jim","https://s.gravatar.com/avatar/eb7e8a51c9991b29e55aa29ec68c5702} + '?s=60'}\"\n");
        user.setRoles(Arrays.asList(userRole));
        userService.saveUser(user);
        user = new User("kqy@g.gtvtech.com","Pa$$word2019","Jim","Jimmerson",true,"admin","https://s.gravatar.com/avatar/eb7e8a51c9991b29e55aa29ec68c5702} + '?s=60'}\"\n");
        user.setRoles(Arrays.asList(adminRole));
        userService.saveUser(user);


        User dave = new User("dave45678@gmail.com",
                "password",
                "David",
                "Wolf",
                true,
                "dave",
                "http://gravatar.com/avatar/afd87b3415ef623a1a0337c2b2171949} + '?s=60}\n"
                );
        dave.setRoles(Arrays.asList(adminRole));
        userService.saveUser(dave);

        User may = new User("lpr@s.rv55.com",
                "password",
                "May",
                "Day",
                true,
                "may",
                "https://s.gravatar.com/avatar/5623241a8751fef7598d621664854feb} + '?s=60'}\"\n");
        may.setRoles(Arrays.asList(adminRole));
        userService.saveUser(may);

        Home home = new Home("Mother's Day",
                LocalDateTime.of(2019, 07, 15, 14, 15), "Happy mother day to the most loving mom in the world",
              "https://res.cloudinary.com/queentemi/image/upload/v1564077655/q24gb3dfmqjbgrogcpvc.jpg",user);

        homeRepository.save(home);

        home = new Home("Fathers Day",
                LocalDateTime.of(2019, 06, 15, 14, 15), "Happy fathers day to the most father mom in the world",
                "https://res.cloudinary.com/queentemi/image/upload/v1564077852/jlmzcsoftxcni4rjcjzp.jpg",dave);

        homeRepository.save(home);

        home = new Home("Valentines Day",
                LocalDateTime.of(2019, 02, 14, 05, 06), "I am still looking for someone to come in my life",

                "https://res.cloudinary.com/mhussainshah1/image/upload/v1551323276/java-bootcamp/hebapsmsapt323cll6ak.jpg",
                may);
        homeRepository.save(home);

//        //Add followers
//        dave.addFollower(admin);
//        userRepository.save(admin);
//
//        //Add Following
//        dave.addFollowing(moe);
//        dave.addFollowing(tolani);
//        userRepository.save(dave);
    }

    }


