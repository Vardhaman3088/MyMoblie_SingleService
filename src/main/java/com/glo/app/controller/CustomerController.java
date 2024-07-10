package com.glo.app.controller;
import com.glo.app.dto.*;
import com.glo.app.entity.CustomerAddress;
import com.glo.app.entity.SimOffers;
import com.glo.app.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
@RequestMapping("/api/v1")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping("/validateSIM")
    public ResponseEntity<String> validateSIM(@Valid @RequestBody SIMValidationDtoString simValidationDtoString) {
        SIMValidationDto simValidationDto = new SIMValidationDto(simValidationDtoString.getServiceNumber(), simValidationDtoString.getSimNumber());
        return new ResponseEntity<>(customerService.validateSIM(simValidationDto), HttpStatus.OK);

    }

    @PostMapping("/validateBasicdetails")
    public ResponseEntity<String> validateCustomerBasicDetails(@Valid @RequestBody BasicDetailValidationDto basicDetailvalidationDto) {
        String res = customerService.validateBasicDetails(basicDetailvalidationDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PostMapping("/validatePersonalDetails")
    public ResponseEntity<String> validateCustomerPersonalDetails(@Valid @RequestBody PersonalDetailValidationDto personalDetailValidationDto) {
        String res = customerService.validatePersonalDetails(personalDetailValidationDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/updateAddress/{uniqueId}")
    public ResponseEntity<CustomerAddress> updateCustomerAddress(@Valid @RequestBody CustomerAddress customerAddress, @PathVariable Integer uniqueId) {
        customerService.customerAddressValidation(customerAddress, uniqueId);
        return new ResponseEntity<>(customerAddress, HttpStatus.OK);
    }

    @PostMapping("/validateIdentity")
    public ResponseEntity<String> validateCustomerIdentity(@RequestBody CustomeridentityDto customeridentityDto) {
        String res = customerService.customerIdentityValidation(customeridentityDto);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/ShowOffer/{simId}")
    public ResponseEntity<String> ShowOfferWithId(@PathVariable Integer simId){
        SimOffers simOffers = customerService.ShowOfferWithId(simId);
        String ans = ""+simOffers.getCallQty()+"calls "+simOffers.getDataQty() +" Gb for Rs "+simOffers.getCost() + " validity: "+simOffers.getDuration() +" days";
        return new ResponseEntity<>(ans, HttpStatus.OK);
    }

    @GetMapping("/OrderInfo/{uniqueid}")
    public String ShowOrderinfo(@PathVariable Long uniqueid){
        return customerService.ShowOrderinfo(uniqueid);
    }

    @GetMapping("/updateStatus/{simid}")
    public String updateStatus(@PathVariable Integer simid){
        String res = customerService.updateStatus(simid);
        return res;
    }
}
