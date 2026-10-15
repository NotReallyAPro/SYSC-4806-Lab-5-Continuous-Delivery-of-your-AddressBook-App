package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringApplication {

    /*
    private static final Logger logger = LoggerFactory.getLogger(SpringApplication.class);

    @Bean
    public CommandLineRunner demo(AddressBookRepository bookRepository, BuddyInfoRepository buddyRepository) {
        return (args) -> {
            // -------------------------
            // BuddyInfo tests
            // -------------------------

            logger.info("=== BuddyInfo tests ===");

            // save a few buddies
            buddyRepository.save(new BuddyInfo("John Doe", "1 Street Ave.", "(111) 111-1111"));
            buddyRepository.save(new BuddyInfo("Jane Doe", "2 Street Ave.", "(111) 111-1112"));

            // fetch all buddies
            logger.info("Buddies found with findAll():");
            logger.info("-----------------------------");
            buddyRepository.findAll().forEach(buddy -> {
                logger.info(buddy.toString());
            });
            logger.info("");

            // fetch an individual buddy by ID
            Optional<BuddyInfo>buddy = buddyRepository.findById(Integer.valueOf(1));
            logger.info("Buddy found with findById(1):");
            logger.info("-----------------------------");
            buddy.ifPresent(b -> logger.info(b.toString()));
            logger.info("");

            // fetch buddies by address
            logger.info("Buddy found with findByAddress('742 Evergreen Terrace'):");
            logger.info("--------------------------------------------------------");
            buddyRepository.findByAddress("742 Evergreen Terrace").forEach(simpson -> {
                logger.info(simpson.toString());
            });
            logger.info("");

            // -------------------------
            // AddressBook tests
            // -------------------------

            logger.info("=== AddressBook tests ===");

            // If empty, add buddies to an address book then save the address book
            AddressBook book = new AddressBook();
            book.addBuddy(new BuddyInfo("Homer", "742 Evergreen Terrace", "(939) 555-0113"));
            book.addBuddy(new BuddyInfo("Marge", "742 Evergreen Terrace", "(939) 555-0113"));
            book.addBuddy(new BuddyInfo("Bart", "742 Evergreen Terrace", "(939) 555-0113"));
            book.addBuddy(new BuddyInfo("Lisa", "742 Evergreen Terrace", "(939) 555-0113"));
            book.addBuddy(new BuddyInfo("Maggie", "742 Evergreen Terrace", "(939) 555-0113"));
            bookRepository.save(book);

            // fetch all buddies in an address book
            AddressBook springfield = bookRepository.findAll().iterator().next();
            logger.info("Buddies found in address book {} with findAll():", springfield.getId());
            logger.info("-----------------------------------------------");
            for(BuddyInfo b : springfield.getBuddies()) {
                logger.info(b.toString());
            }
            logger.info("");
        };
    }
*/

    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }
}
