package pl.klobut.take_credit.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.klobut.take_credit.domain.models.Credit;
import pl.klobut.take_credit.services.CreditService;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/credit", produces = MediaType.APPLICATION_JSON_VALUE)
public class CreditController {
    private CreditService creditService;

    public CreditController(CreditService creditService) {
        this.creditService = creditService;
    }

    @GetMapping()
    @ResponseBody
    public List<Credit> getCredits() {
        List<Credit> allCredits = creditService.getAllCredits();
        Collections.sort(allCredits, (c1, c2) -> c1.getCreditName().compareTo(c2.getCreditName()));
        return allCredits;
    }

    @PostMapping()
    @ResponseBody
    public String addCredit(@RequestBody Credit credit) {
        creditService.addNewCredit(credit);
        return credit.getCreditName();
    }
}
