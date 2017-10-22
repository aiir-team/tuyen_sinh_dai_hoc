package com.project.tuyensinhdaihoc.web_layer.controller.client;

import com.project.tuyensinhdaihoc.data_access_layer.model.Contact;
import com.project.tuyensinhdaihoc.service_layer.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ContactController {

    // Constant
    private final String TEMPLATE_URL_FORM = "client/contact/form";
    private final String TEMPLATE_URL_LIST = "client/contact/list";
    private final String REDIRECT_TO_CONTACT_LIST = "redirect:/contact";

    // Autowired
    private final ContactService contactService;

    @Autowired
    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @GetMapping("/contact")
    public String index(Model model) {
        model.addAttribute("contacts", contactService.findAll());
        return TEMPLATE_URL_LIST;
    }

    @GetMapping("/contact/create")
    public String create(Model model) {
        model.addAttribute("contact", new Contact());
        return TEMPLATE_URL_FORM;
    }

    @PostMapping("/contact/save")
    public String save(@Valid Contact contact, BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return TEMPLATE_URL_FORM;
        }
        contactService.save(contact);
        redirect.addFlashAttribute("success", "Saved contact successfully!");
        return REDIRECT_TO_CONTACT_LIST;
    }

    @GetMapping("/contact/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("contact", contactService.findOne(id));
        return TEMPLATE_URL_FORM;
    }

    @GetMapping("/contact/{id}/delete")
    public String delete(@PathVariable int id, RedirectAttributes redirect) {
        contactService.delete(id);
        redirect.addFlashAttribute("success", "Deleted contact successfully!");
        return REDIRECT_TO_CONTACT_LIST;
    }

    @GetMapping("/contact/search")
    public String search(@RequestParam("q") String q, Model model) {
        if (q.equals("")) {
            return REDIRECT_TO_CONTACT_LIST;
        }

        model.addAttribute("contacts", contactService.search(q));
        return TEMPLATE_URL_LIST;
    }
}
