package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private final AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/")
    public String showAllAddressBook(Model model) {
        model.addAttribute("addressBooks", addressBookRepository.findAll());
        return "list";
    }

    @PostMapping("/addressbooklist")
    public String createAddressBook() {
        addressBookRepository.save(new AddressBook());
        return "redirect:/";
    }

    @GetMapping("/addressbooklist")
    public String showAddressBook(@RequestParam(name = "id") Integer id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        model.addAttribute("addressBook", addressBook);
        model.addAttribute("buddyInfo", new BuddyInfo());
        return "addressbook";
    }

    @PostMapping("/buddies")
    public String addBuddy(@RequestParam(name = "id") Integer id, @ModelAttribute("buddyInfo") BuddyInfo buddyInfo) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();

        addressBook.addBuddy(buddyInfo);
        addressBookRepository.save(addressBook);

        return "redirect:/addressbooklist?id=" + id;
    }
}
