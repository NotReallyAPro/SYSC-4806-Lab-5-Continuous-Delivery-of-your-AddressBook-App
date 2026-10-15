package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private AddressBookRepository addressBookRepository;

    public AddressBookController(AddressBookRepository addressBookRepository) {
        this.addressBookRepository = addressBookRepository;
    }

    @GetMapping("/addressbooks")
    public String showAddressBook(@RequestParam(name = "id") Integer id, Model model) {
        AddressBook addressBook = addressBookRepository.findById(id).orElseThrow();
        model.addAttribute("addressBook", addressBook);
        return "addressbook";
    }
}
