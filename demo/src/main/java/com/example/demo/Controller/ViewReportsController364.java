package com.example.demo.Controller;



import com.example.demo.Entity.document.BorrowDocument364;
import com.example.demo.Entity.document.Document364;
import com.example.demo.Entity.document.DocumentsByTimeBorrow364;
import com.example.demo.Entity.dto.ReceiptDTO;
import com.example.demo.Entity.receipt.Receipt364;
import com.example.demo.Service.ServiceLibman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewReportsController364 {

    @Autowired
    ServiceLibman serviceLibman;

    @GetMapping("/home/manager/viewReport")
    public String getViewReport() {
        return "manager/ViewReportFrm364.html";
    }

    @GetMapping("/home/manager/viewDocumentByTimeBorrow")
    public String viewDocumentByTimeBorrow() {
        return "manager/ViewDocumentsByTimeBorrowFrm364.html";
    }

    @GetMapping("/home/manager/viewTimeBorrowDetail")
    public String viewTimeBorowDetails() {
        return "manager/ViewTimeBorrowDetailsFrm364.html";
    }

    @GetMapping("/home/manager/viewReceiptDetails")
    public String viewReceiptDetailsFrm364() {
        return "manager/viewReceiptDetailsFrm364.html";
    }

    @PostMapping("/viewDocumentsFromDateToDate")
    @ResponseBody
    public List<Document364> viewDocumentsFromDateToDate(@RequestBody DocumentsByTimeBorrow364 obj) {
        return serviceLibman.viewDocumentsFromDateToDate(obj);
    }

    @PostMapping("/getDocumentTransactions")
    @ResponseBody
    public List<BorrowDocument364> getDocumentTransactions(@RequestBody DocumentsByTimeBorrow364 obj) {
        return serviceLibman.getDocumentTransactions(obj);
    }

    @PostMapping("/getReceiptDetails")
    @ResponseBody
    public List<ReceiptDTO> getReceiptDetails(@RequestBody Receipt364 obj) {
//        return serviceLibman.getReceiptDetails(obj);
        return null;
    }

}
