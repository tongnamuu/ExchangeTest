package exchange.rate.exchangetest.application.controller;

import exchange.rate.exchangetest.domain.entity.Currency;
import exchange.rate.exchangetest.domain.entity.Remittance;
import exchange.rate.exchangetest.domain.usecase.CreateRemittance;
import exchange.rate.exchangetest.domain.usecase.GetRemittanceList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class RemittanceController {
    private final GetRemittanceList getRemittanceList;
    private final CreateRemittance createRemittance;

    @GetMapping("/remit")
    public String home(Model model) {
        List<Remittance> remittanceList = getRemittanceList.execute().getRemittances();
        model.addAttribute("currencies", Currency.values());
        model.addAttribute("remittanceList", remittanceList);
        return "home";
    }

    @PostMapping("/remit")
    public String remit(@RequestParam Integer amount, @RequestParam Currency currency) {
        createRemittance.execute(amount, currency);
        return "redirect:/remit";
    }
}
