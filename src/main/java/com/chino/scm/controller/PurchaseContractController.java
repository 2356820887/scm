package com.chino.scm.controller;

import com.chino.scm.common.Result;
import com.chino.scm.pojo.PurchaseContract;
import com.chino.scm.service.PurchaseContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/pur-con")
public class PurchaseContractController {
    @Autowired
    private PurchaseContractService purchaseContractService;
    Map<String, Object> data = new HashMap<>();

    @GetMapping("/find-all/{pageNum}/{pageSize}")
    public Result<Map<String, Object>> finAll(@PathVariable Integer pageNum, @PathVariable Integer pageSize) {
        data.put("data", purchaseContractService.findAll(pageNum, pageSize));
        return new Result<>(200, data, "成功");
    }

    @GetMapping("/delete")
    public Result<Map<String, Object>> deletePlan(Integer id) {
        data.put("data", purchaseContractService.deletePlan(id));
        return new Result<>(200, data, "成功");
    }

    @PostMapping("/add")
    public Result<Map<String, Object>> addDetail(@RequestBody PurchaseContract purchaseContract) {
        data.put("data", purchaseContractService.addPlan(purchaseContract));
        return new Result<>(200, data, "成功");
    }

    @PostMapping("/search")
    public Result<Map<String, Object>> search(@RequestBody PurchaseContract purchaseContract) {
        data.put("data", purchaseContractService.search(purchaseContract));
        return new Result<>(200, data, "成功");
    }

    @PostMapping("/update")
    public Result<Map<String, Object>> update(@RequestBody PurchaseContract purchaseContract) {
        data.put("data", purchaseContractService.updatePlan(purchaseContract));
        return new Result<>(200, data, "成功");
    }
}
