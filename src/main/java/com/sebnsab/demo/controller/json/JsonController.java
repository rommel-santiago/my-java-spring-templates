package com.sebnsab.demo.controller.json;

import com.sebnsab.demo.model.relationship.Transaction;
import com.sebnsab.demo.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class JsonController {

    @Autowired
    private TransactionRepository transactionRepository;

    @RequestMapping(value = "/listing", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public List<Transaction> getListing() {

        List<Transaction> transactions = transactionRepository.findAll();
        return transactions;
    }

}
