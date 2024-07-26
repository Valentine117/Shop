package com.apple.shop.detail;

import com.apple.shop.items.Item;
import com.apple.shop.items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/details")
public class details {
    private final ItemRepository itemRepository;

    @Autowired
    details(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/{id}")
    String detail(@PathVariable Integer id, Model model) {
        Optional<Item> result = itemRepository.findById(id);
        if (result.isPresent()) {
            model.addAttribute("data", result.get());
            return "detail.html";
        } else {
            return "redirect:/list";
        }
    }
}
