package com.store.Store.controller;

import com.store.Store.models.Address;
import com.store.Store.repository.MysqlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StoreController {
    @Autowired
    private MysqlRepository mysqlRepository;
    @GetMapping("/getAll")
    public List<Address> getAll(){
        List<Address> l = mysqlRepository.findAll();
        return l;
    }

    @GetMapping("/getById/{id}")
    public Address getById(@PathVariable int id){
        Address a = mysqlRepository.findById(id).orElse(null);
        return a;
    }

    @PostMapping("/insert")
    public Address add(@RequestBody Address a){
        if(a.getNumber() !=0 && a.getPostcode()!=null && a.getStreet()!=null){
            mysqlRepository.save(a);
            return a;
        } else {
            return null;
        }


    }

    @PutMapping("/update/{id}")
    public Address upDate(@PathVariable int id, @RequestBody Address a){
        Address ad = mysqlRepository.findById(id).orElse(null);
        if(ad!=null){
            if(a.getNumber() !=0 && a.getPostcode()!=null && a.getStreet()!=null){
                ad.setNumber(a.getNumber());
                ad.setStreet(a.getStreet());
                ad.setPostcode(a.getPostcode());
                mysqlRepository.save(ad);
                return ad;
            }
        }
        return null;
    }

    @DeleteMapping("/deleteAddress")
    public String delete(@RequestParam int id){
        Address a = mysqlRepository.findById(id).orElse(null);
        if(a!=null){
            mysqlRepository.delete(a);
            return "delete successfully";
        }
        return "not found";
    }

}
