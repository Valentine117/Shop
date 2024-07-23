package com.apple.shop.item;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemController {
    @GetMapping("")
    String list(Model model) {
        model.addAttribute("name", "홍길동");
        return "list.html";
    }
}
